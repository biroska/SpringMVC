<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>

<div ${usuarioLogado != null ? null : "style='display:none'"  }>	
	<nav class="navbar navbar-default" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li ${abaSelecionada == "inicio" ? "class='active'" : null } ><a href="principal">Inicio</a></li>
				<li ${abaSelecionada == "usuario" ? "class='active'" : null } ><a href="cadastroUsuario">Usuario</a></li>
				<li ${abaSelecionada == "Dropdown" ? "class='active'" : null } ><a href="#">Dropdown </a> </li>
			</ul>
			<c:if test="${usuarioLogado != null}">
				<ul class="nav navbar-nav navbar-right">
	        		<li>
	        			<p class="navbar-text">
	        				<a href="logoff" class="navbar-link" >Logout</a>
        				</p>
	       			</li>
				</ul>
			</c:if>	
		</div>
	</nav>
</div>