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

    // GET -> listar todos
    @GetMapping
    public List<Pedido> listar() {
        return service.listarTodos();
    }

    // POST -> salvar
    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return service.salvar(pedido);
    }
}
