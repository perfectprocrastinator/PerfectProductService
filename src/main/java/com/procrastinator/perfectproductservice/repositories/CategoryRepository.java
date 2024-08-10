package com.procrastinator.perfectproductservice.repositories;

import com.procrastinator.perfectproductservice.models.Category;
import com.procrastinator.perfectproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category c);
    // Optional ensures that returned object is never null.Instead it is an
    // Optional object which might contain a category or not.
    Optional<Category> findByName(String categoryName);


}
