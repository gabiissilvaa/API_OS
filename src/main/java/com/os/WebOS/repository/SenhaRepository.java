package com.os.WebOS.repository;

import com.os.WebOS.model.SenhaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SenhaRepository extends JpaRepository<SenhaModel, Long> {
    Optional<SenhaModel> findByCpfCnpj(String cpfCnpj);
    Optional<SenhaModel> findByCpfCnpjAndSenhaAcessoOsWeb(String cpfCnpj,String senha);
}
