package com.example.FoodTakeawayManagement.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "role", unique = true)
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private Set<User> users;
}
