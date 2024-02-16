package org.example.Repository;
import org.example.Collections.Materiel;
import org.example.Collections.Membre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MaterielRepository extends MongoRepository<Materiel, String> {
    // Méthodes de recherche personnalisées ici...

    List<Materiel> findAllByIdGroupeAndIdCommande(String idGroupe, String idCommande);
}
