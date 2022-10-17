package main.DB.Queries;

public class QueriesCategoria {
    public static final String INSERT_CATEGORIA = "INSERT INTO categoria" + " (nombreCategoria) VALUES" + "( ? );";
    public static final String SELECT_ALL_CATEGORIA = "SELECT * FROM categoria;";
    public static final String SELECT_ID_CATEGORIA = "SELECT * FROM categoria WHERE idCategoria = ?;";
    public static final String DELETE_CATEGORIA = "DELETE FROM categoria WHERE idCategoria = ?;";
    public static final String UPDATE_CATEGORIA = "UPDATE categoria SET nombreCategoria = ? WHERE idCategoria =?;";
}
