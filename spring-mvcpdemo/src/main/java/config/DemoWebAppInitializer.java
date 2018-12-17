package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class DemoWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 根应用上下文配置
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class, WebSecurityConfig.class};
    }

    /**
     * Servlet上下文配置
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(
                // 配置Multipart文件上传
                new MultipartConfigElement("/tmp/uploads",
                        2 * 1024 * 1024, 4 * 1024 * 1024, 0));
    }
}
