package com.works.domain.dto;

import com.works.domain.model.Aluno;
import com.works.domain.model.Turma;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TurmaReadDTO {

    private final long id;
    private final String nome;
    private final String turno;
    private List<Aluno> turmas = new ArrayList<>();


    public TurmaReadDTO(long id, String nome, String turno, List<Aluno> turmas) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.turmas = turmas;
    }


}
