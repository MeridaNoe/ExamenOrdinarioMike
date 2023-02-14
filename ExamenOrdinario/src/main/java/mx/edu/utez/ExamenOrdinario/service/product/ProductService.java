package mx.edu.utez.ExamenOrdinario.service.product;

import mx.edu.utez.ExamenOrdinario.model.products.Products;
import mx.edu.utez.ExamenOrdinario.model.products.ProductsRepository;
import mx.edu.utez.ExamenOrdinario.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProductService {


    @Autowired
    private ProductsRepository repository;


    @Transactional(readOnly = true)
    public CustomResponse<List<Products>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(readOnly = true)
    public CustomResponse<Products> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Products> insert(Products products){
        if(this.repository.existsByNombre(products.getNombre()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El producto ya ha sido registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(products),
                false,
                200,
                "Producto registrado correctamente"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Products> update(Products products){
        if(!this.repository.existsById(products.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El porducto no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(products),
                false,
                200,
                "Producto actualizado correctamente"
        );
    }


}
