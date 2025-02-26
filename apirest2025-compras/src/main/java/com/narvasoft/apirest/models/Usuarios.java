package com.narvasoft.apirest.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Usuarios  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "producto")
    private String producto;

    @Column(name = "precio")
    private String precio;

    @Column(name = "coleccionable", nullable = false, length = 50, unique = true)
    private String coleccionable;

    @Column(name = "fecha")
    private String fecha;

    //@Column(name = "foto")
    //private String foto;
}
