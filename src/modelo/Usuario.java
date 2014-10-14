package modelo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Usuario {

	private Long id;
	private String usuario;
	private String senha;
	private String nome;
	private String email;
	
	public Usuario() {
		super();
	}
	public Usuario(Long id, String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		Random r = new Random();
		this.id = id;
		this.nome = usuario +" " + usuario;
		this.email = usuario + "@mock.com.br"; 
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}