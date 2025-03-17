package com.turismo.app.backend.canonicamodel.app.model.entities;

import com.turismo.app.backend.canonicamodel.app.enums.UserRole;
import com.turismo.app.backend.canonicamodel.app.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "idx_user_documento", columnList = "numero_documento", unique = true),
        @Index(name = "idx_user_tipo_documento", columnList = "tipo_documento_id") // Índice en la relación
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String numeroDocumento;

    private String nombre;

    private String apellido;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.PENDING;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;



    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }


}