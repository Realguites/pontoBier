package com.guilherme.pontoBier.repositorie;

import com.guilherme.pontoBier.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
