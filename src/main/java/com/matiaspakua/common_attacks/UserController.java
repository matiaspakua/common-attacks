package com.matiaspakua.common_attacks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/dashboard")
    public String userDashboard(){
        return "Ingreso exitoso por API segura.";
    }
}
