package com.example.Musicapp.service;

import com.example.Musicapp.models.UserRole;

public interface UserRoleService {

    public UserRole createRole(UserRole newRole);

    public UserRole getRole(String roleName);
}