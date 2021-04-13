package com.gov.covid.controlevacina.repository;

import com.gov.covid.controlevacina.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
