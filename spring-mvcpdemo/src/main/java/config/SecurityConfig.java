package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebSecurityConfig.class, MethodSecurityConfig.class})
public class SecurityConfig {
}
