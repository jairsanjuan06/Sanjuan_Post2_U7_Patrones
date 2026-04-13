package com.example.hexagonal.config;

import com.example.hexagonal.domain.port.out.ProductoRepositoryPort;
import com.example.hexagonal.domain.service.ProductoDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductoDomainService productoDomainService(ProductoRepositoryPort repositoryPort) {
        return new ProductoDomainService(repositoryPort);
    }
}
