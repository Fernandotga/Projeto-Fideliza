package br.com.fideliza.app.model;

public enum PerfilType {

    MEMBRO("Membro"),
    MODERADOR("Moderador"),
    ADMINISTRADOR("Administrador");
    private String label;

    private PerfilType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
