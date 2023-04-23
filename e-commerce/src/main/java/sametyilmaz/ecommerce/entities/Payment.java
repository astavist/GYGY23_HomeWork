package sametyilmaz.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String cardNumber;
    private String cardCvv;
    private double cardBalance;
    @OneToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    //TODO 1 - Ürünleri aktif veya pasif yapacak bir kod yazılmalıdır. Bu kod bir metod içinde yer almalıdır.
    // 2 - Ürünler listelenirken bir parametre kullanılmalıdır. Bu parametre ile pasif olan ürünlerin görünürlüğü kontrol edilebilir hale getirilmelidir.
    // 3 - Ürünlerin satışı için bir Sale servisi yazılmalıdır. Ürünün stokta olup olmadığını ve aktif durumda olup olmadığı kontrol edilmelidir.
    // 4 - Ürünün satılabilmesi için Payment servisi yazılmalıdır. Bu servis, müşterinin ödeme bilgilerini kontrol etmeli ve ödeme işlemini gerçekleştirmelidir.
    // 5 -Ürün satışı sonrası fatura müşteriye gönderilmelidir. Bu işlem simüle edilebilir.
}
