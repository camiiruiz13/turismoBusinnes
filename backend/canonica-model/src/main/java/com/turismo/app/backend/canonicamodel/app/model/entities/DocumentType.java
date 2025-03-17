package com.turismo.app.backend.canonicamodel.app.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document_types", indexes = {
        @Index(name = "idx_document_type_codigo", columnList = "codigo", unique = true)
})
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false, length = 10)
    private String codigo;



}