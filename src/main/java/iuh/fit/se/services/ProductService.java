package iuh.fit.se.services;

import java.util.List;

import iuh.fit.se.entities.Product;

public interface ProductService {
	public Product findById(int id);
	public List<Product> findAll();
	List<Product> findProductByCodeAndCategoryId(String code, String categoryId);
	public Product save(Product product) throws Exception;
	public Product update(int id, Product product)  throws Exception;
	public void remove(int id);
	List<Product> findProductByCategoryOrIsActiveOrRegisterDate(String category, String isActive, int subDays);
}
