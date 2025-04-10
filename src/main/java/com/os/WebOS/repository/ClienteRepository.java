package com.os.WebOS.repository;

import com.os.WebOS.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByCpfCnpj(String cpfCnpj);
}
