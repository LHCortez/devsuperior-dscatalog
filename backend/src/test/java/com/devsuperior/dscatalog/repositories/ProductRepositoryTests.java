package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class ProductRepositoryTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void deleteShouldDeleteObjectWhenIdExists() {

        long existingID = 1L;
        repository.deleteById(existingID);

        Optional<Product> result = repository.findById(existingID);
        assertFalse(result.isPresent());

    }

    @Test
    void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        long nonExistingID = 1000L;

        assertThrows(EmptyResultDataAccessException.class, () -> repository.deleteById(nonExistingID));

    }

}
