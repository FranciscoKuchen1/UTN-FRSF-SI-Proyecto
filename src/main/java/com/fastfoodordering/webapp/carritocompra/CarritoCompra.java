package com.fastfoodordering.webapp.carritocompra;

import com.fastfoodordering.webapp.producto.Producto;
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
@Table(name = "carritoscompra")
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "carritocompra_id")
    private List<Producto> productos;
}