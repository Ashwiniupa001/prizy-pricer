package com.prizy.pricer.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Swagger Config class for Swagger implementation with API info.
 * <p>
 * 
 * @author Ashwini Upadhyay
 * @Version 1.0
 * @date 2019-Mar-15 4:20:08 PM
 */
@Configuration
@EnableSwagger2

public class SwaggerConfig implements WebMvcConfigurer {

  public static final Contact DEFAULT_CONTACT = new Contact("Ashwini upadhyay",
      "https://swagger.io/tools/swagger-ui/", "ashwini.upa001@gmail.com");

  public static final ApiInfo DEFAULT_API_INFO =
      new ApiInfo("Prizy Pricer API Title", "Prizy Pricer API Description", "1.0", "urn:tos", DEFAULT_CONTACT,
          "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
      new HashSet<>(Arrays.asList("application/json"));

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
        .produces(DEFAULT_PRODUCES_AND_CONSUMES).consumes(DEFAULT_PRODUCES_AND_CONSUMES);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

}
