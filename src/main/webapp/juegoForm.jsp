<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
<div class="w-full flex justify-center items-center">
    <!-- Did get the path-->
    <c:if test="${juego != null}">
    <form action="updateJuego" method="post" class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
        </c:if>
        <!--Didn't get the path-->
        <c:if test="${juego == null}">
            <form action="insertJuego" method="post" class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4"
        </c:if>

        <h2>
            <!-- Didn't get the path-->
            <c:if test="${juego != null}">
                Editar Juego
            </c:if>
            <!-- Didn get the path-->
            <c:if test="${juego == null}">
                Agregar Juego
            </c:if>
        </h2>

        <div class="mb-4">
            <c:if test="${juego != null}">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="idJuego" hidden>
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                       name="idJuego"
                       value="<c:out value='${juego.getIdJuego()}' />"
                       type="text" placeholder="ID" hidden>
            </c:if>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="nombreJuego">Juego
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="nombreJuego"
                   value="<c:out value='${juego.getNombreJuego()}' />"
                   type="text" placeholder="">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="categoriaJuego">Categoria
            </label>
            <!--Select-->
            <select name="idCategoria"
                    class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="0">-- Selecione categoria --</option>
                <c:forEach items="${listCategoria}" var="listCategoria">
                    <option value="${listCategoria.getIdCategoria()}"
                            <c:if test="${juego.getIdCategoria() == listCategoria.getIdCategoria()}">
                                selected
                            </c:if>
                    >${listCategoria.getNombreCategoria()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="clasificacion">Clasificacion
            </label>
            <select name="clasificacion"
                    class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="0">-- Selecione clasificacion--</option>
                <c:forEach items="${listClasificacion}" var="clasificacion">
                    <option value="${clasificacion}"
                            <c:if test="${clasificacion == juego.getClasificaion()}">
                                selected
                            </c:if>
                    >${clasificacion}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="Precio">Precio
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="precio"
                   value="<c:out value='${juego.getPrecio()}' />"
                   type="text" placeholder="">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="Existencias">Existencias
            </label>
            <select name="existencias"
                    class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                <option value="0">-- Selecione Existencias--</option>
                <option value="0"
                        <c:if test="${juego.getExistencias() == 1}">
                            selected
                        </c:if>
                >En existencias</option>
                <option value="1"
                        <c:if test="${juego.getExistencias() == 0}">
                            selected
                        </c:if>
                >Agotados</option>
            </select>
        </div>
        <div class="flex items-center justify-between">
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    type="submit">
                Guardar
            </button>
        </div>

    </form>
</div>
</body>