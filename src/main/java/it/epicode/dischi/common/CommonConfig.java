package it.epicode.dischi.common;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class CommonConfig {

    @Bean
    public Faker faker(){
        return new Faker(Locale.ITALY);
    }
}
