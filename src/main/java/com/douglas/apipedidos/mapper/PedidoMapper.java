package com.douglas.apipedidos.mapper;

import com.douglas.apipedidos.dto.PedidoRequestDTO;
import com.douglas.apipedidos.dto.PedidoResponseDTO;
import com.douglas.apipedidos.model.Pedido;

public class PedidoMapper {

    // RequestDTO -> Entity
    public static Pedido toEntity(PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();

        pedido.setCliente(dto.getCliente());
        pedido.setValor(dto.getValor());

        return pedido;
    }

    // Entity -> ResponseDTO
    public static PedidoResponseDTO toResponse(Pedido pedido) {

        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setId(pedido.getId());
        dto.setCliente(pedido.getCliente());
        dto.setValor(pedido.getValor());
        dto.setDataCriacao(pedido.getDataCriacao());

        return dto;
    }
}
