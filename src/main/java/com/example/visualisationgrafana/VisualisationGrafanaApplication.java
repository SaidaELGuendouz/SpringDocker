package com.example.visualisationgrafana;

import com.example.visualisationgrafana.model.Product;
import com.example.visualisationgrafana.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VisualisationGrafanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualisationGrafanaApplication.class, args);
    }



    @Bean
    public CommandLineRunner commandLineRunner (ProductRepository productRepository) {
        return args -> {
            // Ajoutez des produits dans la base de données au démarrage
            productRepository.save(Product.builder().name("Product 1").price(10.99).build());
            productRepository.save(Product.builder().name("Product 2").price(20.99).build());
            productRepository.save(Product.builder().name("Product 3").price(30.99).build());
            // Affichez tous les produits ajoutés
            productRepository.findAll().forEach(product -> {
                System.out.println(product);
            });
        };
    }
    }