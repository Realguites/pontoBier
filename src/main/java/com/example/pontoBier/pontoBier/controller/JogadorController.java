package com.example.pontoBier.pontoBier.controller;

import com.example.pontoBier.pontoBier.model.Jogador;
import com.example.pontoBier.pontoBier.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public List<Jogador> getAllAlunos() {
        return jogadorService.getAllJogadores();
    }

    @PostMapping
    public ResponseEntity<Jogador> createAluno(@RequestBody Jogador jogador) {
        Jogador createdAluno = jogadorService.createNew(jogador);
        return new ResponseEntity<>(createdAluno, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
