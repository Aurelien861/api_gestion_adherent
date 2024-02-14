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

    @GetMapping("/recherche")
    public ResponseEntity<List<Commande>> rechercherCommandes(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam(required = false) String nomMembreClient,
            @RequestParam(required = false) String nomMembreActif,
            @RequestParam(required = false) String materielId) {

        List<Commande> commandes = commandeService.rechercherCommandes(startDate, endDate, nomMembreClient, nomMembreActif, materielId);
        return ResponseEntity.ok(commandes);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> commandes = commandeService.findAll();
        return ResponseEntity.ok(commandes);
    }

}

