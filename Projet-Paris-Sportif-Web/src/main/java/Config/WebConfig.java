package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebMvc
@ComponentScan({"Controllers", "fr.formation.model"})
//@EnableJpaRepositories("DAO_JPA")
public class WebConfig implements WebMvcConfigurer {
public void addResourceHandlers(ResourceHandlerRegistry registry) {
registry.addResourceHandler("/css/**").addResourceLocations("/css/");
registry.addResourceHandler("/images/**").addResourceLocations("/images/");
registry.addResourceHandler("/javascript/**").addResourceLocations("/javascript/");

}


@Bean
public SpringResourceTemplateResolver templateResolver() {
SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
templateResolver.setPrefix("/WEB-INF/templates/");
templateResolver.setSuffix(".html");
return templateResolver;
}

@Bean
public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
SpringTemplateEngine templateEngine = new SpringTemplateEngine();
templateEngine.setTemplateResolver(templateResolver);
templateEngine.setEnableSpringELCompiler(true);
templateEngine.addDialect(new LayoutDialect());
return templateEngine;
}

@Bean
public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
viewResolver.setTemplateEngine(templateEngine);
return viewResolver;
}

}