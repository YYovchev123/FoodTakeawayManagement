package com.example.FoodTakeawayManagement.model.user;

import com.example.FoodTakeawayManagement.model.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surName;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column(unique = true)
    private String phone;

    @NotNull
    private String password;

    @NotNull
    @CreationTimestamp
    private Instant created;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private Set<Order> orders;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<com.example.FoodTakeawayManagement.model.user.Role> roles;
}
