<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .main {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: blanchedalmond;
            }

            .top{
                width: 95%;
                height: 50px;
                padding: 0;
                text-align: center;
                float: left;
                background: gold;
            }

            .update{
                background: #e7f3d4;
                background: rgba(184,243,85,0.3);
                width: 100%;
                height: 100%; 
                border: 0px;
            }
            .user_info{
                float: left;
                background: springgreen;
                height: 100%;
                width: 15.8%;
                text-align: center;
            }

            .logout{
                float: right;
                width: 5%;
                height: 50px;
                text-align: center;
                background: aquamarine;
            }
            .logout a{
                display: block;
                width: 100%;
                height: 100%;   
            }

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
            .features-table
            {
                width: 100%;
                margin: 0 auto;
                border-collapse: separate;
                border-spacing: 0;
                border: 0;
                text-shadow: 0 1px 0 #fff;
                color: #2a2a2a;
                background: #fafafa;
                background-image: -moz-linear-gradient(top, #fff, #eaeaea, #fff); /* Firefox 3.6 */
                background-image: -webkit-gradient(linear,center bottom,center top,from(#fff),color-stop(0.5, #eaeaea),to(#fff));
                margin-top:20px;
                margin-bottom:20px;
            }
            .features-table td
            {
                height: 50px;
                padding: 0 20px;
                border-bottom: 1px solid #cdcdcd;
                box-shadow: 0 1px 0 white;
                -moz-box-shadow: 0 1px 0 white;
                -webkit-box-shadow: 0 1px 0 white;
                text-align: center;
                vertical-align: middle;
                display: table-cell;
            }
            .features-table tbody td
            {
                text-align: center;
                width: 150px;
            }
            .features-table td.grey
            {
                background: #efefef;
                background: rgba(144,144,144,0.15);
                border-right: 0px;
            }
            .features-table td.green
            {
                background: #e7f3d4;
//                background: rgba(184,243,85,0.3);
            }
            .features-table td:nowrap
            {
                white-space: nowrap;
            }
            .features-table thead td
            {
                font-size: 120%;
                font-weight: bold;
                -moz-border-radius-topright: 10px;
                -moz-border-radius-topleft: 10px;
                border-top-right-radius: 10px;
                border-top-left-radius: 10px;
                border-top: 1px solid #eaeaea;
            }
            .features-table tfoot td
            {
                font-size: 120%;
                font-weight: bold;
                -moz-border-radius-bottomright: 10px;
                -moz-border-radius-bottomleft: 10px;
                border-bottom-right-radius: 10px;
                border-bottom-left-radius: 10px;
                border-bottom: 1px solid #dadada;
            }
        </style>
    </head>
    <body>
        <div class="main">
            <div class="top">
                <div class="user_info">
                    <h3>Admin</h3>
                </div>
                <h2>Purchases!</h2>
            </div>
            <div class="logout">

                <a href="<c:url value="/j_spring_security_logout" />" >Logout</a> 
            </div>
            <div  class="table" id="table">

            </div>
        </div>
        <div class="popup__overlay">
            <div class="popup">
                <a href="#" class="popup__close">X</a>
                <h2>Welcome!</h2>
                <p>Please enter your login and password to continue</p>
                <form method="post" action="update_user">
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
                    <input type="submit" value="Update" />        
                </form>
            </div>
        </div>
        <script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>    
        <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>      
        <script type="text/javascript">
            
            $(getData);
            p = $('.popup__overlay');
            p.click(function(event) {
                e = event || window.event;
                if (e.target === this) {
                    $(p).css('display', 'none');
                }
            });

            $('.popup__close').click(function() {
                p.css('display', 'none');
            });
            function setTable(users) {
                var data = JSON.parse(users);
                var html = "<TABLE class=\"features-table\" summary=\"list users.\"><CAPTION>LIST USERS</CAPTION>";
                html += "<COLGROUP align=\"center\"><COLGROUP align=\"left\"> <COLGROUP align=\"center\" span=\"2\"><COLGROUP align=\"center\" span=\"3\">";
                html += "<tr><td><h2>Id</h2><td><h2>Login</h2><td><h2>Password</h2><td><h2>E-mail</h2><td><h2>Update</h2><td><h2>Delete</h2>";

                for (var user in data) {
                    html += "<TR><TD class=\"grey\">";
                    html += data[user].id;
                    html += "<TD class=\"green\">";
                    html += '<input type="text" class="update" value=' + data[user].login + '>';
                    html += "<TD class=\"green\">";
                    html += '<input type="text" class="update" value=' + data[user].password + '>';
                    html += "<TD class=\"green\">";
                    html += '<input type="text" class="update" value=' + data[user].email + '>';
                    html += "<TD class=\"grey\">";
                    html += '<input type="button" value="Up" onclick="setFields(' + data[user] + ')"/>';
                    html += "<TD class=\"grey\">";
                    html += '<input type="button" value="Del" onclick="deleteUser(' + data[user].id + ')"/>';
                }
var td_cells=document.getElementsByClassName('features-table')

for (var i=0; i < td_cells.length; i++)

alert(td_cells[i].innerHTML);
                $('#table').html("");
                $('#table').html(html);
            }

        /*    function updateUser(id, login, password, login) {
               // p = $('.popup__overlay');
               // p.css('display', 'block');

                $.ajax({
                    type: "get",
                    url: "/simpson/updateUser",
                    cache: false,
                    data: {"id": id, "login": login, "password": password, "email": email},
                    success: function(){
                        alert("User " + login + "is udated");
                    },
                    error: function() {
                        alert('Request from updateUser(), in event.jsp, to updateUser, in AjaxController.java, has failed');
                    }
                });
            }*/

            function setFields(user) {
                alert(user);
                document.getElementById('firstName').value = user.firstName;
                document.getElementById('lastName').value = user.lastName;
                document.getElementById('login').value = user.login;
                document.getElementById('password').value = user.password;
                document.getElementById('email').value = user.email;
            }

            function deleteUser(id) {
                if (!confirm("Do you reawantly want to delete this user")) {
                    return;
                } else {
                    $.ajax({
                        type: "get",
                        url: "/simpson/deleteUser",
                        data: {"id": id},
                        cache: false,
                        success: function(request) {
                            alert("User is deleted");
                        },
                        error: function() {
                            alert('Request Error');
                        }
                    });
                    location.reload();
                }
            }

            function getData() {
                $.ajax({
                    type: "get",
                    url: "getListUsers",
                    cache: false,
                    success: setTable,
                    error: function() {
                        alert('Request Error');
                    }
                });
            }

        </script>
    </body>
</html>