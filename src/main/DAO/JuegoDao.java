package main.DAO;

import main.Model.Juego;
import main.Model.ViewModel.JuegoVista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.DB.PostgresDriver.getConnection;
import static main.DB.PostgresDriver.printSQLException;

public class JuegoDao {

    private static final String INSERT_JUEGO = "INSERT INTO juego" + " (nombreJuego, idCategoria, precio) VALUES" + "(?, ?, ?);";
    private static final String SELECT_ALL_JUEGO =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, precio FROM juego inner join categoria c on c.idCategoria = juego.idCategoria;";
    private static final String SELECT_ID_JUEGO =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, precio FROM juego inner join categoria c ON c.idCategoria = juego.idCategoria WHERE idJuego = ?;";
    private static final String DELETE_JUEGO = "DELETE FROM juego WHERE idJuego = ?;";
    private static final String UPDATE_JUEGO = "UPDATE juego SET nombreJuego = ?;";

    public JuegoDao(){
    }


    public void insertJuego(Juego juego) throws SQLException {
        System.out.println(INSERT_JUEGO);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_JUEGO)) {
            preparedStatement.setString(1, juego.getNombreJuego());
            preparedStatement.setInt(2, juego.getIdCategoria());
            preparedStatement.setDouble(3, juego.getPrecio());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public JuegoVista selectJuego(int id) {
        JuegoVista juego = null;
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
                int idJuego = rs.getInt("ID");
                String nombreJuego = rs.getString("Nombre");
                String nombreCategoria = rs.getString("Categoria");
                double precio = rs.getDouble("Precio");
                juego = new JuegoVista(idJuego, nombreJuego, nombreCategoria, precio);
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
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_JUEGO);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idJuego = rs.getInt("Id");
                String nombreJuego = rs.getString("Nombre");
                String nombreCategoria = rs.getString("Categoria");
                double precio = rs.getDouble("Precio");
                juego.add(new JuegoVista(idJuego, nombreJuego, nombreCategoria, precio));
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
            System.out.println("updated Juego:"+statement);
            statement.setString(1, juego.getNombreJuego());
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
}
