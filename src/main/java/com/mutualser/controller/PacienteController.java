package com.mutualser.controller;

import com.mutualser.model.Paciente;

import java.sql.SQLException;
import java.util.List;

public interface PacienteController {
    public void registrarPaciente(Paciente paciente) throws SQLException;
    public Paciente consultarPaciente(int id);
    public List<Paciente> listarPaciente();
    public void actualizarPaciente(Paciente paciente) throws SQLException;
    public void eliminarPaciente(int id) throws SQLException;
}
