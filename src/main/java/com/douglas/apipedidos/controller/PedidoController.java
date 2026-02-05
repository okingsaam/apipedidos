package com.douglas.apipedidos.controller;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // POST - Criar
    @PostMapping
    public PedidoResponseDTO criar(@Valid @RequestBody PedidoRequestDTO dto) {
        return service.salvar(dto);
    }

    // GET - Listar todos
    @GetMapping
    public List<PedidoResponseDTO> listar() {
        return service.listarTodos();
    }

    // GET - Buscar por id
    @GetMapping("/{id}")
    public PedidoResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public PedidoResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PedidoRequestDTO dto) {

        return service.atualizar(id, dto);
    }

    // DELETE - Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
