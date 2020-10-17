package com.works.domain.model;//package com.works.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.works.domain.repository.AlunoRepository;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;


@Entity
@Getter
@Setter
@Table(name="turma", uniqueConstraints = {})
public class Turma implements Serializable {

    private static final long serialVersionUID = 1081869386060246794L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String turno;

    @ManyToMany(mappedBy="turmas", cascade = CascadeType.ALL)
    private List<Aluno> alunosMatriculados = new ArrayList<>();
    
    public Turma(){}

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="aluno_has_turma",
            joinColumns=
            @JoinColumn(name="id", referencedColumnName="turma_id"),
            inverseJoinColumns=
            @JoinColumn(name="id", referencedColumnName="aluno_id")
    )
    public List<Aluno> getalunosMatriculados() { //retorna todos os alunos da turma
        return alunosMatriculados;
    }

    public Aluno getAlunoDaTurma(int id) { //retorna apenas 1 aluno especifico da turma
        return alunosMatriculados.get(id);
    }

    public void realizaMatricula(Aluno aluno){
        alunosMatriculados.add(aluno);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma cliente = (Turma) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
