package com.robinfood.demo.enums;

public enum GetFileNameEnum {

    SOLICITUDPARAASESORIACREADA("SolicitudParaAsesoria.xsl"),
    ASESORIACALIFICACIONAFILIADOFALLECIDO("NovedadesAfiliado.xsl"),
    ASESORIACALIFICACIONFINALIZADAORIGENLABORALO("NovedadesAfiliado.xsl"),
    ASESORIACALIFICACIONAFILIADOREINTEGRADO("NovedadesAfiliado.xsl"),
    ASESORIACOMPLETADA("AsesoriaCompletada.xsl");

    private final String filename;

    GetFileNameEnum(String file) {
        this.filename = file;
    }

    public String getFilename() {
        return filename;
    }
}
