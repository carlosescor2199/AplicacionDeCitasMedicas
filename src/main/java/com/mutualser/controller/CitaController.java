package com.mutualser.controller;

import com.mutualser.model.Cita;

import java.util.List;

public interface CitaController {
    public void agendarCita(Cita cita);
    public List<Cita> consultarCitas(int id, int idPaciente, int idMedico);
    public List<Cita> listarTodasCitas();
    public void eliminarCita(int id);
}
