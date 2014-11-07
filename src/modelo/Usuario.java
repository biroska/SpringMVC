package modelo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Usuario {

	private Long id;
	private String usuario;
	private String senha;
	private String email;
	
	public Usuario() {
		super();
	}
	public Usuario(Long id, String usuario, String senha, String email) {
		this.usuario = usuario;
		this.senha = senha;
		this.id = id;
		this.email = email; 
	}
	
	public Usuario(String usuario, String senha, String email) {
		this.usuario = usuario;
		this.senha = senha;
		this.email = email; 
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}