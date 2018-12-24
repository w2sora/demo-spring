package config.rootConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:context/applicationContext-dataSource.xml")
public class DataSourceConfig {
}
