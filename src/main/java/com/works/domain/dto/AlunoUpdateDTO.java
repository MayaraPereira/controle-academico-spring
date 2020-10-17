package com.works.domain.dto;

import com.works.domain.model.Aluno;
import com.works.domain.model.Turma;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AlunoUpdateDTO {
    private long id;
    private String nome;
    private String curso;
    private String usuario;
    private String senha;
    private List<Turma> turmas = new ArrayList<>();
    private Aluno aluno;

}
