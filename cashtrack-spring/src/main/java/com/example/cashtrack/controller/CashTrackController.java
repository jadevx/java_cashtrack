package com.example.cashtrack.controller;

import com.example.cashtrack.model.CashTrack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CashTrackController {

    // Usamos una instancia en memoria para simplicidad.
    private CashTrack cashTrack = new CashTrack();

    // Método GET para mostrar la página principal
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cashTrack", cashTrack);
        return "index"; // Se busca la vista index.jsp
    }

    // Método POST para procesar el formulario
    @PostMapping("/process")
    public String process(@RequestParam("valor") double valor,
                          @RequestParam("tipo") String tipo) {
        if ("ingreso".equals(tipo)) {
            cashTrack.addIngreso(valor);
        } else if ("gasto".equals(tipo)) {
            cashTrack.addGasto(valor);
        }
        // Redirigir a la página principal para mostrar los resultados actualizados
        return "redirect:/";
    }
}
