<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
    <div class="container mt-4">
        <div class="card">
            <div class="card-body">
                <c:if test="${categoria != null}">
                <form action="update" method="post">
                    </c:if>
                    <c:if test="${categoria == null}">
                    <form action="insertCategoria" method="post">
                        </c:if>
                        <caption>
                            <h2>
                                <c:if test="${categoria != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${categoria == null}">
                                    Add New User
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${categoria != null}">
                            <input type="hidden" name="Id" value="<c:out value='${categoria.idCategoria}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>User Name</label> <input type="text"
                                                            value="<c:out value='${categoria.nombreCategoria}' />" class="form-control"
                                                            name="name" required="required">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                    </form>
            </div>
        </div>
    </div>
</body>