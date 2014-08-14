<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Login page</title>
        <style>
            html {
                min-height: 100%
            }
            body {
                min-height: 100%;
                background: #fff;
                font: 14px/125% Tahoma;
            }
            p {
                margin: 1em 0;
                text-align: center
            }
            .popup__overlay {
                display: none;
                position: fixed;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                background: rgba(0,0,0,.7);
                text-align: center
            }
            .popup__overlay:after {
                display: inline-block;
                height: 100%;
                width: 0;
                vertical-align: middle;
                content: ''
            }
            .popup {
                display: inline-block;
                position: relative;
                max-width: 80%;
                padding: 20px;
                border: 5px solid #fff;
                border-radius: 15px;
                box-shadow: inset 0 2px 2px 2px rgba(0,0,0,.4);
                background: #fff;
                vertical-align: middle
            }
            .row {
                margin: 1em 0
            }
            label {
                display: inline-block;
                width: 120px;
                text-align: left
            }
            input[type="text"], input[type="password"] {
                margin: 0;
                padding: 2px;
                border: 1px solid;
                border-color: #999 #ccc #ccc;
                border-radius: 2px
            }
            input[type="button"], input[type="submit"] {
                padding: 6px 16px;
                border: 0;
                border-radius: 2px;
                -webkit-box-shadow: inset 0 1px 1px rgba(255,255,255,.3);
                box-shadow:         inset 0 1px 1px rgba(255,255,255,.3);
                cursor: pointer;
                background: #444;
                background: -webkit-linear-gradient(90deg, #515151, #333 48%, #333 52%, #515151 100%);
                background:    -moz-linear-gradient(90deg, #515151, #333 48%, #333 52%, #515151 100%);
                background:     -ms-linear-gradient(90deg, #515151, #333 48%, #333 52%, #515151 100%);
                background:      -o-linear-gradient(90deg, #515151, #333 48%, #333 52%, #515151 100%);
                background:         linear-gradient(90deg, #515151, #333 48%, #333 52%, #515151 100%);
                color: #fff
            }
            .popup__close {
                display: block;
                position: absolute;
                top: -20px;
                right: 10px;
                width: 12px;
                height: 12px;
                padding: 8px;
                border: 5px solid #fff;
                border-radius: 50%;
                -webkit-box-shadow: inset 0 2px 2px 2px rgba(0,0,0,.4),
                    0 3px 3px     rgba(0,0,0,.4);
                box-shadow:         inset 0 2px 2px 2px rgba(0,0,0,.4),
                    0 3px 3px     rgba(0,0,0,.4);
                cursor: pointer;
                background: #fff;
                text-align: center;
                font-size: 12px;
                line-height: 12px;
                color: #444;
                text-decoration: none;
                font-weight: bold
            }
            .popup__close:hover {
                background: #ddd
            }            
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Login page</h1>

        <p>
            <c:if test="${error == true}">
                <b class="error">Invalid login or password.</b>
            </c:if>
        </p>
        <p>
            <c:if test="${wrongLogin == true}">
                <h1><b>login already exists.</b></h1>
            </c:if>
        </p>
        <form method="post" action="<c:url value='j_spring_security_check'/>" >
            <table>
                <tbody>
                    <tr>
                        <td>Login:</td>
                        <td><input type="text" name="j_username" id="j_username"size="30" maxlength="40"  /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="j_password" id="j_password" size="30" maxlength="32" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Login" />          <input type="button" value="Registrate!" id="popup__toggle" /></td>
                    </tr>
                </tbody>
            </table>
        </form>	
    <div class="popup__overlay">
        <div class="popup">
            <a href="#" class="popup__close">X</a>
            <h2>Welcome!</h2>
            <p>Please enter your login and password to continue</p>
            <form method="post" action="http://localhost:8084/simpson/new_user">
                <div class="row">
                    <label for="firstName">firstName</label>
                    <input type="text" id="firstName" name="firstName" value="" />
                </div>
                <div class="row">
                    <label for="lastName">lastName</label>
                    <input type="text" id="lastName" name="lastName" value="" />
                </div>
                <div class="row">
                    <label for="login">Login</label>
                    <input type="text" id="login" name="login" value="" />
                </div>
                <div class="row">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" value="" />
                </div>
                <div class="row">
                    <label for="email">E-mail</label>
                    <input type="email" id="email" name="email" value=""/>
                </div>
                <input type="submit" value="Registrate" />        
            </form>
        </div>
    </div>
   <!--  <a href="${pageContext.request.contextPath}/admin.html">Login as  an Administrator</a><br/>-->
        </p>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>      <!--Atention!!!!   a local file!!!!! you shold use http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js-->
    <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>       <!--   Atention!!!!   a local file!!!!! you shold use http://www.technicalkeeda.com/js/javascripts/plugin/json2.js-->
    <script type="text/javascript">
        /*    function sendData(){
         $.ajax({
         type: "post"
         url:  "http://localhost:8084/simpson/new_user"
         //dataType: "json"
         });
         }*/
        p = $('.popup__overlay');
        $('#popup__toggle').click(function() {
            p.css('display', 'block');
        });
        p.click(function(event) {
            e = event || window.event;
            if (e.target == this) {
                $(p).css('display', 'none');
            }
        });
        $('.popup__close').click(function() {
            p.css('display', 'none');
        });

    </script>
    </body>
</html>