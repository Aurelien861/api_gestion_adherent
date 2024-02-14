package org.example.Controller;
import org.example.Collections.Membre;
import org.example.Service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Membre loginDetails) {
        boolean isValid = membreService.verifierLogin(loginDetails.getEmail(), loginDetails.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Connexion réussie");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de la connexion");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> obtenirMembreParId(@PathVariable String id) {
        return membreService.obtenirDetailsMembre(id)
                .map(ResponseEntity::ok) // Si le membre est trouvé, renvoie le membre avec un statut 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si non trouvé, renvoie 404 Not Found
    }

    @GetMapping("/all")
    public ResponseEntity<List<Membre>> getAllMembres(){
        List<Membre> membres = membreService.findAll();
        return ResponseEntity.ok(membres);
    }

}


