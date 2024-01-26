package org.example.Controller;

import org.example.Collections.Commande;
import org.example.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

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
}

