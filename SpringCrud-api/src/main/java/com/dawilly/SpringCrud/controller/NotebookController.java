package com.dawilly.SpringCrud.controller;


import com.dawilly.SpringCrud.model.Notebook;
import com.dawilly.SpringCrud.service.NotebookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notebooks")
public class NotebookController {

    private final NotebookService service;

    public NotebookController(NotebookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notebook> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notebook> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Notebook create(@RequestBody Notebook notebook) {
        return service.create(notebook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notebook> update(@PathVariable Long id, @RequestBody Notebook notebook) {
        return ResponseEntity.ok(service.update(id, notebook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
