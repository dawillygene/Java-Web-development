package com.dawilly.SpringCrud.repository;

import com.dawilly.SpringCrud.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Long> {

}
