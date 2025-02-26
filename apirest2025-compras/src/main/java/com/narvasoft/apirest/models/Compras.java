package com.narvasoft.apirest.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "compras")
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "serie")
    private Long serie;

    @Column(name = "compra")
    private String compra;

    @Column(name = "tamano")
    private String tamano;

    @Column(name = "categoria", nullable = false, length = 50, unique = true)
    private String categoria;

    @Column(name = "disponibilidad")
    private String disponibilidad;

    //@Column(name = "foto")
    //private String foto;
}
