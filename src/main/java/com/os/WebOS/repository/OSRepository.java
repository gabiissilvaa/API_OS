package com.os.WebOS.repository;

import com.os.WebOS.model.OSModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OSRepository extends JpaRepository<OSModel, Long> {
    List<OSModel> findByClienteId(Long clienteId);
}
