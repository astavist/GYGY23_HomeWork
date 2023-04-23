package sametyilmaz.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sametyilmaz.ecommerce.entities.enums.ProductEnums;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalPrice;
    private String paymentCustomerName;
    private String paymentCardNumber;
    private String cardExpirationYear;
    private String cardExpirationMonth;
    private String paymentCardCvv;
    private int saleQuantity;

    @ManyToOne
    private Product product;
    @OneToOne
    private Payment payment;
}
