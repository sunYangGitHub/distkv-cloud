package cloud.distkv.common.config;

import cloud.distkv.common.intercepters.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  // Allow access to static resources.
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
  }

  // Intercept all requests.
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authenticationInterceptor())
        .addPathPatterns("/**");
  }

  @Bean
  public HandlerInterceptor authenticationInterceptor() {
    return new AuthenticationInterceptor();
  }
}
