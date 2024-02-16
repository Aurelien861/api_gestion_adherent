package org.example.Controller;
import org.example.Collections.Materiel;
import org.example.Service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiels")
public class MaterielController {

    private final MaterielService materielService;

    @Autowired
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/ajout")
    public ResponseEntity<Materiel> ajouterMateriel(@RequestBody Materiel materiel) {
        Materiel nouveauMateriel = materielService.ajouterMateriel(materiel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauMateriel);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<Materiel>> getAllMateriels() {
        List<Materiel> materiels = materielService.findAll();
        return ResponseEntity.ok(materiels);
    }

}

