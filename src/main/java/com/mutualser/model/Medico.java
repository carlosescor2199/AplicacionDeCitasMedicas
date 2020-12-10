package com.mutualser.model;

public class Medico extends Usuario {
    private String numTarjetaProfesional;
    private String grupoSanguineo;
    private String RH;
    private String especialidadMedica;
    private String EPS;

    public Medico(int id, String nombre, String apellido, long numIdentificacion, String tipoDoc, String fechaNac, String sexo, String estadoCivil, String direccion, String municipioResidencia, String departamentoResidencia, String tel1, String tel2, String email, String password, String numTarjetaProfesional, String grupoSanguineo, String RH, String especialidadMedica, String EPS) {
        super(id, nombre, apellido, numIdentificacion, tipoDoc, fechaNac, sexo, estadoCivil, direccion, municipioResidencia, departamentoResidencia, tel1, tel2, email, password);
        this.numTarjetaProfesional = numTarjetaProfesional;
        this.grupoSanguineo = grupoSanguineo;
        this.RH = RH;
        this.especialidadMedica = especialidadMedica;
        this.EPS = EPS;
    }

    public String getNumTarjetaProfesional() {
        return numTarjetaProfesional;
    }

    public void setNumTarjetaProfesional(String numTarjetaProfesional) {
        this.numTarjetaProfesional = numTarjetaProfesional;
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

    public String getEspecialidadMedica() {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(String especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }
}
