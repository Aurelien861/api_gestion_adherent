package org.example.Collections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "materiels")
public class Materiel {
    @Id
    private String id;

    private String numeroDeSerie;
    private String marque;
    private String modele;
    private String type;
    private float prix;
    private String idGroupe;
    private String idCommande;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
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
        return "Materiel{" +
                "id='" + id + '\'' +
                ", numeroDeSerie='" + numeroDeSerie + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", type=" + type +
                ", prix=" + prix +
                ", idGroupe='" + idGroupe + '\'' +
                ", idCommande='" + idCommande + '\'' +
                '}';
    }
}
