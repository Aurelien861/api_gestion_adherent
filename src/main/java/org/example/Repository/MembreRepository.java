package org.example.Repository;
import org.example.Collections.Membre;
import org.example.Enum.TypeMembre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MembreRepository extends MongoRepository<Membre, String> {
    Membre findByEmail(String email);

    @Query("{ 'idGroupe' : ?0, 'typeMembre' : ?1 }")
    List<Membre> findByGroupeIdAndTypeMembre(String groupeId, TypeMembre typeMembre);

    List<Membre> findAllByIdGroupe(String s);


    @Override
    Optional<Membre> findById(String s);
}
