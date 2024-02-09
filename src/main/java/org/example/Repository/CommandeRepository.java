package org.example.Repository;
import org.example.Collections.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface CommandeRepository extends MongoRepository<Commande, String> {
    List<Commande> findByDateBetween(Date startDate, Date endDate);
    List<Commande> findByNomMembreClient(String nomMembreClient);
    List<Commande> findByNomMembreActif(String nomMembreActif);
    @Query("{'materiels.id': ?0}")
    List<Commande> findByMaterielId(String materielId);
}

