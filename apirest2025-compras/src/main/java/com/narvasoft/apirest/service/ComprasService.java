package com.narvasoft.apirest.service;

import com.narvasoft.apirest.models.Compras;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ComprasService {
    public Iterable <Compras> findAll();
    public Page<Compras> findAll(Pageable pageable);
    public Optional<Compras> findById(Long id);
    public Compras save(Compras usuarios);
    public void deleteById(Long id);
}
