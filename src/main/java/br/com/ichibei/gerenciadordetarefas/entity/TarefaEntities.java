package br.com.ichibei.gerenciadordetarefas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tarefas")
public class TarefaEntities {
    
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Boolean concluido;

    public TarefaEntities () {

    }

    public TarefaEntities (Long id, String descricao, Boolean concluido) {
        this.id = id;
        this.descricao = descricao;
        this.concluido = concluido;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    } 
}
