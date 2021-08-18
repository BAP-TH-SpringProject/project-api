package bap.com.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_product;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_type")
    private String product_type;
    @Column(name = "image")
    private String image;
    @Column(name = "sale")
    private double sale;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Payments> payments = new HashSet<>();

}
