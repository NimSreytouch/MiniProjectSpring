package homeworkspring.demospring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
public class DatabaseConfiguration {
    @Bean
    @Profile("memory")
    public DataSource memory() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        //,"classpath:/static/sql/generate_articles.sql"
        embeddedDatabaseBuilder.addScripts("classpath:/static/sql/create_tb_categories.sql","classpath:/static/sql/create_tb_article.sql");
        return embeddedDatabaseBuilder.build();
    }
}
