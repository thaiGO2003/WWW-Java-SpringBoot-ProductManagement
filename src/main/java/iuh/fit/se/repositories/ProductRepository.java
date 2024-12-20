package iuh.fit.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query(value = "SELECT * FROM product WHERE 1=1 AND ((register_date BETWEEN :subDate AND :registerDate) OR :subDate IS null) AND (is_active = :isActive OR :isActive IS NULL) AND (category_id in (SELECT id FROM category WHERE name = :category) OR :category IS NULL)", nativeQuery = true)
	public List<Product> findProductByCategoryOrIsActiveOrRegisterDate(@Param("category") String category,@Param("isActive") String isActive, @Param("registerDate") String registerDate, @Param("subDate") String subDate);
	@Query(value = "SELECT * FROM product WHERE CODE = :code AND category_id = :categoryId", nativeQuery = true)
	public List<Product> findProductByCodeAndCategoryId(@Param("code") String code, @Param("categoryId") String categoryId);
}
