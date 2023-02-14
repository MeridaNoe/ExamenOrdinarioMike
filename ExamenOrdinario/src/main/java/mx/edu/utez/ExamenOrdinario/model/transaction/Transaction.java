package mx.edu.utez.ExamenOrdinario.model.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.ExamenOrdinario.model.products.Products;
import mx.edu.utez.ExamenOrdinario.model.user.User;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,length = 150)
    private Long id_usuario;
    @Column(nullable = false,length = 150)
    private Long id_product;
    @Column(nullable = false)
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "id_products",nullable = false)
    private Products products;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private User users;


}
