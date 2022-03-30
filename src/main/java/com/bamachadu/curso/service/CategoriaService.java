package com.bamachadu.curso.service;

import java.util.Optional;

import com.bamachadu.curso.domain.Categoria;
import com.bamachadu.curso.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public Categoria buscar(Integer id) {
    Optional<Categoria> obj = repository.findById(id);
    return obj.orElse(null);
  }
}
