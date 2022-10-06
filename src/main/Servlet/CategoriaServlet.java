package main.Servlet;

import main.DAO.CategoriaDao;
import main.Model.Categoria;

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
public class CategoriaServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private CategoriaDao categoriaDao;

        public void init() {
            categoriaDao = new CategoriaDao();
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
                        showNewForm(request, response);
                        break;
                    case "/insertCategoria":
                        insertCategoria(request, response);
                        break;
                    case "/deleteCategoria":
                        deleteCategoria(request, response);
                        break;
                    case "/editCategoria":
                        showEditForm(request, response);
                        break;
                    case "/updateCategoria":
                        updateCategoria(request, response);
                        break;
                    default:
                        listCategoria(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }

        private void listCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List<Categoria> listCategoria = categoriaDao.selectAllCategoria();
            request.setAttribute("listCategoria", listCategoria);
            RequestDispatcher dispatcher = request.getRequestDispatcher("categoria.jsp");
            dispatcher.forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("categoriaForm.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Categoria existingCategoria = categoriaDao.selectCategoria(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("categoriaForm.jsp");
            request.setAttribute("categoria", existingCategoria);
            dispatcher.forward(request, response);

        }

        private void insertCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            String nombreCategoria = request.getParameter("Nombre");

            Categoria newCategoria = new Categoria(nombreCategoria);
            categoriaDao.insertCategoria(newCategoria);
            response.sendRedirect("list");
        }

        private void updateCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int idCategoria = Integer.parseInt(request.getParameter("Id"));
            String nombreCategoria = request.getParameter("Nombre");

            Categoria newCategoria = new Categoria(idCategoria, nombreCategoria);
            categoriaDao.updateCategoria(newCategoria);
            response.sendRedirect("list");
        }

        private void deleteCategoria(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("Id"));
            categoriaDao.deleteCategoria(id);
            response.sendRedirect("list");

        }

}
