package org.example.Service;
import org.example.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    // Méthodes pour gérer les groupes...
}

