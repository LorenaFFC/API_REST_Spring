package com.gov.covid.controlevacina.service;

import com.gov.covid.controlevacina.domain.Usuario;
import com.gov.covid.controlevacina.domain.Vacina;
import com.gov.covid.controlevacina.repository.UsuarioRepository;
import com.gov.covid.controlevacina.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VacinaService {
    private VacinaRepository vacinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina save(Vacina vacina){
        return vacinaRepository.save(vacina);
    }

    public  Vacina criar(Vacina vacina){
        Usuario usuario = usuarioRepository.findById(vacina.getUsuario().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Cliente não encontrado."));
        vacina.setUsuario(usuario);

        return vacinaRepository.save(vacina);
    }
}
