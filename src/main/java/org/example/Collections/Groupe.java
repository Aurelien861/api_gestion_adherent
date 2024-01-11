package org.example.Collections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Groupe {
    @Id
    private String id;

    private String numero;
    private String nomGroupe;
    private String ville;
    private String codePostal;
    private List<String> listeIdMembres;
    private List<String> listeIdMateriaux;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public List<String> getListeIdMembres() {
        return listeIdMembres;
    }

    public void setListeIdMembres(List<String> listeIdMembres) {
        this.listeIdMembres = listeIdMembres;
    }

    public List<String> getListeIdMateriaux() {
        return listeIdMateriaux;
    }

    public void setListeIdMateriaux(List<String> listeIdMateriaux) {
        this.listeIdMateriaux = listeIdMateriaux;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "id='" + id + '\'' +
                ", numero='" + numero + '\'' +
                ", nomGroupe='" + nomGroupe + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", listeIdMembres=" + listeIdMembres +
                ", listeIdMateriaux=" + listeIdMateriaux +
                '}';
    }
}
