package com.turismo.app.backend.canonicamodel.app.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "whatsapp_logs", indexes = {
        @Index(name = "idx_whatsapp_user", columnList = "user_id"),
        @Index(name = "idx_whatsapp_info_request", columnList = "info_request_id")
})
public class WhatsAppLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user; // Puede ser nulo si es un usuario no registrado

    @ManyToOne
    @JoinColumn(name = "info_request_id", nullable = true)
    private InformationRequest informationRequest; // Relación con solicitudes de información

    @Column(nullable = false, length = 500)
    private String mensaje;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    @PrePersist
    protected void onCreate() {
        fechaEnvio = LocalDateTime.now();
    }
}
