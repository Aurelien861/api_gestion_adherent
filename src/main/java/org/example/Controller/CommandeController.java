package org.example.Controller;

import org.example.Collections.Commande;
import org.example.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    @Autowired
    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping("/passerCommande")
    public ResponseEntity<Commande> passerCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeService.passerCommande(
                commande.getIdMembreClient(),
                commande.getIdMembreActif(),
                commande.getListeIdMateriaux());
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleCommande);
    }

    @GetMapping("/recherche/date")
    public ResponseEntity<List<Commande>> rechercherParDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return ResponseEntity.ok(commandeService.rechercherCommandesParDates(startDate, endDate));
    }

    @GetMapping("/recherche/membreClient")
    public ResponseEntity<List<Commande>> rechercherParMembreClient(@RequestParam String nomMembreClient) {
        return ResponseEntity.ok(commandeService.rechercherCommandesParMembreClient(nomMembreClient));
    }

    @GetMapping("/recherche/membreActif")
    public ResponseEntity<List<Commande>> rechercherParMembreActif(@RequestParam String nomMembreActif) {
        return ResponseEntity.ok(commandeService.rechercherCommandesParMembreActif(nomMembreActif));
    }

    @GetMapping("/recherche/materiel")
    public ResponseEntity<List<Commande>> rechercherParMaterielId(@RequestParam String materielId) {
        return ResponseEntity.ok(commandeService.rechercherCommandesParMaterielId(materielId));
    }
}

