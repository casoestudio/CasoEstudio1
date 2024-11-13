package com.uptc.frw.casoestudio.controller;

import com.uptc.frw.casoestudio.models.Cliente;
import com.uptc.frw.casoestudio.service.ClienteService;
import com.uptc.frw.casoestudio.service.logs.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @Autowired
    private OperacionService operacionService;

    @GetMapping
    public List<Cliente> listarClientes() {
        operacionService.registrarLog("cliente", "get", "Consultar todos los clientes");
        return clienteService.listarClientes();
    }


    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable long id) {
        operacionService.registrarLog("cliente", "get", "Consultar cliente por id: "+ id);
        return clienteService.findById((long)id).orElse(null);
    }

    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        operacionService.registrarLog("cliente", "post", "Crear cliente: "+ cliente);
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable long id) {
        operacionService.registrarLog("cliente", "delete", "Eliminar cliente por id: "+ id);
        clienteService.deleteCliente(id);
    }

    @PutMapping
    public Cliente actualizarCliente(@RequestBody Cliente cliente, @RequestParam long id) {
        operacionService.registrarLog("cliente", "put", "Actualizar cliente por id: "+ id);
        return clienteService.updateCliente(id);
    }

}
