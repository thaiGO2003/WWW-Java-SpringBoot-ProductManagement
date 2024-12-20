package iuh.fit.se.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Code khong duoc rong")
	@Pattern(regexp = "[A-Za-z0-9]{1,10}", message = "Code phai la A-Z,a-z,0-9 va 10 ky tu toi da")
	private String code;
	@NotEmpty(message = "Ten khong duoc rong")
	@Pattern(regexp = "[A-Za-z0-9 ]{1,50}", message = "Code phai la A-Z,a-z,0-9, co khoang cach va 10 ky tu toi da")
	private String name;
	@NotEmpty(message = "Gia khong duoc rong")
	@Pattern(regexp = "[1-9]+[0-9]*\\.[0-9]{2}", message = "Gia phai 2 chu so thap phan va lon hon 0")
	private String price;
	@Size(max = 1000, message = "Mo ta toi da 1000 ky tu")
	private String description;
	@NotNull(message = "Danh muc phai duoc chon")
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	@NotNull(message = "Ngay dang ky phai duoc chon")
	private LocalDate registerDate;
	private boolean isActive;
}
