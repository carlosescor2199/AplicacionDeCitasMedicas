package com.mutualser.model;

public class Paciente extends Usuario {

    private String grupoSanguineo;
    private String RH;
    private String profesion;
    private String ocupacion;
    private String tipoAfiliacion;
    private boolean estadoAfiliacion;

    public Paciente(int id, String nombre, String apellido, long numIdentificación, String tipoDoc, String fechaNac, String sexo, String estadoCivil, String direccion, String municipioResidencia, String departamentoResidencia, String tel1, String tel2, String email, String password, String grupoSanguineo, String RH, String profesion, String ocupacion, String tipoAfiliacion, boolean estadoAfiliacion) {
        super(id, nombre, apellido, numIdentificación, tipoDoc, fechaNac, sexo, estadoCivil, direccion, municipioResidencia, departamentoResidencia, tel1, tel2, email, password);
        this.grupoSanguineo = grupoSanguineo;
        this.RH = RH;
        this.profesion = profesion;
        this.ocupacion = ocupacion;
        this.tipoAfiliacion = tipoAfiliacion;
        this.estadoAfiliacion = estadoAfiliacion;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(String tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public boolean isEstadoAfiliacion() {
        return estadoAfiliacion;
    }

    public void setEstadoAfiliacion(boolean estadoAfiliacion) {
        this.estadoAfiliacion = estadoAfiliacion;
    }
}
