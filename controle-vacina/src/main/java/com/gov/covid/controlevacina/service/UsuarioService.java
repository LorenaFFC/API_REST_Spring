
package com.gov.covid.controlevacina.service;
import com.gov.covid.controlevacina.domain.Usuario;
import com.gov.covid.controlevacina.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    //Injecao de Dependencia

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Criando o servico para salvar no BD
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario) ;
    }
}
