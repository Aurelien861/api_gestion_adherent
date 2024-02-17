package org.example.Collections;

public class CustomSession {

    private String membreId;

    private String membreName;

    private String groupeId;

    private String typeMembre;

    public CustomSession(String membreId, String groupeId, String typeMembre, String membreName) {
        this.membreId = membreId;
        this.groupeId = groupeId;
        this.typeMembre = typeMembre;
        this.membreName = membreName;
    }

    public String getMembreId() {
        return this.membreId;
    }

    public String getMembreName() { return this.membreName; }

    public String getGroupeId() {
        return groupeId;
    }

    public String getTypeMembre() {
        return typeMembre;
    }
}
