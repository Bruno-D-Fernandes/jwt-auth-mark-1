package edu.jwt_auth_mark_1.domain.user;

public enum Roles {
    ADMIN("admin"),
    USER("user");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
