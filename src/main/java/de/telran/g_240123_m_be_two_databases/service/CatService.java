package de.telran.g_240123_m_be_two_databases.service;

import de.telran.g_240123_m_be_two_databases.domain.entity.cat.Cat;
import de.telran.g_240123_m_be_two_databases.repository.cat.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private CatRepository repository;

    public CatService(CatRepository repository) {
        this.repository = repository;
    }

    public List<Cat> getAll() {
        return repository.getAll();
    }
}