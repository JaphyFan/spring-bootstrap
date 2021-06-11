package com.japhy.example.solr.repository;

import com.japhy.example.solr.entity.Product;
import java.util.List;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author Japhy
 * @since 2021/5/18 16:16
 */
public interface ProductRepository extends SolrCrudRepository<Product, String> {

    List<Product> findByName(String name);
}
