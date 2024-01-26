package org.example.Service;
import org.example.Collections.Membre;
import org.example.Repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreService {

    private final MembreRepository membreRepository;
    private final GroupeService groupeService; // Injectez GroupeService

    @Autowired
    public MembreService(MembreRepository membreRepository, GroupeService groupeService) {
        this.membreRepository = membreRepository;
        this.groupeService = groupeService; // Initialisation de GroupeService
    }

    public Membre inscrireMembre(Membre membre) {
        Membre membreInscrit = membreRepository.save(membre);
        // Après avoir enregistré le membre, mettez à jour son groupe pour inclure l'ID de ce membre
        if (membreInscrit.getIdGroupe() != null && !membreInscrit.getIdGroupe().isEmpty()) {
            groupeService.ajouterMembreAuGroupe(membreInscrit.getIdGroupe(), membreInscrit.getId());
        }
        return membreInscrit;
    }
}



