package com.mutualser.controller;

import com.mutualser.model.Usuario;

public interface AuthController {
    public Usuario login(long numId, String password, int rol);
}
