package com.mutualser.model;

public class Administrativo extends Usuario {
    private String nombreCargo;
    private String codCargo;

    public Administrativo(int id, String nombre, String apellido, long numIdentificacion, String tipoDoc, String fechaNac, String sexo, String estadoCivil, String direccion, String municipioResidencia, String departamentoResidencia, String tel1, String tel2, String email, String password, String nombreCargo, String codCargo) {
        super(id, nombre, apellido, numIdentificacion, tipoDoc, fechaNac, sexo, estadoCivil, direccion, municipioResidencia, departamentoResidencia, tel1, tel2, email, password);
        this.nombreCargo = nombreCargo;
        this.codCargo = codCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(String codCargo) {
        this.codCargo = codCargo;
    }
}
