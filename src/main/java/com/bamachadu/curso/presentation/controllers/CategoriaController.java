package com.bamachadu.curso.presentation.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.bamachadu.curso.application.casoDeUso.CategoriaFindAll;
import com.bamachadu.curso.application.service.CategoriaService;
import com.bamachadu.curso.entity.domain.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

  @Autowired
  private CategoriaService service;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<CategoriaFindAll>> findAll() {
    List<Categoria> list = service.findAll();
    List<CategoriaFindAll> listAll = list.stream().map(obj -> new CategoriaFindAll(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listAll);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Categoria> find(@PathVariable Integer id) {
    Categoria obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> add(@RequestBody Categoria obj) {
    obj = service.add(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
    obj.setId(id);
    obj = service.update(obj);

    return ResponseEntity.noContent().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

}
