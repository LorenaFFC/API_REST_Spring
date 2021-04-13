package com.gov.covid.controlevacina.controller;

import com.gov.covid.controlevacina.domain.Usuario;
import com.gov.covid.controlevacina.domain.Vacina;
import com.gov.covid.controlevacina.service.VacinaService;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.sql.SQLDataException;
import java.sql.SQLException;

@RestController
@RequestMapping("vacinas")
public class VacinaController {

    private VacinaService vacinaService;
    private Usuario usuario;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;

    }

    @PostMapping
    public ResponseEntity<Vacina> save(@RequestBody @Valid Vacina vacina){
        try {

            return new ResponseEntity<>(vacinaService.criar(vacina), HttpStatus.CREATED);
        } catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }

        }

   }


