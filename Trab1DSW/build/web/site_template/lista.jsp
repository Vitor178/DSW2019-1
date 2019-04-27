<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <fmt:bundle basename="i18n.Messages">
    <head>
        <title><fmt:message key="reservation.sites"/></title>
    </head>
    <body>
    <center>
        <h1><fmt:message key="sites.management"/></h1>
        <h2>
            <a href="/site/cadastro"><fmt:message key="Add.site"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="/site/lista"><fmt:message key="List.site"/></a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2><fmt:message key="List.site"/></h2></caption>
            <tr>
                <th><fmt:message key="id"/></th>
                <th><fmt:message key="email"/></th>
                <th><fmt:message key="senha"/></th>
                <th><fmt:message key="url"/></th>
                <th><fmt:message key="nome"/></th>
                <th><fmt:message key="telefone"/></th>
            </tr>
            <c:forEach var="site" items="${requestScope.listaSite}">
                <tr>
                    <td><c:out value="${site.id}" /></td>
                    <td><c:out value="${site.email}" /></td>
                    <td><c:out value="${site.senha}" /></td>
                    <td><c:out value="${site.url}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                    <td>
                        <a href="/site/edicao?id=<c:out value='${site.id}' />"><fmt:message key="edit"/></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/site/remocao?id=<c:out value='${site.id}' />" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            <fmt:message key="remove"/>
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <a href="/index.jsp"><fmt:message key="login.page"/></a>
    </div>	
</body>
</fmt:bundle>
</html>