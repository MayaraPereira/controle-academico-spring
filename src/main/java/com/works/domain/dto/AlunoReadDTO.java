package com.works.domain.dto;

import com.works.domain.model.Aluno;
import com.works.domain.model.Turma;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AlunoReadDTO {

    private final long id;
    private final String nome;
    private final String curso;
    private final String usuario;
    private final String senha;
    private List<Turma> turmas = new ArrayList<>();

    public AlunoReadDTO(long id, String nome, String curso, String usuario, String senha, List<Turma> turmas) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.usuario = usuario;
        this.senha = senha;
        this.turmas = turmas;
    }


}
