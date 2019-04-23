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
            <a href="cadastro">Adicione Novo Site</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista">Lista de Sites</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${site != null}">
            <form action="site/atualizacao" method="post">
            </c:if>
            <c:if test="${site == null}">
                <form action="site/insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${site != null}">
                                Edição
                            </c:if>
                            <c:if test="${site == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${site != null}">
                        <input type="hidden" name="id" value="<c:out value='${site.id}' />" />
                    </c:if>            
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="text" name="email" size="45" required
                                   value="<c:out value='${site.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="text" name="senha" size="45" required
                                   value="<c:out value='${site.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Url: </th>
                        <td>
                            <input type="text" name="url" size="45" required
                                   value="<c:out value='${site.url}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="nome" size="45" required  
                                   value="<c:out value='${site.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Telefone: </th>
                        <td>
                            <input type="number" name="telefone" size="45" required  
                                   value="<c:out value='${site.telefone}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salva" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>
    <c:if test="${!empty requestScope.mensagens}">
        <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
                </c:forEach>
        </ul>
    </c:if>
</body>
</html>
