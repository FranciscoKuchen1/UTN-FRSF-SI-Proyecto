package com.fastfoodordering.webapp.producto;

import com.fastfoodordering.webapp.imagen.Imagen;
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
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private Double precioUnitario;

    private Integer disponibilidad;

    @OneToMany
    @JoinColumn(name = "producto_id")
    private List<Imagen> imagenes;
}
