package br.com.mba.engenharia.de.software.repository;

import br.com.mba.engenharia.de.software.negocio.contas.Contas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasRepository extends JpaRepository<Contas, Integer> {
}