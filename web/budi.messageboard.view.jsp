<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${list}" var="row">
            ${row.pengirim}: ${row.pesan}
        </c:forEach>
        
        <form method="post">
            <input name="pengirim" placeholder="Pengirim">
            <input name="pesan" placeholder="Pesan">
            <button>Kirim</button>
        </form>
    </body>
</html>
