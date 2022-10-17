package main.Controller;

import main.DAO.CategoriaDao;
import main.DAO.JuegoDao;
import main.Enum.ClasificacionEnum;
import main.Model.Categoria;
import main.Model.Juego;
import main.Model.ViewModel.CostoJuegoVista;
import main.Model.ViewModel.JuegoVista;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "categoria", value = "/")
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
        private CategoriaDao categoriaDao;
        private JuegoDao juegoDao;

    public void init() {
        categoriaDao = new CategoriaDao();
        juegoDao = new JuegoDao();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String action = request.getServletPath();

            try {
                switch (action) {
                    case "/newCategoria":
                        showNewFormCategoria(request, response);
                        break;
                    case "/insertCategoria":
                        insertCategoria(request, response);
                        break;
                    case "/deleteCategoria":
                        deleteCategoria(request, response);
                        break;
                    case "/editCategoria":
                        showEditFormCategoria(request, response);
                        break;
                    case "/updateCategoria":
                        updateCategoria(request, response);
                        break;
                    case "/listCategoria":
                        listCategoria(request, response);


                    case "/newJuego":
                        showNewFormJuego(request, response);
                        break;
                    case "/insertJuego":
                        insertJuego(request, response);
                        break;
                    case "/deleteJuego":
                        deleteJuego(request, response);
                        break;
                    case "/editJuego":
                        showEditFormJuego(request, response);
                        break;
                    case "/updateJuego":
                        updateJuego(request, response);
                        break;
                    case "/listJuego":
                        listJuego(request, response);
                        break;
                    case "/listJuegoSearch":
                        listJuegoSearch(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
        //**************************************************************************
        //CATEGORIA
        //**************************************************************************

        private void listCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<Categoria> listCategoria = categoriaDao.selectAllCategoria();
            request.setAttribute("listCategoria", listCategoria);
            RequestDispatcher dispatcher = request.getRequestDispatcher("categoria.jsp");
            dispatcher.forward(request, response);
        }

        private void showNewFormCategoria(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("categoriaForm.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditFormCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("idCategoria"));
            Categoria existingCategoria = categoriaDao.selectCategoria(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("categoriaForm.jsp");
            request.setAttribute("categoria", existingCategoria);
            dispatcher.forward(request, response);

        }

        private void insertCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            String nombreCategoria = request.getParameter("nombreCategoria");

            Categoria newCategoria = new Categoria(nombreCategoria);
            categoriaDao.insertCategoria(newCategoria);
                    response.sendRedirect("listCategoria");
        }

        private void updateCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            String nombreCategoria = request.getParameter("nombreCategoria");

            Categoria newCategoria = new Categoria(idCategoria, nombreCategoria);
            categoriaDao.updateCategoria(newCategoria);
            response.sendRedirect("listCategoria");
        }

        private void deleteCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("idCategoria"));
            categoriaDao.deleteCategoria(id);
            response.sendRedirect("listCategoria");
        }
        //**************************************************************************
        //JUEGOS
        //**************************************************************************
    private void listJuego(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //Categoria
        List<Categoria> listCategoria = categoriaDao.selectAllCategoria();
        request.setAttribute("listCategoria", listCategoria);
        //Clasificacion
        List<String> listClasificacion = ClasificacionEnum.getListClasificacion();
        request.setAttribute("listClasificacion", listClasificacion);
        //Juego
        List<JuegoVista> listJuego = juegoDao.selectAllJuego();
        List<CostoJuegoVista> listCostoJuego = juegoDao.getListCostoJuego();
        request.setAttribute("listJuego", listJuego);
        request.setAttribute("listCostoJuego", listCostoJuego);
        RequestDispatcher dispatcher = request.getRequestDispatcher("juego.jsp");
        dispatcher.forward(request, response);
    }

    private void listJuegoSearch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String clasificacion = request.getParameter("clasificacion");
        //Get stuff
        List<JuegoVista> listJuego = juegoDao.selectJuegoCategoriaClasificacion(idCategoria, clasificacion);
        List<Categoria> listCategoria = categoriaDao.selectAllCategoria();
        List<String> listClasificacion = ClasificacionEnum.getListClasificacion();
        //re-save stuff
        request.setAttribute("listJuego", listJuego);
        request.setAttribute("listCategoria", listCategoria);
        request.setAttribute("listClasificacion", listClasificacion);
        //send stuff
        RequestDispatcher dispatcher = request.getRequestDispatcher("juego.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormJuego(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> listCategoria = categoriaDao.selectAllCategoria();
        List<String> listClasificacion = ClasificacionEnum.getListClasificacion();
        request.setAttribute("listCategoria", listCategoria);
        request.setAttribute("listClasificacion", listClasificacion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("juegoForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormJuego(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idJuego"));
        Juego existingJuego = juegoDao.selectJuego(id);
        List<Categoria> listCategoria = categoriaDao.selectAllCategoria();
        List<String> listClasificacion = ClasificacionEnum.getListClasificacion();
        RequestDispatcher dispatcher = request.getRequestDispatcher("juegoForm.jsp");
        //Yes, I'm returning a lot of stuff...
        //Kinda confusing to read...
        request.setAttribute("juego", existingJuego);
        request.setAttribute("listCategoria", listCategoria);
        request.setAttribute("listClasificacion", listClasificacion);
        dispatcher.forward(request, response);

    }

    private void insertJuego(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nombreJuego = request.getParameter("nombreJuego");
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String clasificacion = request.getParameter("clasificacion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int existencias = Integer.parseInt(request.getParameter("existencias"));

        Juego newJuego = new Juego(nombreJuego, idCategoria, clasificacion, precio, existencias);
        juegoDao.insertJuego(newJuego);
        response.sendRedirect("listJuego");
    }

    private void updateJuego(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idJuego = Integer.parseInt(request.getParameter("idJuego"));
        String nombreJuego = request.getParameter("nombreJuego");
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String clasificacion = request.getParameter("clasificacion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int existencias = Integer.parseInt(request.getParameter("existencias"));

        Juego newJuego = new Juego(idJuego, nombreJuego, idCategoria, clasificacion, precio, existencias);
        juegoDao.updateJuego(newJuego);
        response.sendRedirect("listJuego");
    }

    private void deleteJuego(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idJuego"));
        juegoDao.deleteJuego(id);
        response.sendRedirect("listJuego");

    }

}
