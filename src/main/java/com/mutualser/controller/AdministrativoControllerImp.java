package com.mutualser.controller;

import com.mutualser.model.Administrativo;
import com.mutualser.model.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mutualser.componentes.GetConectionSingleton.getInstance;

public class AdministrativoControllerImp implements AdministrativoController {
    @Override
    public void registrarAdministrativo(Administrativo administrativo) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("call op_administrativo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, administrativo.getId());
        ps.setString(2, administrativo.getNombre());
        ps.setString(3, administrativo.getApellido());
        ps.setLong(4, administrativo.getNumIdentificación());
        ps.setString(5, administrativo.getTipoDoc());
        ps.setString(6, administrativo.getFechaNac());
        ps.setString(7, administrativo.getSexo());
        ps.setString(8, administrativo.getEstadoCivil());
        ps.setString(9, administrativo.getDireccion());
        ps.setString(10, administrativo.getMunicipioResidencia());
        ps.setString(11, administrativo.getDepartamentoResidencia());
        ps.setString(12, administrativo.getTel1());
        ps.setString(13, administrativo.getTel2());
        ps.setString(14, administrativo.getEmail());
        ps.setString(15, administrativo.getPassword());
        ps.setString(16, administrativo.getNombreCargo());
        ps.setString(17, administrativo.getCodCargo());
        ps.setInt(18, 1);
        ps.execute();
    }

    @Override
    public Administrativo consultarAdministrativo(int id) {
        Administrativo administrativo = null;
        try {
            PreparedStatement ps = getInstance().prepareStatement("select * from usuarios u, administrativo a where a.usuario_id = u.id and  u.id = ?;");
            ps.setInt(1, id);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                administrativo = new Administrativo(r.getInt(1), r.getString(2), r.getString(3),
                        r.getLong(4), r.getString(5), r.getString(6), r.getString(7),
                        r.getString(8), r.getString(9), r.getString(10), r.getString(11),
                        r.getString(12), r.getString(13), r.getString(14), r.getString(15),
                        r.getString(16), r.getString(17));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrativo;
    }

    @Override
    public List<Administrativo> listarAdministrativo() {
        ArrayList<Administrativo> administrativos = new ArrayList<>();
        try {
            Administrativo administrativo = null;
            PreparedStatement ps = getInstance().prepareStatement("select * from usuarios u, administrativo a where a.usuario_id = u.id;");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                administrativo = new Administrativo(r.getInt(1), r.getString(2), r.getString(3),
                        r.getLong(4), r.getString(5), r.getString(6), r.getString(7),
                        r.getString(8), r.getString(9), r.getString(10), r.getString(11),
                        r.getString(12), r.getString(13), r.getString(14), r.getString(15),
                        r.getString(16), r.getString(17));
                administrativos.add(administrativo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrativos;
    }

    @Override
    public void actualizarAdministrativo(Administrativo administrativo) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("call op_administrativo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, administrativo.getId());
        ps.setString(2, administrativo.getNombre());
        ps.setString(3, administrativo.getApellido());
        ps.setLong(4, administrativo.getNumIdentificación());
        ps.setString(5, administrativo.getTipoDoc());
        ps.setString(6, administrativo.getFechaNac());
        ps.setString(7, administrativo.getSexo());
        ps.setString(8, administrativo.getEstadoCivil());
        ps.setString(9, administrativo.getDireccion());
        ps.setString(10, administrativo.getMunicipioResidencia());
        ps.setString(11, administrativo.getDepartamentoResidencia());
        ps.setString(12, administrativo.getTel1());
        ps.setString(13, administrativo.getTel2());
        ps.setString(14, administrativo.getEmail());
        ps.setString(15, administrativo.getPassword());
        ps.setString(16, administrativo.getNombreCargo());
        ps.setString(17, administrativo.getCodCargo());
        ps.setInt(18, 2);
        ps.execute();
    }

    @Override
    public void eliminarAdministrativo(int id) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("call op_administrativo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, id);
        ps.setString(2, "");
        ps.setString(3, "administrativo.getApellido()");
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
        ps.setInt(18, 3);
        ps.execute();
    }
}
