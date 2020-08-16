package com.svetikov.kpac.controller;

import com.svetikov.kpac.dto.KpacDTO;
import com.svetikov.kpac.model.Kpac;
import com.svetikov.kpac.service.KpacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/kpacs")
public class KpacController {

    @Autowired
    private KpacService kpacService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<KpacDTO> kpacs = kpacService.getAllDTO();
        model.addAttribute("kpacs", kpacs);
        if (!model.containsAttribute("kpac")) {
            model.addAttribute("kpac", new Kpac());
        }
        return "kpac";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(
            @Valid @ModelAttribute(name = "kpac")Kpac kpac,
            BindingResult bindingResults,
            RedirectAttributes attr) {

        if (bindingResults.hasErrors()) {
            attr.getFlashAttributes().clear();
            attr.addFlashAttribute("org.springframework.validation.BindingResult.kpac", bindingResults);
            attr.addFlashAttribute("kpac", kpac);
            attr.addFlashAttribute("message", "Validation fails!");
            return "redirect:/kpacs";
        }

        kpacService.save(kpac);
        return "redirect:/kpacs";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id")Integer id) {
        kpacService.deleteById(id);
        return "redirect:/kpacs";
    }

}
