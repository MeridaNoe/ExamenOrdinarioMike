package mx.edu.utez.ExamenOrdinario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenOrdinario.model.transaction.Transaction;
import mx.edu.utez.ExamenOrdinario.model.user.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private Long id;
    private Long id_usuario;
    private Long id_product;
    private Date fecha;
    @NotNull
    @NotBlank
    private List<Transaction> transactions;

    /*public Transaction getTransaction(){
        return new Transaction(
                getId(),
                getId_usuario(),
                getId_product(),
                getFecha(),
                getTransactions());
    }*/
}
