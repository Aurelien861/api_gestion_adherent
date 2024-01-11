package org.example.Service;
import org.example.Repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterielService {

    @Autowired
    private MaterielRepository materielRepository;

    // Méthodes pour gérer le matériel...
}

