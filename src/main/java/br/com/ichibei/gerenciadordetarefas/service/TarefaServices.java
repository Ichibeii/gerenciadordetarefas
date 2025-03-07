package br.com.ichibei.gerenciadordetarefas.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import br.com.ichibei.gerenciadordetarefas.entity.TarefaEntities;
import br.com.ichibei.gerenciadordetarefas.repository.TarefaRepositories;

@Service
public class TarefaServices {
    
    
    private final TarefaRepositories tarefaRepositories;

    
    public TarefaServices (TarefaRepositories tarefaRepositories) {
        this.tarefaRepositories = tarefaRepositories;
    }

    public TarefaEntities salvarTarefas (TarefaEntities tarefaEntities) {
        return tarefaRepositories.save(tarefaEntities);
    }

    public List <TarefaEntities> listarTarefas () {
        return tarefaRepositories.findAll();
    }

    public Optional<TarefaEntities> buscarTarefas (Long id) {
        return tarefaRepositories.findById(id);
    }

    public void deletarTarefas (Long id) {
        tarefaRepositories.deleteById(id);
    }
}
