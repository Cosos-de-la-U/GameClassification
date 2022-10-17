package main.DB.Queries;

public class QueriesJuego {
    public static final String INSERT_JUEGO = "INSERT INTO juego" + " (nombreJuego, idCategoria, clasificacion, precio, existencias) VALUES" + "(?, ?, ?, ?, ?);";
    public static final String SELECT_ALL_JUEGO = "SELECT * FROM juego;";
    public static final String SELECT_ID_JUEGO = "SELECT * FROM juego WHERE idJuego = ?;";
    public static final String SELECT_ALL_JUEGO_VISTA =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, clasificacion, precio, existencias FROM juego inner join categoria c ON c.idCategoria = juego.idCategoria;";
    public static final String SELECT_JUEGO_CATEGORIA_CLASIFICACION =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, clasificacion, precio, existencias  FROM juego inner join categoria c ON c.idCategoria = juego.idCategoria WHERE c.idCategoria = ? AND clasificacion = ?;";
    public static final String SELECT_JUEGO_CATEGORIA =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, clasificacion, precio, existencias  FROM juego inner join categoria c ON c.idCategoria = juego.idCategoria WHERE c.idCategoria = ?;";
    public static final String SELECT_JUEGO_CLASIFICACION =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, clasificacion, precio, existencias  FROM juego inner join categoria c ON c.idCategoria = juego.idCategoria WHERE clasificacion = ?;";
    public static final String SELECT_CATEGORIA =
            "SELECT idJuego, nombreJuego, c.nombreCategoria, clasificacion, precio, existencias FROM juego inner join categoria c ON c.idCategoria = juego.idCategoria WHERE juego.idCategoria = ?";
    public static final String SELECT_MAX_PRECIO = "SELECT nombreJuego, precio FROM juego WHERE precio = (SELECT max(precio) FROM juego) LIMIT 1;";
    public static final String SELECT_MIN_PRECIO = "SELECT nombreJuego, precio FROM juego WHERE precio = (SELECT min(precio) FROM juego) LIMIT 1;";
    public static final String SELECT_AVG_PRECIO = "SELECT avg(precio) FROM juego;";
    public static final String DELETE_JUEGO = "DELETE FROM juego WHERE idJuego = ?;";
    public static final String UPDATE_JUEGO = "UPDATE juego SET nombreJuego = ?, idCategoria = ?, clasificacion = ?, precio = ?, existencias = ? WHERE idJuego = ?;";
}
