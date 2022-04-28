package com.bamachadu.curso.application.service;

import java.util.Optional;

import com.bamachadu.curso.application.helpers.ObjectNotFoundException;
import com.bamachadu.curso.entity.domain.Categoria;
import com.bamachadu.curso.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public Categoria findById(Integer id) {
    Optional<Categoria> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
      "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
  }
}
