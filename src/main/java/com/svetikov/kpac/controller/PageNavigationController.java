package com.svetikov.kpac.controller;

import com.svetikov.kpac.service.KpacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageNavigationController {

    @RequestMapping(value = {"/", "home", "index"})
    public String home() {
        return "index";
    }

}
