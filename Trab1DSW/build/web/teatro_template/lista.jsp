<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lista Teatros</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Teatros</h1>
        <h2>
            <a href="/teatro/cadastro">Adicione Novo Teatro</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/teatro/lista">Lista de Teatros</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Teatros</h2></caption>
            <tr>
                <th>CNPJ</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Acões</th>
            </tr>
            <c:forEach var="teatro" items="${requestScope.listaTeatro}">
                <tr>
                    <td><c:out value="${teatro.cnpj}" /></td>
                    <td><c:out value="${teatro.email}" /></td>
                    <td><c:out value="${teatro.senha}" /></td>
                    <td><c:out value="${teatro.nome}" /></td>
                    <td><c:out value="${teatro.cidade}" /></td>
                    <td>
                        <a href="edicao?cnpj=<c:out value='${teatro.cnpj}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?cnpj=<c:out value='${teatro.cnpj}' />" 
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