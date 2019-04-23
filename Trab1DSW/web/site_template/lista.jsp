<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Sites de Reserva</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Sites</h1>
        <h2>
            <a href="/site/cadastro">Adicione Novo Site</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/site/lista">Lista de Sites</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Sites</h2></caption>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Url</th>
                <th>Nome</th>
                <th>Telefone</th>
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
                        <a href="/site/edicao?id=<c:out value='${site.id}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/site/remocao?id=<c:out value='${site.id}' />" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>