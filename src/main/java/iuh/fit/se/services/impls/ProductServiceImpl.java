package iuh.fit.se.services.impls;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.fit.se.entities.Product;
import iuh.fit.se.repositories.ProductRepository;
import iuh.fit.se.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> findProductByCategoryOrIsActiveOrRegisterDate(String category, String isActive, int subDays) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		LocalDate subDate = date.minusDays(subDays);
		return productRepository.findProductByCategoryOrIsActiveOrRegisterDate(category, isActive, date.toString(), subDate.toString());
	}

	@Override
	public List<Product> findProductByCodeAndCategoryId(String code, String categoryId) {
		// TODO Auto-generated method stub
		return productRepository.findProductByCodeAndCategoryId(code, categoryId);
	}

	@Override
	@Transactional
	public Product save(Product product) throws Exception {
		// TODO Auto-generated method stub
		if (findProductByCodeAndCategoryId(product.getCode(), String.valueOf(product.getCategory().getId()))
				.isEmpty()) {
			return productRepository.save(product);
		} else {
			throw new Exception("Chi cho phep 1 code trong cung category thoi");
		}
	}

	@Override
	@Transactional
	public Product update(int id, Product product) throws Exception {
		// TODO Auto-generated method stub
		Product exist = findById(id);
		if (exist != null) {
			if (!findProductByCodeAndCategoryId(product.getCode(), String.valueOf(product.getCategory().getId()) )
					.isEmpty() && !(exist.getCode().equals(product.getCode()) && exist.getCategory().getId()==product.getCategory().getId())) {
				throw new Exception("Chi cho phep 1 code trong cung category thoi");
			}else {
				return productRepository.save(product);
			}
		} return null;
	}

	@Override
	@Transactional
	public void remove(int id) {
		// TODO Auto-generated method stub
		Product product = findById(id);
		if (product != null) {
			product.setActive(false);
			productRepository.save(product);
		}
	}
}
