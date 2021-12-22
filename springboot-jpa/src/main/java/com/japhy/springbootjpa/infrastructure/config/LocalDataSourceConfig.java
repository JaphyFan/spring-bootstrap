package com.japhy.springbootjpa.infrastructure.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Japhy
 * @since 2021/12/21 10:55
 */
@Configuration
@Profile("local")
public class LocalDataSourceConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase build = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .addScript("db/schema.sql")
                .addScript("db/data.sql").build();
        return build;
    }
}
