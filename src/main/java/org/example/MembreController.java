package org.example;
import org.example.Collections.Membre;
import org.example.Service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membres")
public class MembreController {

    private final MembreService membreService;

    @Autowired
    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @PostMapping("/inscription")
    public ResponseEntity<Membre> inscrireMembre(@RequestBody Membre membre) {
        Membre membreInscrit = membreService.inscrireMembre(membre);
        return ResponseEntity.status(HttpStatus.CREATED).body(membreInscrit);
    }
}


