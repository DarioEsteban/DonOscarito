package com.usm.donoscarito.controllers.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.usm.donoscarito.controllersImpl"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()))
				.apiInfo(getApiInfo());
	}
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Rest Api - Arriendos DonOscarito",
				"Lógica interna para aplicación en Angular 11",
				"1.0",
				"https://github.com/DarioEsteban/DonOscarito",
				new Contact("Matías Gaete - Felipe Martínez - Francisco Rojas - Darío Verdugo", "https://github.com/DarioEsteban/DonOscarito", ""),
				"",
				"",
				Collections.emptyList()
				);
	}
	
	private SecurityScheme securityScheme() {
	    GrantType grantType = new AuthorizationCodeGrantBuilder()
	        .tokenEndpoint(new TokenEndpoint("" + "/token", "oauthtoken"))
	        .tokenRequestEndpoint(
	          new TokenRequestEndpoint("" + "/authorize", "CLIENT_ID", "CLIENT_SECRET"))
	        .build();

	    SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
	        .grantTypes(Arrays.asList(grantType))
	        .scopes(Arrays.asList(scopes()))
	        .build();
	    return oauth;
	}
	
	private AuthorizationScope[] scopes() {
	    AuthorizationScope[] scopes = { 
	      new AuthorizationScope("read", "for read operations"), 
	      new AuthorizationScope("write", "for write operations"), 
	      new AuthorizationScope("foo", "Access foo API") };
	    return scopes;
	}
	
	private SecurityContext securityContext() {
	    return SecurityContext.builder()
	      .securityReferences(
	        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
	      .forPaths(PathSelectors.regex("/foos.*"))
	      .build();
	}
}
