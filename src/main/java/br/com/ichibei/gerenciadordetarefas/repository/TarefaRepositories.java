package br.com.ichibei.gerenciadordetarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ichibei.gerenciadordetarefas.entity.TarefaEntities;

public interface TarefaRepositories extends JpaRepository <TarefaEntities, Long> {
    
}
