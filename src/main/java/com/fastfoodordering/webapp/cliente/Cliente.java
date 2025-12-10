package com.fastfoodordering.webapp.cliente;

import com.fastfoodordering.webapp.carritocompra.CarritoCompra;
import com.fastfoodordering.webapp.direccion.Direccion;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correoElectronico;

    // TODO: buscar forma de encriptar en DB
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "carrito_compra_id")
    private CarritoCompra carritoCompra;

    @OneToOne
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
}
