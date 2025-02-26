package com.narvasoft.apirest.controllers;

import com.narvasoft.apirest.models.Compras;
import com.narvasoft.apirest.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {
    @Autowired
    private ComprasService userService;//principio de Inversión de Dependencias (IoD)

    //Create a new user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Compras user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Get a user
    @GetMapping("/{id}")
    public ResponseEntity<?> readOne(@PathVariable(value = "id") Long id) {
        Optional<Compras> oUser = userService.findById(id);
        //si no se encuentra el usuario(el id) se retorna un not found
        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }//de locontrario se retorna el usuario
        return ResponseEntity.ok(oUser);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Compras userDetails, @PathVariable(value = "id") Long id) {
        Optional<Compras> user = userService.findById(id);
        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        //BeanUtils.copyProperties(userDetails, user.get());
        user.get().setCompra(userDetails.getCompra());
        user.get().setTamano(userDetails.getTamano());
        user.get().setCategoria(userDetails.getCategoria());
        user.get().setDisponibilidad(userDetails.getDisponibilidad());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }

    //Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Get all users
    @GetMapping
    public List<Compras> readAll() {
        List<Compras> users = StreamSupport//<--hereda de Object y me trae los stream
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }
}

