package config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.net.URI;

public class MyCustomAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Log4j2配置文件路径
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        context.setConfigLocation(URI.create("classpath:config/log4j2.yml"));
        context.reconfigure();
        // servletContext.setInitParameter(Log4jWebSupport.LOG4J_CONFIG_LOCATION, "classpath:config/log4j2.yml");

        // 配置Druid监控JDBC
        ServletRegistration.Dynamic druidStatViewServlet =
                servletContext.addServlet("DruidStatView", StatViewServlet.class);
        druidStatViewServlet.addMapping("/druid/*");

        // 配置Druid监控Web应用
        FilterRegistration.Dynamic druidWebStatFilter =
                servletContext.addFilter("DruidWebStatFilter", WebStatFilter.class);
        druidWebStatFilter.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        druidWebStatFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
