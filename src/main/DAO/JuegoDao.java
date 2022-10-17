package main.DAO;

import main.Model.Juego;
import main.Model.ViewModel.CostoJuegoVista;
import main.Model.ViewModel.JuegoVista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.DB.PostgresDriver.getConnection;
import static main.DB.PostgresDriver.printSQLException;
import static main.DB.Queries.QueriesJuego.*;

public class JuegoDao {

    public JuegoDao() {
    }

    public void insertJuego(Juego juego) throws SQLException {
        System.out.println(INSERT_JUEGO);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_JUEGO)) {
            preparedStatement.setString(1, juego.getNombreJuego());
            preparedStatement.setInt(2, juego.getIdCategoria());
            preparedStatement.setString(3, juego.getClasificaion());
            preparedStatement.setDouble(4, juego.getPrecio());
            preparedStatement.setInt(5, juego.getExistencias());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<JuegoVista> selectJuegoCategoriaClasificacion(int idCategoria, String nombreClasificacion) {
        List<JuegoVista> juego = new ArrayList<>();
        int validation = idCategoria != -1 && !nombreClasificacion.equals("-1") ? 0 :
                idCategoria != -1 ? 1 : !nombreClasificacion.equals("-1") ? 2 : 3;
        String SELECT_SEARCH_STUFF = validation == 0 ? SELECT_JUEGO_CATEGORIA_CLASIFICACION :
                validation == 1 ? SELECT_JUEGO_CATEGORIA : validation == 2 ? SELECT_JUEGO_CLASIFICACION : SELECT_ALL_JUEGO_VISTA;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SEARCH_STUFF);) {
            switch (validation){
                case 0:
                    preparedStatement.setInt(1, idCategoria);
                    preparedStatement.setString(2, nombreClasificacion);
                    break;
                case 1:
                    preparedStatement.setInt(1, idCategoria);
                    break;
                case 2:
                    preparedStatement.setString(1, nombreClasificacion);
                    break;
            }
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idJuego = rs.getInt("idJuego");
                String nombreJuego = rs.getString("nombreJuego");
                String nombreCategoria = rs.getString("nombreCategoria");
                String clasificacion = rs.getString("clasificacion");
                double precio = rs.getDouble("precio");
                String existencias = rs.getInt("existencias") == 1 ? "En existencias" : "Agotados";
                juego.add(new JuegoVista(idJuego, nombreJuego, nombreCategoria, clasificacion, precio, existencias));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return juego;
    }

    public Juego selectJuego(int id) {
        Juego juego = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_JUEGO);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idJuego = rs.getInt("idJuego");
                String nombreJuego = rs.getString("nombreJuego");
                int idCategoria = rs.getInt("idCategoria");
                String clasificacion = rs.getString("clasificacion");
                double precio = rs.getDouble("precio");
                int existencias = rs.getInt("existencias");
                juego = new Juego(idJuego, nombreJuego, idCategoria, clasificacion, precio, existencias);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return juego;
    }

    public List<JuegoVista> selectAllJuego() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<JuegoVista> juego = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_JUEGO_VISTA);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idJuego = rs.getInt("idJuego");
                String nombreJuego = rs.getString("nombreJuego");
                String nombreCategoria = rs.getString("nombreCategoria");
                String clasificacion = rs.getString("clasificacion");
                double precio = rs.getDouble("precio");
                String existencias = rs.getInt("existencias") == 1 ? "En existencias" : "Agotados";
                juego.add(new JuegoVista(idJuego, nombreJuego, nombreCategoria, clasificacion, precio, existencias));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return juego;
    }

    public boolean updateJuego(Juego juego) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_JUEGO);) {
            System.out.println("updated Juego:" + statement);
            statement.setString(1, juego.getNombreJuego());
            statement.setInt(2, juego.getIdCategoria());
            statement.setString(3, juego.getClasificaion());
            statement.setDouble(4, juego.getPrecio());
            statement.setInt(5, juego.getExistencias());
            statement.setInt(6, juego.getIdJuego());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteJuego(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_JUEGO);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<CostoJuegoVista> getListCostoJuego() {
        List<CostoJuegoVista> listCostoJuegoVistas = new ArrayList<CostoJuegoVista>();
        String[] arrayQueries = {SELECT_MAX_PRECIO, SELECT_MIN_PRECIO};
        try (Connection connection = getConnection()) {
            //Adding list costo vista
            for (String query :
                    arrayQueries) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String nombreJuego = rs.getString("nombreJuego");
                    double precio = rs.getDouble("precio");
                    listCostoJuegoVistas.add(new CostoJuegoVista(nombreJuego, precio));
                }
            }
            //Adding Avegerage
            listCostoJuegoVistas.add(new CostoJuegoVista("Promedio", getAverage()));
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listCostoJuegoVistas;
    }

    public double getAverage() {
        double average = new Double(0);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AVG_PRECIO);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                average = rs.getInt("AVG");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return average;
    }
}
