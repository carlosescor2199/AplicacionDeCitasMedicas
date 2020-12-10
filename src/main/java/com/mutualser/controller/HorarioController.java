package com.mutualser.controller;

import com.mutualser.model.Horario;
import com.mutualser.model.Medico;

import java.sql.SQLException;
import java.util.List;

public interface HorarioController {
    public void registrarHorario(Horario horario, int idMedico) throws SQLException;
    public List<Horario> consultarHorario(int idMedico);
    public void actualizarHorario(Horario horario) throws SQLException;
    public void eliminarHorario(int id) throws SQLException;
}
