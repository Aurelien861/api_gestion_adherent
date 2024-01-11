package org.example.Repository;
import org.example.Collections.Materiel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterielRepository extends MongoRepository<Materiel, String> {
    // Méthodes de recherche personnalisées ici...
}
