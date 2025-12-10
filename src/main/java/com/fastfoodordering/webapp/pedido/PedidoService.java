package com.fastfoodordering.webapp.pedido;

import com.fastfoodordering.webapp.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido createPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido", "id", id));
    }

    public Pedido updatePedido(Long id, Pedido pedidoDetalle){
        Pedido pedido = getPedidoById(id);
        pedido.setEstado(pedidoDetalle.getEstado());
        pedido.setCalificacion(pedidoDetalle.getCalificacion());
        pedido.setComentarios(pedidoDetalle.getComentarios());
        pedido.setMontoTotal(pedidoDetalle.getMontoTotal());
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Long id){
        Pedido pedido = getPedidoById(id);
        pedidoRepository.delete(pedido);
    }

}
