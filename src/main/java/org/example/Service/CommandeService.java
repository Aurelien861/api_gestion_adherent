package org.example.Service;
import org.example.Collections.Commande;
import org.example.Collections.Materiel;
import org.example.Collections.Membre;
import org.example.Repository.CommandeRepository;
import org.example.Repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CommandeService {
    @Autowired
    private final CommandeRepository commandeRepository;
    private final MaterielService materielService;

    private final MaterielRepository materielRepository;

    private final MembreService membreService;

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository, MaterielService materielService, MaterielRepository materielRepository, MembreService membreService, MongoTemplate mongoTemplate) {
        this.commandeRepository = commandeRepository;
        this.materielService = materielService;
        this.materielRepository = materielRepository;
        this.membreService = membreService;
        this.mongoTemplate = mongoTemplate;
    }

    public Commande passerCommande(String idMembreClient, String idMembreActif, List<String> listeIdMateriaux) {
        Commande commande = new Commande();
        commande.setIdMembreClient(idMembreClient);
        commande.setListeIdMateriaux(listeIdMateriaux);
        commande.setDate(new Date());

        Membre membreClient = membreService.obtenirDetailsMembre(idMembreClient)
                .orElseThrow(() -> new RuntimeException("Membre client non trouvé avec l'ID : " + idMembreClient));
        commande.setNomMembreClient(membreClient.getNom());

        List<Membre> membresActifs = membreService.obtenirMembresActifsDuGroupe(membreClient.getIdGroupe());
        if (membresActifs.isEmpty()) {
            throw new RuntimeException("Aucun membre actif trouvé dans le groupe du membre client");
        }

        Random rand = new Random();
        Membre membreActif = membresActifs.get(rand.nextInt(membresActifs.size()));
        commande.setIdMembreActif(membreActif.getId());
        commande.setNomMembreActif(membreActif.getNom());

        float prixTotal = 0;
        for (String idMateriel : listeIdMateriaux) {
            Materiel materiel = materielService.obtenirMaterielParId(idMateriel);
            if (materiel != null) {
                prixTotal += materiel.getPrix();
            } else {
                throw new RuntimeException("Matériel non trouvé avec l'ID : " + idMateriel);
            }
        }
        commande.setPrixTotal(prixTotal);

        Commande commandePassee = commandeRepository.save(commande);
        for (String idMateriel : listeIdMateriaux) {
            Materiel materiel = materielService.obtenirMaterielParId(idMateriel);
            if (materiel != null) {
                materiel.setIdCommande(commandePassee.getId());
                this.materielRepository.save(materiel);
            } else {
                throw new RuntimeException("Matériel non trouvé avec l'ID : " + idMateriel);
            }
        }
        return commandePassee;
    }

    public List<Commande> rechercherCommandesParDates(Date startDate, Date endDate) {
        return commandeRepository.findByDateBetween(startDate, endDate);
    }

    public List<Commande> rechercherCommandesParMembreClient(String nomMembreClient) {
        return commandeRepository.findByNomMembreClient(nomMembreClient);
    }

    public List<Commande> rechercherCommandesParMembreActif(String nomMembreActif) {
        return commandeRepository.findByNomMembreActif(nomMembreActif);
    }

    public List<Commande> rechercherCommandesParMaterielId(String materielId) {
        return commandeRepository.findByMaterielId(materielId);
    }

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public List<Commande> rechercherCommandes(Date startDate, Date endDate, String nomMembreClient, String nomMembreActif, String materielId) {
        Query query = new Query();

        if (startDate != null && endDate != null) {
            query.addCriteria(Criteria.where("date").gte(startDate).lte(endDate));
        }
        if (nomMembreClient != null) {
            query.addCriteria(Criteria.where("nomMembreClient").is(nomMembreClient));
        }
        if (nomMembreActif != null) {
            query.addCriteria(Criteria.where("nomMembreActif").is(nomMembreActif));
        }
        if (materielId != null) {
            query.addCriteria(Criteria.where("materiels.id").is(materielId));
        }

        return mongoTemplate.find(query, Commande.class);
    }

}
