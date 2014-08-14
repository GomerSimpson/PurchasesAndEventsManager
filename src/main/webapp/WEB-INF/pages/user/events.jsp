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
            .leftline{
                background: #ffc0cb;
                height: 100%;
                width: 15%;
            }
            .home{
                height: 16%;
                width: 100%;
                text-align: center;
                font-size: 26px;
                background: magenta;
                word-wrap: break-word;
            }
            .home a{
                display: block;
                width: 100%;
                height: 100%;  
            }
            .purch{
                height: 10%;
                width: 100%;
                text-align: center;
                font-size: 26px;
                background: greenyellow;
                word-wrap: break-word; 
            }

            .purch a{
                display: block;
                width: 100%;
                height: 100%;
            }
            .chooser{
                height: 10%;
                width: 100%;
                background: yellow;
                text-align: center;
            }
            .chooser h2{
                word-wrap: break-word;
            }
            .chooser input{
                display: block;
                width: 100%;
                height: 40%; 
                font-size: 20px;
            }
            .set{
                height: 30%;
                width: 100%;
                background: aqua;
                text-align: center;
                word-wrap: break-word;
            }
            .select{
                width: 100%;
            }

            .text_area{
                width: 98.5%;
                border-style: outset;
                resize: none;
                background-position: bottom;
                background-repeat: repeat-x;

                background-color: beige;
            }
            * {
                margin : 0; 
                padding : 0;
            } 

        </style>

    </head>
    <body><div class="main">
            <div class="top">
                <div class="user_info">
                    <h6>Victor Kolbik</h6>
                </div>
                <h2>Events!</h2>
            </div>
            <div class="logout">

                <a href="<c:url value="/j_spring_security_logout" />" >Logout</a> 
            </div>
            <div class="leftline">
                <div class="home">
                    <a href="${pageContext.request.contextPath}/user/events">Home</a>
                </div>
                <div class="purch">
                    <a href="${pageContext.request.contextPath}/user/purchases">Purchases</a>
                </div>
                <div class="set">
                    <form method="post" id="form" action="http://localhost:8084/simpson/setEvent">
                        <label>Message</label><br>
                        <textarea class="text_area" rows="4" maxlength="100"></textarea>
                        <label for="year">Year</label><br>
                        <select id="year" class="select" name="year" onchange="setDayOptions();">
                        </select><br>
                        <label for="month">Month</label><br>
                        <select id="month" class="select" name="month" onchange="setDayOptions();">
                        </select><br>
                        <label for="date">Day: </label><br>
                        <select name="day" class="select" id="day">
                        </select><br>
                        <input type="submit" id="submit">
                    </form>
                </div>
                <div class="chooser">
                    <h2 >Calendar</h2>
                    <input type="date" title="Calendar" onchange="setEvents();" name="calendar" id="calendar" style="">                  
                </div>

            </div>
        </div>

        <script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>    
        <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>      
        <script type="text/javascript">
                        var months = ["", "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"];
                        //    $(setYearAndMonthOptions);
                        //    $(setDayOptions);
                        $(setRealDate);
 document.getElementById('calendar').value = new Date();
                        //       $('#year').val(2014).change();
//alert(document.forms.form.firstName.value);
                        function setRealDate() { 
                            setYearAndMonthOptions();
                            setDayOptions();
                            var date = new Date();

                            var monthSelect = document.forms.form.month;
                            var yearSelect = document.forms.form.year;
                            var daySelect = document.forms.form.day;
                            yearSelect.value = date.getYear() + 1900;
                            monthSelect.value = months[date.getMonth() + 1];
                            daySelect.value = date.getDate();


                        }

                        function setYearAndMonthOptions() {
                            var monthSelect = document.forms.form.month;
                            var yearSelect = document.forms.form.year;

                            for (var i = 1900; i < 2100; i++) {
                                var year = new Option(i, i, false, false);
                                yearSelect.options[yearSelect.options.length] = year;
                            }

                            for (var j = 1; j <= 12; j++) {
                                var month = new Option(months[j], months[j], false, false);
                                monthSelect.options[monthSelect.options.length] = month;
                            }
                        }

                        function setDayOptions() {
                            var monthSelect = document.forms.form.month;
                            var yearSelect = document.forms.form.year;
                            var daySelect = document.forms.form.day;

                            var year = yearSelect.options[yearSelect.selectedIndex].value;
                            var month = monthSelect.options[monthSelect.selectedIndex].value;
                            daySelect.options.length = 0;

                            for (var j = 1; j <= 31; j++) {
                                var day = new Option(j, j, false, false);
                                daySelect.options[daySelect.options.length] = day;

                                if (j === 28 && parseInt(year) % 4 !== 0 && month === "February") {
                                    break;
                                } else if (j === 29 && parseInt(year) % 4 === 0 && month === "February") {
                                    break;
                                } else if (j === 30 && (month === "April" || month === "June" || month === "September" || month === "November")) {
                                    break;
                                }
                            }

                        }
                        /*    
                         function getData() {
                         var date = new Date();
                         $.ajax({
                         type: "get",
                         url: "http://localhost:8084/simpson/getEvents",
                         cache: false,
                         data: {"day": date},
                         success: setEvents,
                         error: function() {
                         alert('Request Error');
                         }
                         });
                         }*/

        </script>
    </body>
</html>
