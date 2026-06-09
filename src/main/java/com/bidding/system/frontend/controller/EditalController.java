/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.frontend.controller;

import com.bidding.system.frontend.model.EditalDTO;
import com.bidding.system.frontend.service.ApiService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ftana
 */

@Controller
public class EditalController {
    
    @Autowired
    private ApiService restService;
    
    @GetMapping("/editais")
    public String editais(
            Model model,
            HttpSession session,
            @RequestParam(value = "urgente", required = false, defaultValue = "false") boolean urgente
    ){
        String token = (String) session.getAttribute("token");
        if (token == null) return "redirect:/login";
        
        String role = (String) session.getAttribute("role");

        List<EditalDTO> editais = restService.listarEditais(token, urgente);

        model.addAttribute("editais", editais);
        model.addAttribute("urgente", urgente);
        model.addAttribute("role", role);

        return "editais";
    }
    
    
    
    
}
