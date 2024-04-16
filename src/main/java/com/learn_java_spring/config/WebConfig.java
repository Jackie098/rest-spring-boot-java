package com.learn_java_spring.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.learn_java_spring.serializations.converter.YamlJackson2HttpMessageConverter;

// FIXME: Configuration of ContentNegotiation for xml converter, does not works
// FIXME: Configuration of ContentNegotiation for yaml converter, does not works
// too
@Configuration
public class WebConfig implements WebMvcConfigurer {
  private static final MediaType MEDIA_TYPE_APPLICATION_YAML = MediaType.valueOf("application/x-yaml");

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new YamlJackson2HttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(@SuppressWarnings("null") ContentNegotiationConfigurer configurer) {
    // NOTE: Via QUERY params
    // configurer.favorParameter(true)
    // .parameterName("mediaType")
    // .ignoreAcceptHeader(true)
    // .useRegisteredExtensionsOnly(false)
    // .defaultContentType(MediaType.APPLICATION_JSON)
    // .mediaType("json", MediaType.APPLICATION_JSON)
    // .mediaType("xml", MediaType.APPLICATION_XML);

    // NOTE: Via HEADER params
    configurer.favorParameter(false)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json", MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML)
        .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YAML);
  }
}
