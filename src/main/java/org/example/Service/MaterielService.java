package org.example.Service;
import org.example.Collections.Materiel;
import org.example.Repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterielService {

    private final MaterielRepository materielRepository;

    @Autowired
    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    public Materiel ajouterMateriel(Materiel materiel) {
        return materielRepository.save(materiel);
    }

    public Materiel obtenirMaterielParId(String id) {
        return materielRepository.findById(id).orElse(null); // Renvoie null si le matériel n'est pas trouvé
    }

}


