package com.narvasoft.apirest.service;

import com.narvasoft.apirest.models.Compras;
import com.narvasoft.apirest.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    private ComprasRepository userRepository;//inyección de dependencias

    @Transactional(readOnly = true)
    public Iterable<Compras> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Compras> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Compras> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public Compras save(Compras user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
