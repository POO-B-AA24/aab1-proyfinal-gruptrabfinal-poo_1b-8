package Model;

import Controller.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexion {

    public Connection conn;
    public ArrayList<DatosBuses> ListaRutas;
    public String msj;

    public void conectar(String url) {
        try {
            // db parameters  
            // create a connection to the database  
            this.conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {

            this.msj = e.getMessage();
        }
    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarDatos(Rutas ruta) {
        try {
            conectar("jdbc:sqlite:bd/BaseDeDatosBuses.bd");
            Statement statement = obtenerConexion().createStatement();
            String insertRuta = String.format("insert into tb_Rutas(numRuta, ruta) "
                    + "values('%d','%s')", ruta.numRuta, (String) ruta.ruta);
            statement.executeUpdate(insertRuta);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<DatosBuses> mostrarDatos() {
        ArrayList<DatosBuses> rutas = new ArrayList<>();
        try {
            conectar("jdbc:sqlite:bd/BaseDeDatosBuses.bd");
            Statement statement = conn.createStatement();
            String data = "Select * from tb_Rutas;";
            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                rutas.add(new DatosBuses(rs.getInt("numRuta"),
                        rs.getString("ruta"))
                );
            }
            statement.close();
        } catch (SQLException e) {
            this.msj = e.getMessage();
        }
        return rutas;
    }
}
