package sametyilmaz.rentacar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

//lombok
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brand") //burada isimlendirmeler snake_case
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "test") //burada table ve column yazmasak da çalışır ama isimleri kendimiz vermek istiyoruz o yüzden kendimiz yazdık
    private String name;
}
