package com.mutualser.controller;

import com.mutualser.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.mutualser.componentes.GetConectionSingleton.getInstance;

public class AuthControllerImp implements AuthController {

    @Override
    public Usuario login(long numId, String password, int rol) {
        try {
            //Dependiendo del tipo de rol se hace una consulta a la base de datos
            PreparedStatement ps;
            switch (rol){
                case 1:
                    //se busca un paciente
                    ps = getInstance().prepareStatement("select * from usuarios u, paciente p where u.num_id = ? and p.usuario_id = u.id;");
                    break;
                case 2:
                    //se busca un medico
                    ps = getInstance().prepareStatement("select * from usuarios u, medico p where u.num_id = ? and p.usuario_id = u.id;");
                    break;
                case 3:
                    //se busca un administrativo
                    ps = getInstance().prepareStatement("select * from usuarios u, administrativo p where u.num_id = ? and p.usuario_id = u.id;");
                    break;
                default:
                    //por defecto va a buscar un paciente
                    ps = getInstance().prepareStatement("select * from usuarios u, paciente p where u.num_id = ? and p.usuario_id = u.id;");
                    break;
            }
            ps.setLong(1, numId);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                switch (rol){
                    //Dependiendo del tipo de rol se crea un tipo de usuario y se retorna
                    case 1:
                        //se crea un paciente
                        Usuario paciente = new Paciente(r.getInt(1), r.getString(2), r.getString(3), r.getLong(4),
                                r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getString(9),
                                r.getString(10), r.getString(11), r.getString(12), r.getString(13), r.getString(14),
                                r.getString(15), r.getString(17), r.getString(18), r.getString(19), r.getString(20),
                                r.getString(21), r.getBoolean(22));
                        if(paciente.getPassword().equals(password)){
                            return paciente;
                        }
                        break;
                    case 2:
                        //se crea un medico
                        Usuario medico = new Medico(r.getInt(1), r.getString(2), r.getString(3), r.getLong(4),
                                r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getString(9),
                                r.getString(10), r.getString(11), r.getString(12), r.getString(13), r.getString(14),
                                r.getString(15), r.getString(17), r.getString(18), r.getString(19), r.getString(20),
                                r.getString(21));
                        if(medico.getPassword().equals(password)){
                            return medico;
                        }
                        break;
                    case 3:
                        //se crea un administrativo
                        Usuario administrativo = new Administrativo(r.getInt(1), r.getString(2), r.getString(3), r.getLong(4),
                                r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getString(9),
                                r.getString(10), r.getString(11), r.getString(12), r.getString(13), r.getString(14),
                                r.getString(15), r.getString(17), r.getString(18));
                        if(administrativo.getPassword().equals(password)){
                            return administrativo;
                        }
                        break;
                    default:
                        //se crea un paciente
                        Usuario paciente1 = new Paciente(r.getInt(1), r.getString(2), r.getString(3), r.getLong(4),
                                r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getString(9),
                                r.getString(10), r.getString(11), r.getString(12), r.getString(13), r.getString(14),
                                r.getString(15), r.getString(17), r.getString(18), r.getString(19), r.getString(20),
                                r.getString(21), r.getBoolean(22));
                        if(paciente1.getPassword().equals(password)){
                            return paciente1;
                        }
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //en caso de error retorna null
        return null;
    }
}
