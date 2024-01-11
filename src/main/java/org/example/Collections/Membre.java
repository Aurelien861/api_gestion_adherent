package org.example.Collections;
import org.example.Enum.TypeMembre;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Membre {
    @Id
    private String id;

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private TypeMembre typeMembre;
    //on a choisi de stocker les id de groupe dans la collection Membre afin de faire le lien à l'appartenance à un groupe
    private String idGroupe;
    private String idCommande;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeMembre getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(TypeMembre typeMembre) {
        this.typeMembre = typeMembre;
    }

    public String getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(String idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", typeMembre=" + typeMembre +
                ", idGroupe='" + idGroupe + '\'' +
                ", idCommande='" + idCommande + '\'' +
                '}';
    }
}

