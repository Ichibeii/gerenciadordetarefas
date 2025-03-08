package br.com.ichibei.gerenciadordetarefas.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import br.com.ichibei.gerenciadordetarefas.entity.TarefaEntities;
import br.com.ichibei.gerenciadordetarefas.exception.ListaCheiaException;
import br.com.ichibei.gerenciadordetarefas.exception.TarefaexistenteException;
import br.com.ichibei.gerenciadordetarefas.exception.TarefanaoEncontradaException;
import br.com.ichibei.gerenciadordetarefas.repository.TarefaRepositories;

@Service
public class TarefaServices {
    
    
    private final TarefaRepositories tarefaRepositories;

    
    public TarefaServices (TarefaRepositories tarefaRepositories) {
        this.tarefaRepositories = tarefaRepositories;
    }

    public TarefaEntities salvarTarefas(TarefaEntities tarefaEntities) {
        List<TarefaEntities> tarefas = tarefaRepositories.findAll();
    
        if (tarefas.size() >= 30) {
            throw new ListaCheiaException("Atingiu o limite de 30 tarefas.");
        }
    
        // Verifica se já existe uma tarefa com a mesma descrição
        boolean tarefaExistente = tarefas.stream()
            .anyMatch(t -> t.getDescricao().equalsIgnoreCase(tarefaEntities.getDescricao()));
    
        if (tarefaExistente) {
            throw new TarefaexistenteException("A tarefa com essa descrição já existe.");
        }
    
        return tarefaRepositories.save(tarefaEntities);
    }
    

    public List <TarefaEntities> listarTarefas () {
        return tarefaRepositories.findAll();
    }

    public Optional<TarefaEntities> buscarTarefas (Long id) {
        return Optional.ofNullable(tarefaRepositories.findById(id).orElseThrow(() -> new TarefanaoEncontradaException("Tarefa com ID " + id + " não encontrada.")));
    }

    public void deletarTarefas (Long id) {
        tarefaRepositories.deleteById(id);
    }
}
