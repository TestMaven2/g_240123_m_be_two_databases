package de.telran.g_240123_m_be_two_databases.controller;

import de.telran.g_240123_m_be_two_databases.domain.entity.cat.Cat;
import de.telran.g_240123_m_be_two_databases.service.CatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cat> getAll() {
        return service.getAll();
    }
}