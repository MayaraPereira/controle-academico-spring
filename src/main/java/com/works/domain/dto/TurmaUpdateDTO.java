package com.works.domain.dto;

import com.works.domain.model.Aluno;
import com.works.domain.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TurmaUpdateDTO {
    private long id;
    private String nome;
    private String turno;
    private Aluno aluno;
    private List<Aluno> turmas = new ArrayList<>();

    protected TurmaUpdateDTO() { }
}
