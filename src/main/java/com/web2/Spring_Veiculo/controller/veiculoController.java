package com.web2.Spring_Veiculo.controller;

import com.web2.Spring_Veiculo.model.dao.ErrorDao;
import com.web2.Spring_Veiculo.model.dao.VeiculoDaoClasse;
import com.web2.Spring_Veiculo.model.entity.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller()
@RequestMapping("/veiculo")
public class veiculoController {




    @GetMapping("/lista")
    public ModelAndView list(ModelMap model) {
        VeiculoDaoClasse dao = new VeiculoDaoClasse();
        try {
            model.addAttribute("veiculos", dao.getAllVeiculos());
            dao.sair();
        } catch (ErrorDao e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView("list", model);
    }

}
