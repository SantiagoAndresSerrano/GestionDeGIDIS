package com.project.gidis.entities;

import com.project.gidis.util.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persona")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique = true, length = 15)
    private String documento;
    @Column(unique = true)
    private String email;
    private String clave;
    private String telefono;
    @Enumerated(value = EnumType.STRING)
    private Rol rol;
    @ManyToMany
    @JoinTable (name = "usuario_articulo", joinColumns = @JoinColumn(name = "articulo_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Articulo> articulo;

    @ManyToMany
    @JoinTable (name = "usuario_libro", joinColumns = @JoinColumn(name = "libro_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Libro> libro;
}
