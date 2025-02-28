package de.projekte.oer.entity;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="members")
public class Member {

    // The user ID is the primary key
    @Id
    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "pw", nullable = false, length = 68)
    private String pw;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();


}
