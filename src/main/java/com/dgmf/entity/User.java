package com.dgmf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "tbl_users")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean isActive;
    // "EAGER" ==> Whenever We load User, We load Related Roles Also
    // "ALL" ==> Whenever We Perform Any Action on User (Parent), It's Also
    // Applicable on Related Roles (Children)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // To Create the Joined Table
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            )

    )
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
            new SimpleGrantedAuthority(
                    roles
                            .stream()
                            .map(role -> "Role_" + role.getRoleType())
                            .collect(Collectors.toList())
                            .toString()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
