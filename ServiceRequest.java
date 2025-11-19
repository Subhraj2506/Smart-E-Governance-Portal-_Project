package com.egov.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
@Data
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    private String type;

    @NotBlank
    private String description;

    private String location;

    @Enumerated(EnumType.STRING)
    private RequestStatus status = RequestStatus.PENDING;

    private LocalDateTime createdDate = LocalDateTime.now();
}

enum RequestStatus {
    PENDING,
    APPROVED,
    REJECTED
}
