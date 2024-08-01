package com.aslidongez.project.entity;

import com.aslidongez.project.models.Role;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name="users")
public class Users {


    @Id
    @Column(name="user_id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq"
    )
    @SequenceGenerator(  //Otomatik olarak kullanicilara bir id tanımladim.
            name = "user_seq",
            sequenceName = "user_sequence",
            allocationSize = 2, //Artis miktari.
            initialValue = 10001 //Kactan baslayacagi
    )
    private Long userId;
    @Column(name="user_name", nullable = false, unique = true)
    @Size(min = 6, max = 30)
    private String username;

    @Column(name="password", nullable = false)
    @Size(min = 8)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<Role> roles = new ArrayList<>();

}
