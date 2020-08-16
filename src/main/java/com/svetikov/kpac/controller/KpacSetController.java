package com.svetikov.kpac.controller;

import com.svetikov.kpac.dto.KpacSetDTO;
import com.svetikov.kpac.dto.KpacSetKpacDTO;
import com.svetikov.kpac.model.Kpac;
import com.svetikov.kpac.model.KpacSet;
import com.svetikov.kpac.model.KpacSetKpac;
import com.svetikov.kpac.service.KpacService;
import com.svetikov.kpac.service.KpacSetKpacService;
import com.svetikov.kpac.service.KpacSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/sets")
public class KpacSetController {


    @Autowired
    private KpacSetService kpacSetService;

    @Autowired
    private KpacService kpacService;

    @Autowired
    private KpacSetKpacService kpacSetKpacService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String kpacSets(Model model) {
        List<KpacSet> kpacSets = kpacSetService.getAll();
        List<Kpac> kpacs = kpacService.getAll();
        model.addAttribute("kpacSets", kpacSets);
        model.addAttribute("kpacs", kpacs);
        if (!model.containsAttribute("kpacSet")) {
            model.addAttribute("kpacSet", new KpacSetDTO());
        }
        return "kpacSet";
    }

    @RequestMapping(value = "/set/{id}", method = RequestMethod.GET)
    public String kpacsBySetId(@PathVariable(name = "id") Integer id, Model model) {

        KpacSetDTO kpacSet = kpacSetService.getByIdDTO(id);
        List<Kpac> setKpacs = kpacService.getAllBySetId(id);
        List<Kpac> kpacs = kpacService.getAll();
        List<KpacSetKpac> kpacSetKpacs = kpacSetKpacService.getAllBySetId(id);

        model.addAttribute("kpacs", kpacs);
        model.addAttribute("setKpacs", setKpacs);
        model.addAttribute("kpacSet", kpacSet);
        model.addAttribute("kpacSetKpac", new KpacSetKpacDTO());
        model.addAttribute("kpacSetKpacs", kpacSetKpacs);

        return "setKpacs";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addKpacSet(
            @Valid @ModelAttribute(name = "kpacSet") KpacSetDTO kpacSet,
            BindingResult bindingResults,
            RedirectAttributes attr) {

        if (bindingResults.hasErrors()) {
            attr.getFlashAttributes().clear();
            attr.addFlashAttribute("org.springframework.validation.BindingResult.kpacSet", bindingResults);
            attr.addFlashAttribute("kpacSet", kpacSet);
            attr.addFlashAttribute("message", "Validation fails!");
            return "redirect:/sets";
        }
        kpacSetService.save(kpacSet);
        return "redirect:/sets";
    }

    @RequestMapping(value = "/kpac", method = RequestMethod.POST)
    public String addKpac(@ModelAttribute(name = "kpacSetKpac") KpacSetKpacDTO kpacsetKpac) {
        Integer kpacSetId = kpacsetKpac.getKpacSetId();
        kpacSetKpacService.save(kpacsetKpac);
        return "redirect:/sets/set/" + kpacSetId ;
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteKpacSet(@PathVariable(name = "id") Integer id) {
        kpacSetService.deleteById(id);
        return "redirect:/sets";
    }

    @RequestMapping(value = "/set/{setId}/row/{rowId}/delete", method = RequestMethod.GET)
    public String delete(
            @PathVariable(name = "setId")Integer setId,
            @PathVariable(name = "rowId")Integer rowId) {
        kpacSetKpacService.delete(rowId);
        return "redirect:/sets/set/" + setId;
    }

}
