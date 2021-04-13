
package com.gov.covid.controlevacina.controller;
import com.gov.covid.controlevacina.domain.Usuario;
import com.gov.covid.controlevacina.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario){
        try {
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}



/*@PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario){
        try {
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
        } catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }*/