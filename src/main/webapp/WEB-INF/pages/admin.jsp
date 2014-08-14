<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin's page!</h1>
        <div id="table"></div>
        <a href="<c:url value="/j_spring_security_logout" />" >Logout</a>

        <script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>    
        <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>      
        <script type="text/javascript">
            $(getData);
            function setTable(users) {
                var data = JSON.parse(users);
                var html = "<TABLE summary=\"list users.\"><CAPTION>LIST USERS</CAPTION>";
                html += "<COLGROUP align=\"center\"><COLGROUP align=\"left\"> <COLGROUP align=\"center\" span=\"2\"><COLGROUP align=\"center\" span=\"3\">";
                html += "<THEAD valign=\"top\"><TR><TH>Id<TH>Login<TH>Password<TBODY>";
                for (var user in data) {
                    html += "<TR><TD>";
                    html += data[user].id;
                    html += "<TD>";
                    html += data[user].login;
                    html += "<TD>";
                    html += data[user].password;
                    html += "<TD>";
                    html += '<button onclick="deleteUser(' + data[user].id + ')">Delete user</button>';
                }

                $('#table').html("");
                $('#table').html(html);
            }

            function deleteUser(id) {
                if (!confirm("Do you realy want to delete this user")) {
                    return;
                } else {
                    $.ajax({
                        type: "get",
                        url: "http://localhost:8084/simpson/deleteUser",
                        data: {"id": id},
                        cache: false,
                        success: function(request) {
                            alert("User is deleted");
                        },
                        error: function() {
                            alert('Request Error');
                        }
                    });
                }
            }
            function getData() {
                $.ajax({
                    type: "get",
                    url: "http://localhost:8084/simpson/getListUsers",
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