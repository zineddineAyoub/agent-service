package ensa.pay.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

   // @Bean
   /* public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }*/

    private final static Logger LOGGER = LoggerFactory.getLogger(Configuration.class);



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        LOGGER.info("Enabling {}","Cross-Origin!");
        registry.addMapping("/**")
                .allowedHeaders("*").allowedOrigins("*").allowedMethods("*");

    }
}