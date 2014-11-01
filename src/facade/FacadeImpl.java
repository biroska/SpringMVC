package facade;

import javax.sql.DataSource;

import modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DAOs.UsuarioDAO;

@Repository
public class FacadeImpl {

	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	private DataSource dataSource;
	
    private JdbcTemplate jdbcTemplate;
  
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	public boolean autenticausuarioSenha( Usuario user ){
		System.out.println("FacadeImpl.autenticausuarioSenha()"+dataSource);
		return usuarioDao.autenticausuarioSenha(user);
	}
	
	public boolean inserirUsuario( Usuario user ){
		System.out.println("FacadeImpl.inserirUsuario()");
		return usuarioDao.inserirUsuario(user);
	}
	
}
