package edu.jwt_auth_mark_1.domain.user;

import javax.management.relation.Role;

public record RegisterDTO(String username, String password, Role role)
{
}
