package org.example.Repository;
import org.example.Collections.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommandeRepository extends MongoRepository<Commande, String> {
    // Méthodes de recherche personnalisées ici...
}

