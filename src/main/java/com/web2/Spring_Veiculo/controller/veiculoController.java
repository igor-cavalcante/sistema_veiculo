package com.web2.Spring_Veiculo.controller;

import com.web2.Spring_Veiculo.model.entity.Veiculo;
import com.web2.Spring_Veiculo.model.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller()
@RequestMapping("/veiculo")
public class veiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping("/lista")
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("veiculos", repository.getAllVeiculos());
        return new ModelAndView("list", model);
    }

    // Mostrar formulário de cadastro
    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "form";
    }

    // Salvar veículo (cria ou atualiza)
    @PostMapping("/salvar")
    public String salvarRepository(@ModelAttribute("veiculo") Veiculo veiculo) {
        repository.salvar(veiculo);
        return "redirect:/veiculo/lista";
    }

    // Mostrar formulário de edição
    @GetMapping("/editar/{id}")
    public String editarRepository(@PathVariable("id") Long id, Model model) {
        Veiculo veiculo = repository.getVeiculo(id);
        model.addAttribute("veiculo", veiculo);
        return "form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        // 1. Chama o repositório para excluir
        repository.excluir(id);

        // 2. Redireciona para a lista atualizada
        return "redirect:/veiculo/lista";
    }

}
