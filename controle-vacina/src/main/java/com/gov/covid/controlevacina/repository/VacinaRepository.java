package com.gov.covid.controlevacina.repository;

import com.gov.covid.controlevacina.domain.Usuario;
import com.gov.covid.controlevacina.domain.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacinaRepository  extends JpaRepository<Vacina, Long> {


}
