package patrimonio.model;

public enum Setor {

    DTI("DTI"),
    ADMINISTRATIVO("Administrativo"),
    FLORESTAL("Florestal"),
    FINANCEIRO("Financeiro"),
    RH("RH"),
    DIRETORIA("Diretoria"),
    JURIDICO("Jurídico"),
    COMUNICACAO("Comunicação"),
    ALMOXARIFADO("Almoxarifado"),
    AUDITORIO("Auditório"),
    LICENCIAMENTO("Licenciamento"),
    RECURSOS_HIDRICOS("Recursos Hídricos"),
    OUTRO("Outro");

    private final String label;

    Setor(String label) { this.label = label; }

    public String getLabel() { return label; }
}
