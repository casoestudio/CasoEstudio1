package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Cliente;
import com.uptc.frw.casoestudio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findById(int id) {
        return clienteRepository.findById((long)id).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Cliente clienteOne = findById(cliente.getIdCliente());
        clienteOne.setNombre(cliente.getNombre());
        clienteOne.setTelefono(cliente.getTelefono());
        return save(clienteOne);
    }
    public void delete(int id) {
        clienteRepository.deleteById((long)id);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(long cliente) {
        return clienteRepository.save(cliente);
    }
    public void deleteCliente(long cliente) {

    }

    public Cliente findById() {
        return clienteRepository.findById(1L).orElse(null);
    }

}
