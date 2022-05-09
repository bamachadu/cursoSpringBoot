package com.bamachadu.curso.application.service;

import java.util.List;
import java.util.Optional;

import com.bamachadu.curso.application.dto.ClienteDto;
import com.bamachadu.curso.application.dto.ClienteNewDto;
import com.bamachadu.curso.application.helpers.DataIntegrityException;
import com.bamachadu.curso.application.helpers.ObjectNotFoundException;
import com.bamachadu.curso.entity.domain.Cidade;
import com.bamachadu.curso.entity.domain.Cliente;
import com.bamachadu.curso.entity.domain.Endereco;
import com.bamachadu.curso.entity.models.TipoCliente;
import com.bamachadu.curso.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository repository;
  // @Autowired
  // private EnderecoRepository enderecoRepository;

  public Cliente findById(Integer id) {
    Optional<Cliente> obj = repository.findById(id);
    // tratamento realizado para proteger contra a serialização Json cíclica
    return obj.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
  }

  public List<Cliente> findAll() {
    List<Cliente> list = repository.findAll();
    return list;
  }

  public Cliente add(Cliente obj) {
    obj.setId(null);
    return repository.save(obj);
  }

  public Cliente update(Cliente obj) {
    Cliente newObj = findById(obj.getId());
    updateData(newObj, obj);
    return repository.save(newObj);
  }

  public void delete(Integer id) {
    findById(id);
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityException("Não é possível excluir um Cliente que possua pedidos");
    }
  }

  public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
    return repository.findAll(pageRequest);
  }

  public Cliente fromDto(ClienteDto objDto) {
    return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
  }

  public Cliente fromDto(ClienteNewDto objDto) {
    Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfCnpj(),
        TipoCliente.toEnum(objDto.getTipoCliente()));
    Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
    Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
        objDto.getBairro(), objDto.getCep(), cli, cid);

    cli.getEnderecos().add(end);
    cli.getTeleones().add(objDto.getTelefone1());

    if (objDto.getTelefone2() != null) {
      cli.getTeleones().add(objDto.getTelefone2());
    }

    if (objDto.getTelefone3() != null) {
      cli.getTeleones().add(objDto.getTelefone3());
    }

    return cli;
  }

  private void updateData(Cliente newObj, Cliente obj) {
    newObj.setNome(obj.getNome());
    newObj.setEmail(obj.getEmail());
  }
}
