package com.mutualser.model;


public class Horario {
    private int id;
    private String fechaHorario;
    private  String horaEntrada;
    private String horaSalida;
    private String fechaInicio;
    private String fechaFinal;
    private int idMedico;

    public Horario(int id, String fechaHorario, String horaEntrada, String horaSalida, String fechaInicio, String fechaFinal, int idMedico) {
        this.id = id;
        this.fechaHorario = fechaHorario;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idMedico = idMedico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHorario() {
        return fechaHorario;
    }

    public void setFechaHorario(String fechaHorario) {
        this.fechaHorario = fechaHorario;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
}
