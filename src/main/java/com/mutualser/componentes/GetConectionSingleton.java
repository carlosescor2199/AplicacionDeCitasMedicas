package com.mutualser.componentes;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetConectionSingleton {

    private static Connection connection;

    //Se crea una instacia de la conexion bajo el patrón de diseño singleton, esto para no hacer llamados redundantes a la bd y por ende no sobrecargar
    //de peticiones
    public static Connection getInstance() {

        if (connection == null) {

            try {
                Properties properties = new Properties();

                properties.load(
                        new FileInputStream
                                ("recursos/Conexion.properties"));

                connection = new
                        ConectarMySQL(properties.getProperty("host"),
                        properties.getProperty("baseDatos"), properties.getProperty("puerto"),
                        properties.getProperty("usuario"),
                        properties.getProperty("password"))
                        .getConnection();

            } catch (Exception ex) {
                Logger.getLogger(GetConectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

        return connection;
    }
}
