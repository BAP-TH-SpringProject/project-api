package bap.com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {

		private Long id_product;
		private String product_name;
		private int product_type;
		private String image;
		private double sale;
		private int quantity;
		private String descriptions;
		private double price;

		public Products() {}
		public Products(Long id_product, String product_name, int product_type, String image, double sale, int quantity,String descriptions, double price) {
			this.id_product = id_product;
			this.product_name = product_name;
			this.product_type = product_type;
			this.image = image;
			this.sale = sale;
			this.quantity = quantity;
			this.descriptions = descriptions;
			this.price = price;
		}
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId_product() {
			return id_product;
		}
		public void setId_product(Long id_product) {
			this.id_product = id_product;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public int getProduct_type() {
			return product_type;
		}
		public void setProduct_type(int product_type) {
			this.product_type = product_type;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public double getSale() {
			return sale;
		}
		public void setSale(double sale) {
			this.sale = sale;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getDescriptions() {
			return descriptions;
		}
		public void setDescriptions(String descriptions) {
			this.descriptions = descriptions;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}

	}


