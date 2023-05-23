package com.guilherme.pontoBier.repositorie;

import com.guilherme.pontoBier.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogador, Long> {
}
