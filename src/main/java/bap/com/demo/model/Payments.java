package bap.com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments implements Serializable{

    @Id
    @Column(name = "id_paid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paid;

    @ManyToOne
//  @MapsId("id_product")
    @JoinColumn(name = "id_product")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Products products;

    @ManyToOne
//  @MapsId("id_user")
    @JoinColumn(name = "id_user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Users users;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "total")
    private double total;
    @Column(name = "payment_method")
    private String payment_method;

}
