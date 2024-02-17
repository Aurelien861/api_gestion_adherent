package org.example.Service;
import org.example.Collections.CustomSession;
import org.example.Collections.Membre;
import org.example.Enum.TypeMembre;
import org.example.Repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembreService {

    private final MembreRepository membreRepository;
    private final GroupeService groupeService;


    @Autowired
    public MembreService(MembreRepository membreRepository, GroupeService groupeService) {
        this.membreRepository = membreRepository;
        this.groupeService = groupeService;
    }

    public Membre inscrireMembre(Membre membre) {
        Membre membreInscrit = membreRepository.save(membre);
        if (membreInscrit.getIdGroupe() != null && !membreInscrit.getIdGroupe().isEmpty()) {
            groupeService.ajouterMembreAuGroupe(membreInscrit.getIdGroupe(), membreInscrit.getId());
        }
        return membreInscrit;
    }

    public CustomSession verifierLogin(String email, String password) {
        Membre membre = membreRepository.findByEmail(email);
        if (membre != null && membre.getPassword().equals(password)) {
            return new CustomSession(membre.getId(), membre.getIdGroupe(), membre.getTypeMembre().toString(), membre.getNom()); // L'email et le mot de passe correspondent
        }
        return new CustomSession("null", "null", "null", "null"); // Aucun membre trouvé avec cet email ou le mot de passe ne correspond pas
    }

    public Optional<Membre> obtenirDetailsMembre(String id) {
        return membreRepository.findById(id); // Utilise la méthode findById pour récupérer le membre
    }

    public List<Membre> obtenirMembresActifsDuGroupe(String idGroupe) {
        return membreRepository.findByGroupeIdAndTypeMembre(idGroupe, TypeMembre.Actif);
    }

    public List<Membre> findAll(String groupId) {
        return membreRepository.findAllByIdGroupe(groupId);
    }


}



