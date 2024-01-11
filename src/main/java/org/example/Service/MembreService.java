package org.example.Service;
import org.example.Collections.Membre;
import org.example.Repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreService {

    private final MembreRepository membreRepository;

    @Autowired
    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    public Membre inscrireMembre(Membre membre) {
        return membreRepository.save(membre);
    }
}



