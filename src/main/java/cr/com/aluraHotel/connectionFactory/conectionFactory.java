package cr.com.aluraHotel.connectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class conectionFactory {
	private DataSource dataSource;
	
	public conectionFactory() {
		var poolDataSource = new ComboPooledDataSource();
		poolDataSource.setJdbcUrl("jdbc:mysql://localhost/sistemahoteleria?useTimeZone=true&serverTimeZone=UTC");
		poolDataSource.setUser("root");
		poolDataSource.setPassword("@Mc_r69Howlearn?J");
		poolDataSource.setMaxPoolSize(20);
		
		this.dataSource = poolDataSource;
	}
	
	public Connection reConnection() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
