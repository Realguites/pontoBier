package com.example.pontoBier.pontoBier.repositorie;

import com.example.pontoBier.pontoBier.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogador, Long> {
}