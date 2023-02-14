package mx.edu.utez.ExamenOrdinario.model.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenOrdinario.model.transaction.Transaction;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,length = 150)
    private String nombre;
    @Column(nullable = false,length = 150)
    private String correo_electronico;
    @Column(nullable = false, length = 150)
    private String contrasena;
    @Column(nullable = false, length = 150)
    private String wish_list;

    @OneToMany(mappedBy="users")
    @JsonIgnore
    private List<Transaction> transactions;

}
