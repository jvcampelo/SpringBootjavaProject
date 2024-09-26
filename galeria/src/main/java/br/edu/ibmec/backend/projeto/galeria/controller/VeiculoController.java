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


import br.edu.ibmec.backend.projeto.galeria.model.Veiculo;
import br.edu.ibmec.backend.projeto.galeria.repository.FabricanteRepository;
import br.edu.ibmec.backend.projeto.galeria.repository.VeiculoRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @GetMapping
    public String listarVeiculos(Model modelo) {
        modelo.addAttribute("veiculos", veiculoRepository.findAll());
        return "veiculos/listaVeiculos";
}

    @GetMapping("/novo")
    public String NovoVeiculo(Model modelo) {
        modelo.addAttribute("veiculo", new Veiculo());
        modelo.addAttribute("fabricantes", fabricanteRepository.findAll());
        return "veiculos/formVeiculos";
    }

    @PostMapping("/salvar")
    public String salvarVeiculo(@Valid @ModelAttribute Veiculo veiculo, BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            modelo.addAttribute("fabricantes", fabricanteRepository.findAll());
            return "veiculos/formVeiculos";
        }
        
        veiculoRepository.save(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/editar/{id}")
    public String EditarVeiculo(@PathVariable("id") Integer id, Model modelo) {
        Veiculo veiculo = veiculoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID do veiculo inválido: " + id));
        modelo.addAttribute("veiculo", veiculo);
        modelo.addAttribute("fabricantes", fabricanteRepository.findAll());
        return "veiculos/formVeiculos";
        }

    @GetMapping("/excluir/{id}")
    public String excluirVeiculo(@PathVariable("id") Integer id) {
        veiculoRepository.deleteById(id);
        return "redirect:/veiculos";
        }
    

    
}
