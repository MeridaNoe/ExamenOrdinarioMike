package mx.edu.utez.ExamenOrdinario.service.user;

import mx.edu.utez.ExamenOrdinario.model.user.User;
import mx.edu.utez.ExamenOrdinario.model.user.UserRepository;
import mx.edu.utez.ExamenOrdinario.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    @Transactional(readOnly = true)
    public CustomResponse<List<User>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(readOnly = true)
    public CustomResponse<User> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<User> insert(User user){
        if(this.repository.existsByNombre(user.getNombre()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El producto ya ha sido registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(user),
                false,
                200,
                "Producto registrado correctamente"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<User> update(User user){
        if(!this.repository.existsById(user.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El usuario no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(user),
                false,
                200,
                "Usuario actualizado correctamente"
        );
    }
}
