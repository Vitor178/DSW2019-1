<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <fmt:bundle basename="i18n.Messages">
    <head>
        <title><fmt:message key="List.promotion"/></title>
    </head>
    <body>
 
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2><fmt:message key="List.promotion"/></h2></caption>
            <tr>
                <th><fmt:message key="id"/></th>
                <th><fmt:message key="cnpj"/></th>
                <th><fmt:message key="preco"/></th>
                <th><fmt:message key="nome"/></th>
                <th><fmt:message key="dia"/></th>
                <th><fmt:message key="horario"/></th>
            </tr>
            <c:forEach var="promocao" items="${requestScope.listaPromocao}">
                <tr>
                    <td><c:out value="${promocao.id}" /></td>
                    <td><c:out value="${promocao.cnpj}" /></td>
                    <td><c:out value="${promocao.preco}" /></td>
                    <td><c:out value="${promocao.nomePeca}" /></td>
                    <td><c:out value="${promocao.dia}" /></td>
                    <td><c:out value="${promocao.horario}" /></td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <a href="/index.jsp"><fmt:message key="login.page"/></a>
    </div>	
</body>
</fmt:bundle>
</html>