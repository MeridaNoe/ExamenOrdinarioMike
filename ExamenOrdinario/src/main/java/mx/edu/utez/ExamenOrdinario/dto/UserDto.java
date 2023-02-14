package mx.edu.utez.ExamenOrdinario.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenOrdinario.model.products.Products;
import mx.edu.utez.ExamenOrdinario.model.transaction.Transaction;
import mx.edu.utez.ExamenOrdinario.model.user.User;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 150)
    private String nombre;
    private String corrreo_electronico;
    private String contrasena;
    private String wish_list;
    private List<Transaction> transactions;

    public User getUser(){
        return new User(
                getId(),
                getNombre(),
                getCorrreo_electronico(),
                getContrasena(),
                getWish_list(),
                getTransactions());
    }
}
