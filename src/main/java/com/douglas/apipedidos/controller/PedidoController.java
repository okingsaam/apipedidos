package com.douglas.apipedidos.controller;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.model.Pedido;
import com.douglas.apipedidos.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public PedidoResponseDTO criar(@Valid @RequestBody PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setCliente(dto.getCliente());
        pedido.setValor(dto.getValor());

        Pedido salvo = service.salvar(pedido);

        return toResponseDTO(salvo);
    }

    // GET
    @GetMapping
    public List<PedidoResponseDTO> listar() {

        return service.listarTodos()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // GET por id
    @GetMapping("/{id}")
    public PedidoResponseDTO buscar(@PathVariable Long id) {

        Pedido pedido = service.buscarPorId(id);

        return toResponseDTO(pedido);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // Conversor
    private PedidoResponseDTO toResponseDTO(Pedido pedido) {

        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setId(pedido.getId());
        dto.setCliente(pedido.getCliente());
        dto.setValor(pedido.getValor());
        dto.setDataCriacao(pedido.getDataCriacao());

        return dto;
    }
}
