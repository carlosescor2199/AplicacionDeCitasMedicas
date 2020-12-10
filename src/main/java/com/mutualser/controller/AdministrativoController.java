package com.mutualser.controller;

import com.mutualser.model.Administrativo;
import com.mutualser.model.Medico;

import java.sql.SQLException;
import java.util.List;

public interface AdministrativoController {
    public void registrarAdministrativo(Administrativo administrativo) throws SQLException;
    public Administrativo consultarAdministrativo(int id);
    public List<Administrativo> listarAdministrativo();
    public void actualizarAdministrativo(Administrativo administrativo) throws SQLException;
    public void eliminarAdministrativo(int id) throws SQLException;
}
