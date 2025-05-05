package com.dawilly.SpringCrud.service;

import com.dawilly.SpringCrud.model.Notebook;
import com.dawilly.SpringCrud.repository.NotebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NotebookService {

    private final NotebookRepository repository;

    public NotebookService(NotebookRepository repository) {
        this.repository = repository;
    }

    public List<Notebook> getAll() {
        return repository.findAll();
    }

    public Optional<Notebook> getById(Long id) {
        return repository.findById(id);
    }

    public Notebook create(Notebook notebook) {
        return repository.save(notebook);
    }

    public Notebook update(Long id, Notebook updatedNotebook) {
        return repository.findById(id).map(notebook -> {
            notebook.setTitle(updatedNotebook.getTitle());
            notebook.setContent(updatedNotebook.getContent());
            return repository.save(notebook);
        }).orElseThrow(() -> new RuntimeException("Notebook not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }




}
