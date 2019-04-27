<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <fmt:bundle basename="i18n.Messages">
    <head>
        <title><fmt:message key="List.theaters"/></title>
    </head>
    <body>
    <center>
        <h1><fmt:message key="Theater.management"/></h1>
        <h2>
            <a href="/teatro/cadastro"><fmt:message key="Add.theater"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="/teatro/lista"><fmt:message key="List.theaters"/></a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2><fmt:message key="List.theaters"/></h2></caption>
            <tr>
                <th><fmt:message key="cnpj"/></th>
                <th><fmt:message key="email"/></th>
                <th><fmt:message key="senha"/></th>
                <th><fmt:message key="nome"/></th>
                <th><fmt:message key="cidade"/></th>
                <th><fmt:message key="acoes"/></th>
            </tr>
            <c:forEach var="teatro" items="${requestScope.listaTeatro}">
                <tr>
                    <td><c:out value="${teatro.cnpj}" /></td>
                    <td><c:out value="${teatro.email}" /></td>
                    <td><c:out value="${teatro.senha}" /></td>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.cidade}" /></td>
                    <td>
                        <a href="/teatro/edicao?cnpj=<c:out value='${teatro.cnpj}' />"><fmt:message key="edit"/></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/teatro/remocao?cnpj=<c:out value='${teatro.cnpj}' />" 
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