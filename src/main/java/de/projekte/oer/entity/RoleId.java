package de.projekte.oer.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class RoleId implements Serializable {

    private String userId;
    private String role;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RoleId roleId)) return false;
        return Objects.equals(userId, roleId.userId) &&
                Objects.equals(role, roleId.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, role);
    }
}
