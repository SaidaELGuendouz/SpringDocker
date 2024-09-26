package com.example.visualisationgrafana.contoller;

import com.example.visualisationgrafana.micros.Post;
import com.example.visualisationgrafana.model.Product;
import com.example.visualisationgrafana.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    private  RestClient restClient;
@Autowired
    public ProductController(ProductRepository productRepository, RestClient.Builder restClient) {
        this.productRepository = productRepository;
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
@GetMapping("/posts")
    public List<Post> allPosts() {
        return restClient
                .get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});


    }

}
