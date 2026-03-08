package com.douglas.apipedidos.service;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.exception.PedidoNaoEncontradoException;
import com.douglas.apipedidos.mapper.PedidoMapper;
import com.douglas.apipedidos.model.Pedido;
import com.douglas.apipedidos.repository.PedidoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoResponseDTO salvar(PedidoRequestDTO dto) {
        Pedido pedido = PedidoMapper.toEntity(dto);
        return PedidoMapper.toResponse(repository.save(pedido));
    }

    public Page<PedidoResponseDTO> listarTodos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(PedidoMapper::toResponse);
    }

    public PedidoResponseDTO buscarPorId(Long id) {
        return PedidoMapper.toResponse(buscarPedido(id));
    }

    public PedidoResponseDTO atualizar(Long id, PedidoRequestDTO dto) {
        Pedido pedido = buscarPedido(id);

        pedido.setCliente(dto.getCliente());
        pedido.setValor(dto.getValor());

        return PedidoMapper.toResponse(repository.save(pedido));
    }

    public void deletar(Long id) {
        repository.delete(buscarPedido(id));
    }

    private Pedido buscarPedido(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException(id));
    }
}