package org.example.Service;
import org.example.Collections.Groupe;
import org.example.Collections.Membre;
import org.example.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {

    private final GroupeRepository groupeRepository;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public Groupe creerGroupe(Groupe groupe) {
        Groupe dernierGroupe = groupeRepository.findTopByOrderByNumeroDesc();
        String nouveauNumeroGroupe = genererNumeroGroupe(dernierGroupe != null ? dernierGroupe.getNumero() : null);

        groupe.setNumero(nouveauNumeroGroupe);

        return groupeRepository.save(groupe);
    }

    public void ajouterMembreAuGroupe(String groupeId, String membreId) {
        Groupe groupe = groupeRepository.findById(groupeId)
                .orElseThrow(() -> new RuntimeException("Groupe non trouvé avec l'ID : " + groupeId));
        groupe.getListeIdMembres().add(membreId);
        groupeRepository.save(groupe);
    }

    public Optional<Groupe> obtenirDetailsGroupe(String groupeId) {
        return groupeRepository.findById(groupeId); // Utilise la méthode findById pour récupérer le membre
    }

    private String genererNumeroGroupe(String dernierNomGroupe) {
        String base = "G";
        int numero = 1;

        if (dernierNomGroupe != null && dernierNomGroupe.startsWith(base)) {
            String numeroStr = dernierNomGroupe.substring(base.length());
            try {
                numero = Integer.parseInt(numeroStr) + 1;
            } catch (NumberFormatException e) {

            }
        }

        return base + String.format("%03d", numero);
    }
    public List<Groupe> findAll() {
        return groupeRepository.findAll();
    }


}


