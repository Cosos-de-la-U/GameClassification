<%@ page import="main.DB.PostgresDriver" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<body>
<div class="container mt-4 mx-auto">
    <h1 class="text-3xl font-bold underline ">
        <%
            PostgresDriver pd = new PostgresDriver();
            pd.getConnection();
        %>
    </h1>
</div>
</body>