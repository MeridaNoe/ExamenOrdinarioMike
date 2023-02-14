package mx.edu.utez.ExamenOrdinario.controller.user;

import mx.edu.utez.ExamenOrdinario.dto.UserDto;
import mx.edu.utez.ExamenOrdinario.model.user.User;
import mx.edu.utez.ExamenOrdinario.service.user.UserService;
import mx.edu.utez.ExamenOrdinario.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-examenordianrio/user/")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<User>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<User>> getOne(@PathVariable("id") Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CustomResponse<User>> insert(
            @Valid @RequestBody UserDto personDto){
        return new ResponseEntity<>(
                this.service.insert(personDto.getUser()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<User>> update(
            @RequestBody UserDto personDto,@Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(personDto.getUser()),
                HttpStatus.CREATED
        );
    }


}
