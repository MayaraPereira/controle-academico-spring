package com.works.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegistroMatricula {


    private long idAluno;
    private long idTurma;

    @OneToMany(mappedBy = "aluno")
    private List<Turma> turmas = new ArrayList<>();
}
