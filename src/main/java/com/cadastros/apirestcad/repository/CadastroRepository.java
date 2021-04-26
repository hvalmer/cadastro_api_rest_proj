package com.cadastros.apirestcad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastros.apirestcad.models.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
