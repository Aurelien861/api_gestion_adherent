package org.example.Service;
import org.example.Collections.Commande;
import org.example.Collections.Materiel;
import org.example.Collections.Membre;
import org.example.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CommandeService {
    @Autowired
    private final CommandeRepository commandeRepository;
    private final MaterielService materielService;
    private final MembreService membreService;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository, MaterielService materielService, MembreService membreService) {
        this.commandeRepository = commandeRepository;
        this.materielService = materielService;
        this.membreService = membreService;
    }

    public Commande passerCommande(String idMembreClient, String idMembreActif, List<String> listeIdMateriaux) {
        Commande commande = new Commande();
        commande.setIdMembreClient(idMembreClient);
        commande.setListeIdMateriaux(listeIdMateriaux);

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


        return commandeRepository.save(commande);
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

}
