package com.fastfoodordering.webapp.pedido;

import com.fastfoodordering.webapp.itempedido.ItemPedido;
import com.fastfoodordering.webapp.pago.Pago;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EstadoPedido estado;

    private CalificacionPedido calificacion;

    private String comentarios;

    private Double montoTotal;

    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> items;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;
}