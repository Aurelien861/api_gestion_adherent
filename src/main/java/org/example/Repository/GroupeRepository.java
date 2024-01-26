package org.example.Repository;
import org.example.Collections.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupeRepository extends MongoRepository<Groupe, String> {
    Groupe findTopByOrderByNumeroDesc();
}
