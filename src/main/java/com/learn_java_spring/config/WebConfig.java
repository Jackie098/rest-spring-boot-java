package com.learn_java_spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// FIXME: Configuration of ContentNegotiation for xml converter, does not works
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void configureContentNegotiation(@SuppressWarnings("null") ContentNegotiationConfigurer configurer) {
    configurer.favorParameter(true)
        .parameterName("mediaType")
        .ignoreAcceptHeader(true)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json", MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML);
  }
}