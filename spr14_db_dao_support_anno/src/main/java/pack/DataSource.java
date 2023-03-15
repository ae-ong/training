package pack;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSource extends DriverManagerDataSource{
	public DataSource() {
		// DriveManagerDataSource
		setDriverClassName("org.mariadb.jdbc.Driver");
		setUrl("jdbc:mariadb://127.0.0.1:3306/test");
		setUsername("root");
		setPassword("123");
	}
}
