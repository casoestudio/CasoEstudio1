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
    private final ClienteService clienteService;
    @Autowired
    private final OperacionService operacionService;


   public ClienteController(ClienteService clienteService, OperacionService operacionService) {
        this.clienteService = clienteService;
        this.operacionService = operacionService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        operacionService.registrarLog("cliente", "get", "Consultar todos los clientes");
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable long id) {
        operacionService.registrarLog("cliente", "get", "Consultar cliente por id: " + id);
        return clienteService.findById((int) id);
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        operacionService.registrarLog("cliente", "post", "Crear cliente: "+ cliente);
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable long id) {
        operacionService.registrarLog("cliente", "delete", "Eliminar cliente por id: "+ id);
        clienteService.deleteCliente((int)id);
    }

    @PutMapping
    public Cliente actualizarCliente(@RequestBody Cliente cliente, @RequestParam long id) {
        operacionService.registrarLog("cliente", "put", "Actualizar cliente por id: "+ id);
        return clienteService.updateCliente(id, cliente);
    }

}
