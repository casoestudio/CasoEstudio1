package com.uptc.frw.casoestudio.service;

import com.uptc.frw.casoestudio.models.Cliente;
import com.uptc.frw.casoestudio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
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
    public void deleteCliente (int id) {
        clienteRepository.deleteById((long)id);
    }

    public Cliente updateCliente(long id, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistenteOpt = clienteRepository.findById(id);

        if (clienteExistenteOpt.isPresent()) {
            Cliente clienteExistente = clienteExistenteOpt.get();

            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setDireccion(clienteActualizado.getDireccion());

            return clienteRepository.save(clienteExistente); // Guarda el cliente actualizado
        } else {
            throw new RuntimeException("Cliente no encontrado con el id: " + id);
        }
    }


}
