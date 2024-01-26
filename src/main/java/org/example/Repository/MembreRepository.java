package org.example.Repository;
import org.example.Collections.Membre;
import org.example.Enum.TypeMembre;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface MembreRepository extends MongoRepository<Membre, String> {
    Membre findByEmail(String email);

    List<Membre> findByGroupeIdAndTypeMembre(String idGroupe, TypeMembre typeMembre);

    @Override
    Optional<Membre> findById(String s);
}
