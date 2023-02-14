package mx.edu.utez.ExamenOrdinario.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenOrdinario.model.products.Products;
import mx.edu.utez.ExamenOrdinario.model.transaction.Transaction;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDto {
    private Long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 150)
    private String nombre;
    private String categoria;
    private Double precio;
    private Boolean disponibilidad;
    private List<Transaction> transactions;

   public Products getProduct(){
       return new Products(
               getId(),
               getNombre(),
               getCategoria(),
               getPrecio(),
               getDisponibilidad(),
               getTransactions());
   }
}
