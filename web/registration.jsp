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
            margin: 160px 0px 0 350px;
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
            height: 30px;
        }
        .login_pole{
            font-size: 90%;
            background-color: #ffffff;
            border: outset 1px #33445C;
            margin: 0px 20px 15px 19px;
            box-sizing: border-box;
            width: 290px;
            height: 30px;
        }
        .login_text{
            margin: 0px 20px 0px 18px;
            box-sizing: border-box;
            text-align: left;
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
                <span><H2>Регистрация</H2></span>
                <form action="/ServletForRegistration" method="post">
                <div class="login_text">Придумайте логин</div>
                <input type="text" name="login" placeholder="Имя пользователя" class="login_pole">
                <div class="login_text">Придумайте пароль</div>
                <input type="password" name="password" placeholder="Пароль" class="login_pole">
                <div class="login_text">Подтвердите пароль</div>
                <input type="password" name="password2" placeholder="Пароль" class="login_pole">
                <div class="login_text">Ваше имя</div>
                <input type="text" name="name" placeholder="Имя" class="login_pole">
                <div class="login_text">Ваша фамилия</div>
                <input type="text" name="surname" placeholder="Фамилия" class="login_pole">
                <div></div>
                <br/>
                <input type="submit" value="Зарегистрировать" class="login_button1">
                <br/>
                </form>
                <form action="/ServletForRegistration" method="get">
                <input type="submit" value="Назад" class="login_button2">
                </form>
            </div>
        </header>
    </p>
</div>
</body>
</html>
