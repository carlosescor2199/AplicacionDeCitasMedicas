package com.mutualser.controller;

import static com.mutualser.componentes.GetConectionSingleton.getInstance;
import com.mutualser.model.Cita;
import com.mutualser.model.Horario;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CitaControllerImp implements CitaController {
    @Override
    public void agendarCita(Cita cita) {

        //Variables para validar existencia de disponibilidad
        boolean coincidenciaCita = false;
        boolean coincidenciaHorario = false;
        // Se consultan las citas
        HorarioController horarioController = new HorarioControllerImp();
        ArrayList<Cita> citas = (ArrayList<Cita>) this.listarTodasCitas();
        ArrayList<Horario> horarios = (ArrayList<Horario>) horarioController.consultarHorario(cita.getIdMedico());
        for(Cita citaAux : citas) {
            if(citaAux.getFecha().equals(cita.getFecha()) &&
                    (citaAux.getHoraInicio().equals(cita.getHoraInicio()) ||
                            citaAux.getHoraFinal().equals(cita.getHoraFinal()))) {
                coincidenciaCita = true;
            }
        }
        // Se consultan los horarios
        for(Horario horarioAux : horarios) {
            Date fechaHorarioInicio = Date.valueOf(horarioAux.getFechaInicio());
            Date fechaHorarioFinal = Date.valueOf(horarioAux.getFechaFinal());
            Time horaEntrada = Time.valueOf(horarioAux.getHoraEntrada());
            Time horaSalida = Time.valueOf(horarioAux.getHoraSalida());
            Date fechaCita = Date.valueOf(cita.getFecha());
            Time horaInicioCita = Time.valueOf(cita.getHoraInicio());
            Time horaFinalCita = Time.valueOf(cita.getHoraFinal());
            if(((fechaCita.compareTo(fechaHorarioInicio) > 0 &&
                    fechaCita.compareTo(fechaHorarioFinal) < 0) ||
                    fechaCita.compareTo(fechaHorarioInicio) == 0) &&
                    ((horaInicioCita.after(horaEntrada) || horaInicioCita.equals(horaEntrada)) &&
                            (horaFinalCita.before(horaSalida) || horaFinalCita.equals(horaSalida)))) {
                coincidenciaHorario = true;
            }
        }

        // se inserta la cita
        if(!coincidenciaCita && coincidenciaHorario){
            try {
                PreparedStatement ps = getInstance().prepareStatement("insert into citas (fecha, hora_inicio, hora_final, id_medico, id_paciente) values (?,?,?,?,?);");
                ps.setString(1, cita.getFecha());
                ps.setString(2, cita.getHoraInicio());
                ps.setString(3, cita.getHoraFinal());
                ps.setInt(4, cita.getIdMedico());
                ps.setInt(5, cita.getIdPaciente());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //lista de citas de un paciente
    @Override
    public List<Cita> consultarCitas(int id, int idPaciente, int idMedico) {
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            Cita cita = null;
            PreparedStatement ps = getInstance().prepareStatement("select * from citas where id = ? or id_paciente = ? or id_medico = ?;");
            ps.setInt(1, id);
            ps.setInt(2, idPaciente);
            ps.setInt(3, idMedico);
            ResultSet r = ps.executeQuery();
            while (r.next()){
                cita = new Cita(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getInt(6));
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return citas;
    }

    //Lista de todas las citas
    @Override
    public List<Cita> listarTodasCitas() {
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            Cita cita = null;
            PreparedStatement ps = getInstance().prepareStatement("select * from citas;");
            ResultSet r = ps.executeQuery();
            while (r.next()){
                cita = new Cita(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getInt(6));
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return citas;
    }

    //Se elimina la cita
    @Override
    public void eliminarCita(int id) {
        try {
            PreparedStatement ps = getInstance().prepareStatement("delete from citas where id = ?;");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
