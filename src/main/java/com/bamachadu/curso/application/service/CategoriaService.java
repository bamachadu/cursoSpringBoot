package com.bamachadu.curso.application.service;

import java.util.List;
import java.util.Optional;

import com.bamachadu.curso.application.helpers.ObjectNotFoundException;
import com.bamachadu.curso.entity.domain.Categoria;
import com.bamachadu.curso.repositories.CategoriaRepository;
import com.bamachadu.curso.application.helpers.DataIntegrityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public List<Categoria> findAll() {
    List<Categoria> list = repository.findAll();
    return list;
  }

  public Categoria findById(Integer id) {
    Optional<Categoria> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
  }

  public Categoria add(Categoria obj) {
    obj.setId(null);
    return repository.save(obj);
  }

  public Categoria update(Categoria obj) {
    findById(obj.getId());
    return repository.save(obj);
  }

  public void delete(Integer id) {
    findById(id);
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não é possível excluir uma categoria que possua produtos");
    }
  }
}
