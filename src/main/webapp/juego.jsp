<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
<div class="w-full mt-4 flex justify-center items-center">
    <div class="overflow-x-auto relative">
        <!--Search stuff-->
        <form action="listJuegoSearch" method="post">
            <div class="grid grid-cols-12">
                <div class="col-span-5 m-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2" for="categoriaJuego">Categoria
                    </label>
                    <!--Select-->
                    <select name="idCategoria"
                            class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                        <option value="-1">-- Selecione categoria --</option>
                        <c:forEach items="${listCategoria}" var="listCategoria">
                            <option value="${listCategoria.getIdCategoria()}"
                            >${listCategoria.getNombreCategoria()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-span-5 m-4">
                    <label class="block text-gray-700 text-sm font-bold mb-2" for="clasificacion">Clasificacion
                    </label>
                    <select name="clasificacion"
                            class="bg-gray-50 border border-gray-300 text-gray-900 mb-6 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                        <option value="-1">-- Selecione clasificacion--</option>
                        <c:forEach items="${listClasificacion}" var="clasificacion">
                            <option value="${clasificacion}"
                            >${clasificacion}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-span-2 m-10  flex justify-center">
                    <button class="bg-blue-500 p-1 items-center rounded text-white">
                        Buscar <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                </div>
            </div>
        </form>
        <!--Search stuff-->
        <!--Tabla-->
        <c:if test="${listCostoJuego != null}">
            <table class="w-full text-sm text-left text-gray-500 dark:text-green-400">
                <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                <tr>
                    <th scope="col" class="py-3 px-6">
                        Juego Mas Caro
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Juego Mas barato
                    </th>
                    <th scope="col" class="py-3 px-6">
                        Promedio precios
                    </th>
                </tr>
                </thead>
                <tbody>
                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    <c:out value="${listCostoJuego.get(0).getNombreJuego()} - ${listCostoJuego.get(0).getPrecio()} $"/>
                </th>
                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    <c:out value="${listCostoJuego.get(1).getNombreJuego()} - ${listCostoJuego.get(1).getPrecio()} $"/>
                </th>
                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    <c:out value="${listCostoJuego.get(2).getNombreJuego()} - ${listCostoJuego.get(2).getPrecio()} $"/>
                </th>
                </tbody>
            </table>
        </c:if>
        <!--Tabla-->
        <table class="w-full text-sm text-left text-gray-500 dark:text-green-400">
            <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="py-3 px-6">
                    ID
                </th>
                <th scope="col" class="py-3 px-6">
                    Juego
                </th>
                <th scope="col" class="py-3 px-6">
                    Categoria
                </th>
                <th scope="col" class="py-3 px-6">
                    Clasificacion
                </th>
                <th scope="col" class="py-3 px-6">
                    Precio
                </th>
                <th scope="col" class="py-3 px-6">
                    Existencias
                </th>
                <!--Buttons to do stuff-->
                <th colspan="2">
                    <button class="bg-blue-500 p-1 items-center rounded text-white">
                        <a href="<%=request.getContextPath()%>/newJuego">
                            Agregar <i class="fa-solid fa-plus"></i>
                        </a>
                    </button>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="juego" items="${listJuego}">
                <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                    <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                        <c:out value="${juego.getIdJuego()}"/>
                    </th>
                    <td class="py-4 px-6">
                        <c:out value="${juego.getNombreJuego()}"/>
                    </td>
                    <td class="py-4 px-6">
                        <c:out value="${juego.getNombreCategoria()}"/>
                    </td>
                    <td class="py-4 px-6">
                        <c:out value="${juego.getClasificacion()}"/>
                    </td>
                    <td class="py-4 px-6">
                        <c:out value="${juego.getPrecio()}"/> $
                    </td>
                    <td class="py-4 px-6">
                        <c:out value="${juego.getExistencias()}"/>
                    </td>
                    <!--Buttons to do stuff-->
                    <td class="py-4 px-6">
                        <a href="deleteJuego?idJuego=<c:out value='${juego.getIdJuego()}' />">
                            <i class="fa-solid fa-trash" style="color: red"></i>
                        </a>
                    </td>
                    <td class="py-4 px-6">
                        <a href="editJuego?idJuego=<c:out value='${juego.getIdJuego()}' />">
                            <i class="fa-solid fa-file-pen" style="color: #F7BD02"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>