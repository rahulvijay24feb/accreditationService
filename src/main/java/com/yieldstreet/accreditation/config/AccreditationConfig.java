package com.yieldstreet.accreditation.config;

import com.yieldstreet.accreditation.session.UserSession;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AccreditationConfig {

  @Bean
  public static CustomScopeConfigurer getCustomScopeConfigurer() {
    CustomScopeConfigurer configurer = new CustomScopeConfigurer();
    Map<String, Object> threadScopes = new HashMap<String, Object>();
    threadScopes.put("thread", new SimpleThreadScope());
    configurer.setScopes(threadScopes);
    return configurer;
  }

  @Bean
  public UserSession getUserSession() {
    return new UserSession();
  }
}
