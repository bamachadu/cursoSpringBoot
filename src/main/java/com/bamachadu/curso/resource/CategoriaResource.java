package com.bamachadu.curso.resource;

import java.util.ArrayList;
import java.util.List;

import com.bamachadu.curso.domain.Categoria;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

  @RequestMapping(method = RequestMethod.GET)
  public List<Categoria> listar() {
    Categoria categoria1 = new Categoria(1, "Informática");
    Categoria categoria2 = new Categoria(1, "Escritorio");

    List<Categoria> lista = new ArrayList<>();

    lista.add(categoria1);
    lista.add(categoria2);

    return lista;
  }
}
