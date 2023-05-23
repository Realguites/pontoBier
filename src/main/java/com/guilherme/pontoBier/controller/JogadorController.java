package com.guilherme.pontoBier.controller;

import com.guilherme.pontoBier.model.Jogador;
import com.guilherme.pontoBier.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorService jogadorService;
    @GetMapping
    public List<Jogador> getAllJogadors() {
        jogadorService.processaImagem();
        return jogadorService.getAllJogadores();
    }

    @PostMapping
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador jogador) {
        Jogador createdJogador = jogadorService.createNew(jogador);
        return new ResponseEntity<>(createdJogador, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable Long id) {
        Optional<Jogador> jogador = jogadorService.findById(id);
        if (jogador != null) {
            return ResponseEntity.ok(jogador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
