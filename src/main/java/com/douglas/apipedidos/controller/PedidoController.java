package com.douglas.apipedidos.controller;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // POST - Criar
    @Operation(summary = "Criar um novo pedido")
    @PostMapping
    public PedidoResponseDTO criar(@Valid @RequestBody PedidoRequestDTO dto) {
        return service.salvar(dto);
    }

    // GET - Listar todos
    @Operation(summary = "Listar todos os pedidos com paginação")
    @GetMapping
    public Page<PedidoResponseDTO> listar(Pageable pageable) {
        return service.listarTodos(pageable);
    }

    // GET - Buscar por id
    @Operation(summary = "Buscar pedido por ID")
    @GetMapping("/{id}")
    public PedidoResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // PUT - Atualizar
    @Operation(summary = "Atualizar um pedido")
    @PutMapping("/{id}")
    public PedidoResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody PedidoRequestDTO dto) {

        return service.atualizar(id, dto);
    }

    // DELETE - Deletar
    @Operation(summary = "Deletar um pedido")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}