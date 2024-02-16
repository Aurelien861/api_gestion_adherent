package org.example.Collections;

public class CustomSession {

    private String membreId;

    private String groupeId;

    private String typeMembre;

    public CustomSession(String membreId, String groupeId, String typeMembre) {
        this.membreId = membreId;
        this.groupeId = groupeId;
        this.typeMembre = typeMembre;
    }

    public String getMembreId() {
        return this.membreId;
    }

    public String getGroupeId() {
        return groupeId;
    }

    public String getTypeMembre() {
        return typeMembre;
    }
}
