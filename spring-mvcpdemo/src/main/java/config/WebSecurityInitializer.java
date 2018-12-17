package config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 配置Spring Security的Filter，自动注册DelegatingFilterProxy
 */
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
