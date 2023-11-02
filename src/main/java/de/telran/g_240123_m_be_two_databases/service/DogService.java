package de.telran.g_240123_m_be_two_databases.service;

import de.telran.g_240123_m_be_two_databases.domain.entity.dog.Dog;
import de.telran.g_240123_m_be_two_databases.repository.dog.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private DogRepository repository;

    public DogService(DogRepository repository) {
        this.repository = repository;
    }

    public List<Dog> getAll() {
        return repository.getAll();
    }
}