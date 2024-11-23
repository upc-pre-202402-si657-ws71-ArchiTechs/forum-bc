package com.microservice.foroum.forum.infrastructure.persistence.jpa.repositories;

import com.microservice.foroum.forum.domain.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByName(String Name);
}
