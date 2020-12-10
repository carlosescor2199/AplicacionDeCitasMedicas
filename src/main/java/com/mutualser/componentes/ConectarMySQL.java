package com.mutualser.componentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarMySQL {

    private Connection connection;


    public ConectarMySQL(String servidorBD, String nombreBD,
                         String puerto, String usuario,
                         String password) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


            // Se crea un URL hacia la maquina y la base de datos
            String url = "jdbc:mysql://" + servidorBD + ":" + puerto + "/" + nombreBD + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

            //se crea la conexion a la base de datos
            connection = DriverManager.getConnection(url, usuario, password);

        } catch (Exception e) {

            System.out.println("Error" + e);
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {

        try {

            connection.close();

        } catch (SQLException e) {


            e.printStackTrace();
        }

    }
}
