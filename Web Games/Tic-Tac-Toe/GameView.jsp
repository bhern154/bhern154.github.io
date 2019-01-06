<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean class="TicTacToe.GameBean" id="player" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tic-Tac-Toe Game</title>
<style>
div.container{
text-align: center;
float: left;
width: 25%;
height: 150px;
border: 2px solid black;
}
div.container a:link {
text-decoration: none;
}
p {
text-align:center;
font-size: 300%;
font-family: "Chalkduster", fantasy, sans-serif;
}
h1 {
text-align:center;
font-size: 300%;
}
.button {
background-color: red;
border: none;
color: white;
padding: 15px 32px;
text-align: center;
text-decoration: none;
display: inline-block;
font-size: 16px;
margin: 4px 2px;
cursor: pointer;
}
.wrapAll{
 margin-left: 20%;
}
.wrapper{
	width: 100%;
	text-align: center;
}
.token{
position: relative;
top: 25%;
text-align:center;
font-size: 400%;
font-family: "Chalkduster", fantasy, sans-serif;
}
</style>
</head>
<body style="background-color:powderblue;">

		<h1>Tic-Tac-Toe</h1>
		
		
		<c:choose>
		
			<c:when test = "${player.isGameOver() == true}">
		
				<p>${player.getWinner()}</p>
				
				<div class=wrapAll>
				<c:forEach items="${slots}" var="entry" varStatus="status">
			
					<div class=container>
						<c:choose>
							<c:when test="${ entry.press == true}">
								<p>${entry.token}</p>
							</c:when>
							<c:otherwise>
								<p>${entry.token}</p>
							</c:otherwise>
						</c:choose>
					</div>
					
				</c:forEach>
				</div>
				
				<div class="wrapper">
					<a href="NewGameController" class="button">Play Again</a>
				</div>
			
			</c:when>
			
			<c:otherwise>
		
				<p>${player.getPlayer()}</p>
				
				<div class=wrapAll>
				<c:forEach items="${slots}" var="entry" varStatus="status">
					
					<div class=container>
						<c:choose>
							<c:when test="${ entry.press == true}">
								<p>${entry.token}</p>
							</c:when>
							<c:otherwise>
								<a class = "token" href="PlayController?position=${entry.position}">${entry.token}</a>
							</c:otherwise>
						</c:choose>
					</div>
					
				</c:forEach>
				</div>
		
			</c:otherwise>
		
		</c:choose>
		
</body>
</html>
	
