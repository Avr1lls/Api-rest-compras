package com.narvasoft.apirest.repository;

import com.narvasoft.apirest.models.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {
}
