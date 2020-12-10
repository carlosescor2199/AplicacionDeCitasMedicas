package com.mutualser.controller;

import com.mutualser.model.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mutualser.componentes.GetConectionSingleton.getInstance;

public class MedicoControllerImp implements MedicoController {

    @Override
    public void registrarMedico(Medico medico) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("call op_medico(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, medico.getId());
        ps.setString(2, medico.getNombre());
        ps.setString(3, medico.getApellido());
        ps.setLong(4, medico.getNumIdentificación());
        ps.setString(5, medico.getTipoDoc());
        ps.setString(6, medico.getFechaNac());
        ps.setString(7, medico.getSexo());
        ps.setString(8, medico.getEstadoCivil());
        ps.setString(9, medico.getDireccion());
        ps.setString(10, medico.getMunicipioResidencia());
        ps.setString(11, medico.getDepartamentoResidencia());
        ps.setString(12, medico.getTel1());
        ps.setString(13, medico.getTel2());
        ps.setString(14, medico.getEmail());
        ps.setString(15, medico.getPassword());
        ps.setString(16, medico.getNumTarjetaProfesional());
        ps.setString(17, medico.getGrupoSanguineo());
        ps.setString(18, medico.getRH());
        ps.setString(19, medico.getEspecialidadMedica());
        ps.setString(20, medico.getEPS());
        ps.setInt(21, 1);
        ps.execute();
    }

    @Override
    public Medico consultarMedico(int id) {
        Medico medico = null;
        try {
            PreparedStatement ps = getInstance().prepareStatement("select * from usuarios u, medico m where m.usuario_id = u.id and  u.id = ?;");
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                medico = new Medico(r.getInt(1), r.getString(2), r.getString(3),
                        r.getLong(4), r.getString(5), r.getString(6), r.getString(7),
                        r.getString(8), r.getString(9), r.getString(10), r.getString(11),
                        r.getString(12), r.getString(13), r.getString(14), r.getString(15),
                        r.getString(16), r.getString(17), r.getString(18), r.getString(19),
                        r.getString(20));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

    @Override
    public List<Medico> listarMedico() {
        ArrayList<Medico> medicos = new ArrayList<>();
        try {
            Medico medico = null;
            PreparedStatement ps = getInstance().prepareStatement("select * from usuarios u, medico m where m.usuario_id = u.id;");
            ResultSet r = ps.executeQuery();
            while(r.next()){
                medico = new Medico(r.getInt(1), r.getString(2), r.getString(3),
                        r.getLong(4), r.getString(5), r.getString(6), r.getString(7),
                        r.getString(8), r.getString(9), r.getString(10), r.getString(11),
                        r.getString(12), r.getString(13), r.getString(14), r.getString(15),
                        r.getString(16), r.getString(17), r.getString(18), r.getString(19),
                        r.getString(20));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicos;
    }

    @Override
    public void actualizarMedico(Medico medico) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("call op_medico(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, medico.getId());
        ps.setString(2, medico.getNombre());
        ps.setString(3, medico.getApellido());
        ps.setLong(4, medico.getNumIdentificación());
        ps.setString(5, medico.getTipoDoc());
        ps.setString(6, medico.getFechaNac());
        ps.setString(7, medico.getSexo());
        ps.setString(8, medico.getEstadoCivil());
        ps.setString(9, medico.getDireccion());
        ps.setString(10, medico.getMunicipioResidencia());
        ps.setString(11, medico.getDepartamentoResidencia());
        ps.setString(12, medico.getTel1());
        ps.setString(13, medico.getTel2());
        ps.setString(14, medico.getEmail());
        ps.setString(15, medico.getPassword());
        ps.setString(16, medico.getNumTarjetaProfesional());
        ps.setString(17, medico.getGrupoSanguineo());
        ps.setString(18, medico.getRH());
        ps.setString(19, medico.getEspecialidadMedica());
        ps.setString(20, medico.getEPS());
        ps.setInt(21, 2);
        ps.execute();
    }

    @Override
    public void eliminarMedico(int id) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("call op_medico(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, "");
        ps.setString(3, "");
        ps.setLong(4, 0);
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
        ps.setInt(21, 3);
        ps.execute();
    }
}
