package com.mutualser.controller;

import com.mutualser.model.Horario;
import static com.mutualser.componentes.GetConectionSingleton.getInstance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorarioControllerImp implements HorarioController {

    @Override
    public void registrarHorario(Horario horario, int idMedico) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("insert into horarios (fecha_horario, hora_entrada, hora_salida, fecha_inicio, fecha_final, id_medico) values (?,?,?,?,?,?);");
        ps.setString(1, horario.getFechaHorario());
        ps.setString(2, horario.getHoraEntrada());
        ps.setString(3, horario.getHoraSalida());
        ps.setString(4, horario.getFechaInicio());
        ps.setString(5, horario.getFechaFinal());
        ps.setInt(6, idMedico);
        ps.execute();
    }

    @Override
    public List<Horario> consultarHorario(int idMedico) {
        ArrayList<Horario> horarios = new ArrayList<>();
        try {
            Horario horario = null;
            PreparedStatement ps = getInstance().prepareStatement("select * from horarios where id_medico = ?;");
            ps.setInt(1, idMedico);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                horario = new Horario(r.getInt(1), r.getString(2), r.getString(3), r.getString(4),
                        r.getString(5), r.getString(6), r.getInt(7));
                horarios.add(horario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarHorario(Horario horario) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("update horarios set fecha_horario = ?, hora_entrada = ?, hora_salida = ?, fecha_inicio = ?, fecha_final = ?, id_medico = ? where id = ?;");
        ps.setString(1, horario.getFechaHorario());
        ps.setString(2, horario.getHoraEntrada());
        ps.setString(3, horario.getHoraSalida());
        ps.setString(4, horario.getFechaInicio());
        ps.setString(5, horario.getFechaFinal());
        ps.setInt(6, horario.getIdMedico());
        ps.setInt(7, horario.getId());
        ps.execute();
    }

    @Override
    public void eliminarHorario(int id) throws SQLException {
        PreparedStatement ps = getInstance().prepareStatement("delete from horarios where id = ?;");
        ps.setInt(1, id);
        ps.execute();
    }
}
