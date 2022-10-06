package main.Controller;

import main.Model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static main.DB.PostgresDriver.getConnection;
import static main.DB.PostgresDriver.printSQLException;

public class CategoriaDao {

    private static final String INSERT_CATEGORIA = "INSERT INTO categoria" + " (nombreCategoria) VALUES" + "( ? );";
    private static final String SELECT_ALL_CATEGORIA = "SELECT * FROM categoria;";
    private static final String SELECT_ID_CATEGORIA = "SELECT * FROM categoria WHERE idCategoria = ?;";
    private static final String DELETE_CATEGORIA = "DELETE FROM categoria WHERE idCategoria = ?;";
    private static final String UPDATE_CATEGORIA = "UPDATE categoria SET nombreCategoria = ?;";

    public CategoriaDao(){
    }


    public void insertCategoria(Categoria categoria) throws SQLException {
        System.out.println(INSERT_CATEGORIA);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORIA)) {
            preparedStatement.setString(1, categoria.getNombreCategoria());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Categoria selectCategoria(int id) {
        Categoria categoria = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID_CATEGORIA);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idCategoria = rs.getInt("ID");
                String nombreCategoria = rs.getString("Categoria");
                categoria = new Categoria(idCategoria, nombreCategoria);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoria;
    }


    public List<Categoria> selectAllCategoria() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Categoria> categoria = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIA);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int idCategoria = rs.getInt("id");
                String nombreCategoria = rs.getString("name");
                categoria.add(new Categoria(idCategoria, nombreCategoria));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoria;
    }

    public boolean updateCategoria(Categoria categoria) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORIA);) {
            System.out.println("updated Categoria:"+statement);
            statement.setString(1, categoria.getNombreCategoria());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteCategoria(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORIA);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
