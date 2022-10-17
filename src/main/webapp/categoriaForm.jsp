<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
    <div class="w-full flex justify-center items-center">
            <!-- Did get the path-->
            <c:if test="${categoria != null}">
                <form action="updateCategoria" method="post" class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
            </c:if>
                    <!--Didn't get the path-->
                <c:if test="${categoria == null}">
                    <form action="insertCategoria" method="post" class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4"
                </c:if>

                <h2>
                    <!-- Didn't get the path-->
                    <c:if test="${categoria != null}">
                    Editar Categoria
                    </c:if>
                    <!-- Didn get the path-->
                    <c:if test="${categoria == null}">
                    Agregar Categoria
                    </c:if>
                </h2>

            <div class="mb-4">
                <c:if test="${categoria != null}">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="idCategoria" hidden>
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" name="idCategoria"
                       value="<c:out value='${categoria.getIdCategoria()}' />"
                       type="text" placeholder="ID" hidden>
                </c:if>
            </div>
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="nombreCategoria">
                   Categoria
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" name="nombreCategoria"
                       value="<c:out value='${categoria.getNombreCategoria()}' />"
                       type="text" placeholder="">
            </div>
            <div class="flex items-center justify-between">
                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
                    Guardar
                </button>
            </div>

        </form>
    </div>
</body>