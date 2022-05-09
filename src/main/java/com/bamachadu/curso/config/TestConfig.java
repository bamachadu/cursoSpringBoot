package com.bamachadu.curso.config;

import java.text.ParseException;

import com.bamachadu.curso.application.db.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
  @Autowired DbService dbService;
  
  @Bean
  public boolean instantiateDatabase() throws ParseException {
    dbService.instantiateTestDatabase();
    return true;
  }
}
