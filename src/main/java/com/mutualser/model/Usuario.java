package com.mutualser.model;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private long numIdentificación;
    private String tipoDoc;
    private String fechaNac;
    private String sexo;
    private String estadoCivil;
    private String direccion;
    private String municipioResidencia;
    private String departamentoResidencia;
    private String tel1;
    private String tel2;
    private String email;
    private String password;

    public Usuario(int id, String nombre, String apellido, long numIdentificación, String tipoDoc, String fechaNac, String sexo, String estadoCivil, String direccion, String municipioResidencia, String departamentoResidencia, String tel1, String tel2, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numIdentificación = numIdentificación;
        this.tipoDoc = tipoDoc;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.municipioResidencia = municipioResidencia;
        this.departamentoResidencia = departamentoResidencia;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getNumIdentificación() {
        return numIdentificación;
    }

    public void setNumIdentificación(Long numIdentificación) {
        this.numIdentificación = numIdentificación;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    public String getDepartamentoResidencia() {
        return departamentoResidencia;
    }

    public void setDepartamentoResidencia(String departamentoResidencia) {
        this.departamentoResidencia = departamentoResidencia;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
