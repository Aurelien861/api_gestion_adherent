package org.example.Controller;
import org.example.Collections.CustomSession;
import org.example.Collections.Membre;
import org.example.Service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/membres")
public class MembreController {

    private final MembreService membreService;

    @Autowired
    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/inscription")
    public ResponseEntity<Membre> inscrireMembre(@RequestBody Membre membre) {
        Membre membreInscrit = membreService.inscrireMembre(membre);
        return ResponseEntity.status(HttpStatus.CREATED).body(membreInscrit);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomSession> login(@RequestBody Membre loginDetails) {
        CustomSession customSession = membreService.verifierLogin(loginDetails.getEmail(), loginDetails.getPassword());
        boolean isValid = customSession.getMembreId() != null;
        if (isValid) {
            return ResponseEntity.ok(customSession);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(customSession);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Membre> obtenirMembreParId(@PathVariable String id) {
        return membreService.obtenirDetailsMembre(id)
                .map(ResponseEntity::ok) // Si le membre est trouvé, renvoie le membre avec un statut 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si non trouvé, renvoie 404 Not Found
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<Membre>> getAllMembres(@RequestParam String groupId){
        List<Membre> membres = membreService.findAll(groupId);
        return ResponseEntity.ok(membres);
    }

}


