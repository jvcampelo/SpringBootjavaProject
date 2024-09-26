package br.edu.ibmec.backend.projeto.galeria.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ibmec.backend.projeto.galeria.model.Fabricante;

import br.edu.ibmec.backend.projeto.galeria.repository.FabricanteRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping
    public String listarFabricantes(Model modelo) {
        modelo.addAttribute("fabricantes", fabricanteRepository.findAll());
        return "fabricantes/listaFabricante";
    }

    @GetMapping("/novo")
    public String NovoFabricante(Model modelo) {
        modelo.addAttribute("fabricante", new Fabricante());
        return "fabricantes/formFabricantes";
    }

    @PostMapping("/salvar")
    public String salvarFabricante(@Valid @ModelAttribute Fabricante fabricante, BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            return "fabricante/formFabricantes";
        }
        fabricanteRepository.save(fabricante);
        return "redirect:/fabricantes";
    }

    @GetMapping("/editar/{id}")
    public String EditarFabricante(@PathVariable("id") Integer id, Model modelo) {
        Fabricante fabricante = fabricanteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de fabricante inválido: " + id));
        modelo.addAttribute("fabricante", fabricante);
        return "fabricantes/formFabricantes";
}

    @GetMapping("/excluir/{id}")
    public String excluirFabricante(@PathVariable("id") Integer id) {
        fabricanteRepository.deleteById(id);
        return "redirect:/fabricantes";
}
}




