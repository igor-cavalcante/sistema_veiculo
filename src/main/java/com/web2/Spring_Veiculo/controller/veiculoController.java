package com.web2.Spring_Veiculo.controller;

import com.web2.Spring_Veiculo.model.dao.ErrorDao;
import com.web2.Spring_Veiculo.model.dao.VeiculoDaoClasse;
import com.web2.Spring_Veiculo.model.entity.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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


    // Exibir form para cadastro
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "form";
    }

    // Exibir form para edição
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        try {
            VeiculoDaoClasse dao = new VeiculoDaoClasse();
            Veiculo veiculo = dao.getVeiculo(id);
            dao.sair();
            model.addAttribute("veiculo", veiculo);
            return "form";
        } catch (ErrorDao e) {
            throw new RuntimeException(e);
        }
    }

    // Salvar (cadastrar ou atualizar)
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("veiculo") Veiculo veiculo) {
        try {
            VeiculoDaoClasse dao = new VeiculoDaoClasse();
            if (veiculo.getId() == null) {
                dao.insertVeiculo(veiculo);
            } else {
                dao.updateVeiculo(veiculo);
            }
            dao.sair();
        } catch (ErrorDao e) {
            throw new RuntimeException(e);
        }
        return "redirect:/veiculo/lista";
    }


    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        try {
            VeiculoDaoClasse dao = new VeiculoDaoClasse();
            dao.deleteById(id);
            dao.sair();
        } catch (ErrorDao e) {
            throw new RuntimeException(e);
        }
        return "redirect:/veiculo/lista";
    }


}
