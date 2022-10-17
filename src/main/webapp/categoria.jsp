<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
        <div class="w-full mt-4 flex justify-center items-center">
            <div class="overflow-x-auto relative">
                <table class="w-full text-sm text-left text-gray-500 dark:text-green-400">
                    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                        <th scope="col" class="py-3 px-6">
                            ID
                        </th>
                        <th scope="col" class="py-3 px-6">
                            Categoria
                        </th>
                        <th colspan="2">
                            <button class="bg-blue-500 p-1 items-center rounded text-white">
                                <a href="<%=request.getContextPath()%>/newCategoria">
                                    Agregar <i class="fa-solid fa-plus"></i>
                                </a>
                            </button>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="categoria" items="${listCategoria}">
                        <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                            <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                <c:out value="${categoria.getIdCategoria()}"/>
                            </th>
                            <td class="py-4 px-6">
                                <c:out value="${categoria.getNombreCategoria()}"/>
                            </td>
                            <td class="py-4 px-6">
                                <a href="deleteCategoria?idCategoria=<c:out value='${categoria.getIdCategoria()}' />">
                                    <i class="fa-solid fa-trash" style="color: red"></i>
                                </a>
                            </td>
                            <td class="py-4 px-6">
                                <a href="editCategoria?idCategoria=<c:out value='${categoria.getIdCategoria()}' />">
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