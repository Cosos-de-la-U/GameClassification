<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
    <div class="container mt-4">

        <div class="row">
            <div class="container">
                <h3 class="text-center">Categoria</h3>
                <hr>
                <div class="container text-left">

                    <a href="<%=request.getContextPath()%>/newCategoria" class="btn btn-success">Add
                        New User</a>
                </div>
                <br>
                <table class="table-auto">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="categoria" items="${listCategoria}">

                        <tr>
                            <td><c:out value="${categoria.idCategoria}"/></td>
                            <td><c:out value="${categoria.nombreCategoria}"/></td>
                            <td><a href="edit?id=<c:out value='${categoria.idCategoria}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp; <a
                                        href="delete?id=<c:out value='${categoria.idCategoria}' />">Delete</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
</body>