package org.example.Controller;
import org.example.Collections.Groupe;
import org.example.Collections.Membre;
import org.example.Service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController {

    private final GroupeService groupeService;

    @Autowired
    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/creation")
    public ResponseEntity<Groupe> creerGroupe(@RequestBody Groupe groupe) {
        Groupe nouveauGroupe = groupeService.creerGroupe(groupe);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauGroupe);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public ResponseEntity<List<Groupe>> getAllGroupes() {
        List<Groupe> groupes = groupeService.findAll();
        return ResponseEntity.ok(groupes);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Groupe> obtenirGroupeParId(@PathVariable String id) {
        return groupeService.obtenirDetailsGroupe(id)
                .map(ResponseEntity::ok) // Si le membre est trouvé, renvoie le membre avec un statut 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si non trouvé, renvoie 404 Not Found
    }

}

