package org.example.Repository;
import org.example.Collections.Membre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MembreRepository extends MongoRepository<Membre, String> {
    // Méthodes de recherche personnalisées ici...
}
