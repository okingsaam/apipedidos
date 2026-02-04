package com.douglas.apipedidos.service;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.mapper.PedidoMapper;
import com.douglas.apipedidos.model.Pedido;
import com.douglas.apipedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public PedidoResponseDTO salvar(PedidoRequestDTO dto) {
        Pedido pedido = PedidoMapper.toEntity(dto);
        Pedido salvo = repository.save(pedido);
        return PedidoMapper.toResponse(salvo);
    }

    // GET ALL
    public List<PedidoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(PedidoMapper::toResponse)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return PedidoMapper.toResponse(pedido);
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
