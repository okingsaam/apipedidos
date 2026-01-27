package com.douglas.apipedidos.controller;

import com.douglas.apipedidos.model.Pedido;
import com.douglas.apipedidos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // POST - Criar pedido
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return service.salvar(pedido);
    }

    // GET - Listar todos
    @GetMapping
    public List<Pedido> listar() {
        return service.listarTodos();
    }

    // GET - Buscar por id
    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // DELETE - Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
