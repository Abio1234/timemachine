<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SCWT</title>
    <style>
        *{
            font-family: arial;
        }
        body{
            background-color: #33445C;
            margin: 0;
            padding: 0;
        }
        .login_button1{
            font-size: 90%;
            background-color: #33445C;
            color: white;
            border: outset 2px #33445C;
            margin: 0px 0 20px 20px;
            box-sizing: border-box;
            width: 290px;
            height: 30px;
        }
        .body_class{
            background-color: white;
            width: 960px;
            height: 1200px;
            border-left: 10px;
            margin: 0 350px;
        }
    </style>
</head>
<body>
<div class="body_class">
    <span style="margin: 200px 0 0 0"><H1 STYLE="color: #33445C" align="center">Система учета рабочего времени</H1></span>
    <%=session.getValue("name")%>
    <%=session.getValue("surname")%>
    <form action="/ServletForTime" method="post">
    <input type="submit" value="Пришел на работу" class="login_button1">
    </form>
    <%=session.getValue("begin_time")%>
    <br>
    <form action="/ServletForTime" method="get">
    <input type="submit" value="Ушел с работы" class="login_button1">
    </form>
    <%=session.getValue("end_time")%>
    <br>
    <%=session.getValue("all_time")%>
    <form action="/ServletForWorkTime" method="get">
        <input type="submit" value="Отработано пользователем" class="login_button1">
    </form>
    <%=session.getAttribute("list")%>
</div>
</body>
</html>
