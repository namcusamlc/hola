<%-- 
    Document   : line
    Created on : May 23, 2018, 3:25:25 PM
    Author     : HoaPC
--%>

<%@page import="model.Point"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Line"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Draw lines</title>
        <% ArrayList<Line> lines = (ArrayList<Line>) request.getAttribute("lines");
        %>
        <% ArrayList<Point> points = (ArrayList<Point>) request.getAttribute("points");
        %>
    </head>
    <body>
        <canvas id="myCanvas" with="2000" height="2000"/>
        <script>

            function Point(x, y) {
                this.x = x;
                this.y = y;

                this.draw = function (ctx) {
                    ctx.beginPath();
                    ctx.arc(this.x, this.y, 1, 0, 2 * Math.PI);
                    ctx.fillStyle = "red";
                    ctx.strokeStyle = "red";
                    ctx.fill();
                    ctx.stroke();
                }
            }

            function Line(x1, y1, x2, y2) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;

                this.draw = function (ctx) {
                    ctx.beginPath();
                    ctx.moveTo(this.x1, this.y1);
                    ctx.lineTo(this.x2, this.y2);
                    ctx.lineWidth = 1.5;
                    ctx.strokeStyle = "black";
                    ctx.stroke();
                }
            }

            var lines = [];
            var points = [];

            function loadData() {
            <%
                for (Line line : lines) {
            %>
                lines.push(new Line(<%=line.getX1()%>,<%=line.getY1()%>,<%=line.getX2()%>,<%=line.getY2()%>));
            <%
                }
            %>

            <%
                for (Point point : points) {
            %>
                points.push(new Point(<%=point.getX()%>,<%=point.getY()%>));
            <%
                }
            %>
                var canvas = document.getElementById("myCanvas");
                var ctx = canvas.getContext("2d");
                for (var i = 0; i < lines.length; i++) {
                    lines[i].draw(ctx);
                }

                for (var i = 0; i < points.length; i++) {
                    points[i].draw(ctx);
                }
            }
            loadData();
        </script>
    </body>
</html>
