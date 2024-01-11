package org.example.Service;
import org.example.Collections.Groupe;
import org.example.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeService {

    private final GroupeRepository groupeRepository;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public Groupe creerGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }
}


