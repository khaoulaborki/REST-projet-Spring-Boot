package ma.formations.rest.tpREST.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
//import jakarta.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@XmlRootElement(name = "product") // 🔹 Nécessaire pour XML
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Positive
    private double price;

    @Min(0)
    private int quantity;
}
