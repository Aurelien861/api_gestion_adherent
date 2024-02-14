package org.example.Controller;
import org.example.Collections.Groupe;
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

    @PostMapping("/creation")
    public ResponseEntity<Groupe> creerGroupe(@RequestBody Groupe groupe) {
        Groupe nouveauGroupe = groupeService.creerGroupe(groupe);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauGroupe);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Groupe>> getAllGroupes() {
        List<Groupe> groupes = groupeService.findAll();
        return ResponseEntity.ok(groupes);
    }

}

