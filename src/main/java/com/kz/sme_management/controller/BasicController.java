package com.kz.sme_management.controller;

import com.kz.sme_management.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public abstract class BasicController<T extends BasicEntity<ID>, ID> {
    private final JpaRepository<T, ID> repository;
    private final String entityName;

    public BasicController(JpaRepository<T, ID> repository, String entityName) {
        this.repository = repository;
        this.entityName = entityName;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<T> getEntities() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T getEntityById(@PathVariable ID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Invalid " + entityName + " id"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntityById(@PathVariable ID id) {
        repository.deleteById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteEntityById(@RequestBody T entity) {
        repository.save(entity);
    }


}
