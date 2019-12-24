package rest.practice.restapi.configs;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import rest.practice.restapi.accounts.Account;
import rest.practice.restapi.accounts.AccountRepository;
import rest.practice.restapi.accounts.AccountRole;
import rest.practice.restapi.accounts.AccountService;
import rest.practice.restapi.common.AppProperties;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 인코딩된 패스워드 앞에 인코딩 방식을 넣음
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
