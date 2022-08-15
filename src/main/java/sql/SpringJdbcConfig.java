package sql;

import com.lirik.service.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

@Configuration
public class SpringJdbcConfig {

        @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ccd");
        dataSource.setUsername("root");
        dataSource.setPassword("011016");

        return dataSource;
    }

   @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
   }
}