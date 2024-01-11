package org.example.Collections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document
public class Commande {
    @Id
    private String id;

    private String nomMembreClient;
    private String nomMembreActif;
    private Date date;
    private float prixTotal;
    private List<String> listeIdMateriaux;
    private String idMembreClient;
    private String idMembreActif;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomMembreClient() {
        return nomMembreClient;
    }

    public void setNomMembreClient(String nomMembreClient) {
        this.nomMembreClient = nomMembreClient;
    }

    public String getNomMembreActif() {
        return nomMembreActif;
    }

    public void setNomMembreActif(String nomMembreActif) {
        this.nomMembreActif = nomMembreActif;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<String> getListeIdMateriaux() {
        return listeIdMateriaux;
    }

    public void setListeIdMateriaux(List<String> listeIdMateriaux) {
        this.listeIdMateriaux = listeIdMateriaux;
    }

    public String getIdMembreClient() {
        return idMembreClient;
    }

    public void setIdMembreClient(String idMembreClient) {
        this.idMembreClient = idMembreClient;
    }

    public String getIdMembreActif() {
        return idMembreActif;
    }

    public void setIdMembreActif(String idMembreActif) {
        this.idMembreActif = idMembreActif;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id='" + id + '\'' +
                ", nomMembreClient='" + nomMembreClient + '\'' +
                ", nomMembreActif='" + nomMembreActif + '\'' +
                ", date=" + date +
                ", prixTotal=" + prixTotal +
                ", listeIdMateriaux=" + listeIdMateriaux +
                ", idMembreClient='" + idMembreClient + '\'' +
                ", idMembreActif='" + idMembreActif + '\'' +
                '}';
    }
}

