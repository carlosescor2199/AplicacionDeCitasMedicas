package com.mutualser.controller;

import com.mutualser.model.Medico;
import com.mutualser.model.Paciente;

import java.sql.SQLException;
import java.util.List;

public interface MedicoController {
    public void registrarMedico(Medico medico) throws SQLException;
    public Medico consultarMedico(int id);
    public List<Medico> listarMedico();
    public void actualizarMedico(Medico medico) throws SQLException;
    public void eliminarMedico(int id) throws SQLException;
}
