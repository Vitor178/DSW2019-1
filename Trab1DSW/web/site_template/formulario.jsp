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
            <a href="cadastro"><fmt:message key="Add.site"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista"><fmt:message key="List.site"/></a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${site != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${site == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${site != null}">
                                <fmt:message key="edit"/>
                            </c:if>
                            <c:if test="${site == null}">
                                <fmt:message key="register"/>
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${site != null}">
                        <input type="hidden" name="id" value="<c:out value='${site.id}' />" />
                    </c:if>          
                   <tr>
                        <th><fmt:message key="id"/> </th>
                        <td>
                            <input type="number" name="id" size="45" required
                                   value="<c:out value='${site.id}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="email"/> </th>
                        <td>
                            <input type="text" name="email" size="45" required
                                   value="<c:out value='${site.email}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="senha"/> </th>
                        <td>
                            <input type="text" name="senha" size="45" required
                                   value="<c:out value='${site.senha}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="url"/> </th>
                        <td>
                            <input type="text" name="url" size="45" required
                                   value="<c:out value='${site.url}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="nome"/> </th>
                        <td>
                            <input type="text" name="nome" size="45" required  
                                   value="<c:out value='${site.nome}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th><fmt:message key="telefone"/> </th>
                        <td>
                            <input type="text" name="telefone" size="45" required  
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
          <br />
        <a href="/index.jsp"><fmt:message key="login.page"/></a>
    </div>
    <c:if test="${!empty requestScope.mensagens}">
        <ul class="erro">
            <c:forEach items="${requestScope.mensagens}" var="mensagem">
                <li>${mensagem}</li>
                </c:forEach>
        </ul>
    </c:if>
</body>
</fmt:bundle>
</html>
