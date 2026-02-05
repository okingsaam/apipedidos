package com.douglas.apipedidos.service;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.exception.PedidoNaoEncontradoException;
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

    public PedidoResponseDTO salvar(PedidoRequestDTO dto) {
        Pedido pedido = PedidoMapper.toEntity(dto);
        Pedido salvo = repository.save(pedido);
        return PedidoMapper.toResponse(salvo);
    }

    public List<PedidoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(PedidoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException(id));

        return PedidoMapper.toResponse(pedido);
    }

    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO dto) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException(id));

        pedido.setCliente(dto.getCliente());
        pedido.setValor(dto.getValor());

        Pedido atualizado = repository.save(pedido);
        return PedidoMapper.toResponse(atualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
