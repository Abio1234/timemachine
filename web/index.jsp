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
      min-width: 1100px;
      overflow-x: hidden;
    }

    .login{
      position: fixed;
      background-color: white;
      margin: 230px 0px 0 350px;
      padding: 3px 0 4px 4px;
      border: outset 2px #ffffff;
      float: left;
      line-height: 1.5em;

    }
    .login_button1, .login_button2{
      font-size: 90%;
      background-color: #33445C;
      color: white;
      border: outset 2px #33445C;
      position: relative;
      float: left;
      margin: 0px 0 20px 20px;
      box-sizing: border-box;
      width: 290px;
      height: 31px;
    }
    .login_pole1, .login_pole2{
      font-size: 90%;
      background-color: #ffffff;
      border: outset 1px #33445C;
      position: relative;
      float: left;
      margin: 0px 20px 20px 20px;
      box-sizing: border-box;
      width: 290px;
      height: 31px;
    }
    .body_class{
      width: 960px;
      margin: 0 auto;
      border-left: 10px;
    }
  </style>
</head>
<body class="body_class">
<div>
  <p class="size">
    <header>
      <div class="login" align="center">
        <span><H2>Авторизация</H2></span>
        <form action="/MainServlet" method="post">
        <input type="text" name="login" placeholder="Имя пользователя" class="login_pole1">
        <br>
        <input type="password" name="password" placeholder="Пароль" class="login_pole2">
        <br/>
        <input type="submit" value="Войти" class="login_button1">
        <br/>
        </form>
        <form action="/MainServlet" method="get">
        <input type="submit" value="Регистрация" class="login_button2">
        </form>
      </div>
    </header>
  </p>
</div>
</body>
</html>
