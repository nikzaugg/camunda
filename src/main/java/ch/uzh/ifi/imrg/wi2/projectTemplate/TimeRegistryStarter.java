package ch.uzh.ifi.imrg.wi2.projectTemplate;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableProcessApplication
public class TimeRegistryStarter {

    public static void main(String[] args) {
        SpringApplication.run(TimeRegistryStarter.class, args);
    }
 
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

}
