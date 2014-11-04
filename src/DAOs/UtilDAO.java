package DAOs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UtilDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
	public DataSource getDataSource() {
		return dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
