package iuh.fit.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
