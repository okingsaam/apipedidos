package com.douglas.apipedidos.controller;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.mapper.PedidoMapper;
import com.douglas.apipedidos.model.Pedido;
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

    // POST - Criar pedido
    @PostMapping
    public PedidoResponseDTO criar(@Valid @RequestBody PedidoRequestDTO dto) {

        // DTO -> Entity
        Pedido pedido = PedidoMapper.toEntity(dto);

        // Salva
        Pedido salvo = service.salvar(pedido);

        // Entity -> ResponseDTO
        return PedidoMapper.toResponse(salvo);
    }

    // GET - Listar todos
    @GetMapping
    public List<PedidoResponseDTO> listar() {

        return service.listarTodos()
                .stream()
                .map(PedidoMapper::toResponse)
                .toList();
    }

    // GET - Buscar por id
    @GetMapping("/{id}")
    public PedidoResponseDTO buscar(@PathVariable Long id) {

        Pedido pedido = service.buscarPorId(id);

        return PedidoMapper.toResponse(pedido);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
