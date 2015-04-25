<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .center{
                width: 100%;
                height: 95%;
            }
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
            .table{
                width: 85%;
                height: 100%;
                float: right;
                background: mediumslateblue;
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
                float: left;
            }
            .home{
                height: 10%;
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
            .eve{
                height: 10%;
                width: 100%;
                text-align: center;
                font-size: 26px;
                background: greenyellow;
                word-wrap: break-word; 
            }

            .eve a{
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
                height: 35%;
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
                border-right: 1px solid white;
            }
            .features-table td.green
            {
                background: #e7f3d4;
                background: rgba(184,243,85,0.3);
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
                    <p>User: </p>
                </div>
                <h2>Purchases!</h2>
            </div>
            <div class="logout">

                <a href="<c:url value="/j_spring_security_logout" />" >Logout</a> 
            </div>
            <div class="center">
                <div class="leftline">
                    <div class="home">
                        <a href="${pageContext.request.contextPath}/user/events">Home</a>
                    </div>
                    <div class="eve">
                        <a href="${pageContext.request.contextPath}/user/events">Events</a>
                    </div>
                    <div class="set">
                        <form method="get" id="form" action="http://localhost:8084/simpson/setPurchase">
                            <label for="puechase">Message</label><br>
                            <textarea class="text_area" rows="4" maxlength="100" name="purchase"></textarea>
                            <label for="price">Price</label><br>
                            <input type="number" min="0" id="price" name="price"><br>
                            <label for="year">Year</label><br>
                            <select id="year" class="select" name="year" onchange="setDayOptions();">
                            </select><br>
                            <label for="month">Month</label><br>
                            <select id="month" class="select" name="month" onchange="setDayOptions();">
                            </select><br>
                            <label for="date">Day: </label><br>
                            <select name="day" class="select" id="day">
                            </select><br>
                            <input type="submit" id="submit" value="Add purchase">
                        </form>
                    </div>
                    <div class="chooser">
                        <h2 >Calendar</h2>
                        <input type="date" title="Calender" onchange="getEvents();" id="calendar" name="Calendar" style="">             
                    </div>

                </div>
                <div  class="table" id="table">

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
                            $(setUserName);
                            $(setRealDate);
                            $(initCalendar);


                            //       $('#year').val(2014).change();
                            //alert(document.forms.form.firstName.value);
                            function setUserName() {
                                $.ajax({
                                    type: "get",
                                    url: "http://localhost:8084/simpson/getUserName",
                                    //      data: {"void_data": "void_data"},
                                    cache: false,
                                    success: function(name) {
                                        //   alert("good");
                                        var element = document.querySelector('.user_info');
                                        element.innerHTML = "User: " + "<b>" + name + "</b>";

                                    },
                                    error: function() {
                                        alert('Request from getEvents(), in event.jsp, to AjaxController.java has failed');
                                    }
                                });
                            }

                            function initCalendar() {
                                var date = new Date();
                                var currentDate = ((1900 + date.getYear()) + "-" + ((date.getMonth() + 1) < 10 ? "0" : "") + (date.getMonth() + 1) + "-" + date.getDate()).toString();
                                document.getElementById('calendar').setAttribute("value", currentDate);
                                getPurchases();
                            }

                            function getPurchases() {
                                var date = new Date(document.getElementById('calendar').value);
                                var price = document.getElementById('price').value;
                                //   alert(date.getYear() + 1900);
                                $.ajax({
                                    type: "get",
                                    url: "/simpson/getPurchases",
                                    data: {"day": date.getDate(), "month": date.getMonth(), "year": date.getYear(), "price": price},
                                    cache: false,
                                    success: setTable,
                                    error: function() {
                                        alert('Request Error in getEvents() from event.jsp');
                                    }
                                });
                            }

                            function setTable(purchases) {
                                var data = JSON.parse(purchases);

                                var html = "<TABLE class=\"features-table\" summary=\"events.\"><CAPTION><h2>Events</h2></CAPTION>";
                                html += "<COLGROUP align=\"center\"><COLGROUP align=\"left\"> <COLGROUP align=\"center\" span=\"2\"><COLGROUP align=\"center\" span=\"3\">";
                                html += "<tr><td><h2>Number</h2><td><h2>Purchase</h2><td><h2>Price</h2><td><h2>Delete</h2>";

                                var i = 0;

                                for (var purchase in data) {
                                    html += "<TR><TD class=\"grey\">";
                                    html += ++i;
                                    html += "<TD class=\"green\">";
                                    html += data[purchase].name;
                                    html += "<TD class=\"green\">";
                                    html += data[purchase].price;
                                    html += "<TD class=\"grey\">";
                                    html += '<input type="button" value="Del" onclick="deletePurchase(' + data[purchase].id + ')"/>';
                                }
                                //  alert("setTable from event.jsp");
                                $('#table').html("");
                                $('#table').html(html);
                            }

                            function deletePurchase(id) {
                                if (!confirm("Do you reawantly want to delete this purchase")) {
                                    return;
                                } else {
                                    $.ajax({
                                        type: "get",
                                        url: "/simpson/deletePurchase",
                                        data: {"id": id},
                                        cache: false,
                         /*               success: function(request) {
                                            alert(request);
                                        },*/
                                        error: function() {
                                            alert('Request Error in deletePurchase from purchases.jsp');
                                        }
                                    });
                                    location.reload();
                                }
                            }

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
