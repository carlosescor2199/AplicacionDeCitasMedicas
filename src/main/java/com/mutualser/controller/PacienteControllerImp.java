package com.mutualser.controller;

import com.mutualser.model.Paciente;

import static com.mutualser.componentes.GetConectionSingleton.getInstance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteControllerImp implements PacienteController {
    @Override
    public void registrarPaciente(Paciente paciente) throws SQLException {
        //Se inserta el paciente usando un procedimiento almacenado
        PreparedStatement ps = getInstance().prepareStatement("call op_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, paciente.getId());
        ps.setString(2, paciente.getNombre());
        ps.setString(3, paciente.getApellido());
        ps.setLong(4, paciente.getNumIdentificacion());
        ps.setString(5, paciente.getTipoDoc());
        ps.setString(6, paciente.getFechaNac());
        ps.setString(7, paciente.getSexo());
        ps.setString(8, paciente.getEstadoCivil());
        ps.setString(9, paciente.getDireccion());
        ps.setString(10, paciente.getMunicipioResidencia());
        ps.setString(11, paciente.getDepartamentoResidencia());
        ps.setString(12, paciente.getTel1());
        ps.setString(13, paciente.getTel2());
        ps.setString(14, paciente.getEmail());
        ps.setString(15, paciente.getPassword());
        ps.setString(16, paciente.getGrupoSanguineo());
        ps.setString(17, paciente.getRH());
        ps.setString(18, paciente.getProfesion());
        ps.setString(19, paciente.getOcupacion());
        ps.setString(20, paciente.getTipoAfiliacion());
        ps.setBoolean(21, paciente.isEstadoAfiliacion());
        ps.setInt(22, 1);
        ps.execute();
    }

    @Override
    public Paciente consultarPaciente(int id) {
        //Obtener todos los pacientes
        Paciente paciente = null;
        try {
            //Hacer consulta
            PreparedStatement ps = getInstance().prepareStatement("select * from usuarios u, paciente p where p.usuario_id = u.id and  u.id = ?;");
            ps.setInt(1, id);
            //Recibir datos
            ResultSet r = ps.executeQuery();
            if(r.next()){
                //Agregar objetos
                paciente = new Paciente(r.getInt(1), r.getString(2), r.getString(3),
                        r.getLong(4), r.getString(5), r.getString(6), r.getString(7),
                        r.getString(8), r.getString(9), r.getString(10), r.getString(11),
                        r.getString(12), r.getString(13), r.getString(14), r.getString(15),
                        r.getString(16), r.getString(17), r.getString(18), r.getString(19),
                        r.getString(20), r.getBoolean(21));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //retornar pacientes
        return paciente;
    }

    @Override
    public List<Paciente> listarPaciente() {
        //Obtener todos los pacientes
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            //Hacer consulta
            Paciente paciente = null;
            PreparedStatement ps = getInstance().prepareStatement("select * from usuarios u, paciente p where p.usuario_id = u.id;");
            //Recibir datos
            ResultSet r = ps.executeQuery();
            while(r.next()){
                //Agregar objetos
                paciente = new Paciente(r.getInt(1), r.getString(2), r.getString(3),
                        r.getLong(4), r.getString(5), r.getString(6), r.getString(7),
                        r.getString(8), r.getString(9), r.getString(10), r.getString(11),
                        r.getString(12), r.getString(13), r.getString(14), r.getString(15),
                        r.getString(16), r.getString(17), r.getString(18), r.getString(19),
                        r.getString(20), r.getBoolean(21));
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //retornar pacientes
        return pacientes;
    }

    @Override
    public void actualizarPaciente(Paciente paciente) throws SQLException {
        //Se actualiza el paciente usando un procedimiento almacenado
        PreparedStatement ps = getInstance().prepareStatement("call op_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, paciente.getId());
        ps.setString(2, paciente.getNombre());
        ps.setString(3, paciente.getApellido());
        ps.setLong(4, paciente.getNumIdentificacion());
        ps.setString(5, paciente.getTipoDoc());
        ps.setString(6, paciente.getFechaNac());
        ps.setString(7, paciente.getSexo());
        ps.setString(8, paciente.getEstadoCivil());
        ps.setString(9, paciente.getDireccion());
        ps.setString(10, paciente.getMunicipioResidencia());
        ps.setString(11, paciente.getDepartamentoResidencia());
        ps.setString(12, paciente.getTel1());
        ps.setString(13, paciente.getTel2());
        ps.setString(14, paciente.getEmail());
        ps.setString(15, paciente.getPassword());
        ps.setString(16, paciente.getGrupoSanguineo());
        ps.setString(17, paciente.getRH());
        ps.setString(18, paciente.getProfesion());
        ps.setString(19, paciente.getOcupacion());
        ps.setString(20, paciente.getTipoAfiliacion());
        ps.setBoolean(21, paciente.isEstadoAfiliacion());
        ps.setInt(22, 2);
        ps.execute();
    }

    @Override
    public void eliminarPaciente(int id) throws SQLException {
        //Se elimina el paciente usando un procedimiento almacenado
        PreparedStatement ps = getInstance().prepareStatement("call op_paciente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, "");
        ps.setString(3, "");
        ps.setString(4, "");
        ps.setString(5, "");
        ps.setString(6, "");
        ps.setString(7, "");
        ps.setString(8, "");
        ps.setString(9, "");
        ps.setString(10, "");
        ps.setString(11, "");
        ps.setString(12, "");
        ps.setString(13, "");
        ps.setString(14, "");
        ps.setString(15, "");
        ps.setString(16, "");
        ps.setString(17, "");
        ps.setString(18, "");
        ps.setString(19, "");
        ps.setString(20, "");
        ps.setBoolean(21, false);
        ps.setInt(22, 3);
        ps.execute();
    }
}
