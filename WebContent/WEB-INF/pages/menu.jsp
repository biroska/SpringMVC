<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div ${exibeMenu == true ? null : "style='display:none'"  }>	
	<nav class="navbar navbar-default" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li ${abaSelecionada == "inicio" ? "class='active'" : null } ><a href="#">Inicio</a></li>
				<li ${abaSelecionada == "usuario" ? "class='active'" : null } ><a href="#">Usuario</a></li>
				<li ${abaSelecionada == "Dropdown" ? "class='active'" : null } ><a href="#">Dropdown </a> </li>
			</ul>
		</div>
	</nav>
</div>