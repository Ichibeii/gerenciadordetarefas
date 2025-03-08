package br.com.ichibei.gerenciadordetarefas.controller;

import java.util.List;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ichibei.gerenciadordetarefas.entity.TarefaEntities;
import br.com.ichibei.gerenciadordetarefas.service.TarefaServices;

@RestController
@RequestMapping ("/tarefas")
public class TarefaControllers {

    
    private final TarefaServices tarefaServices;

	
	public TarefaControllers (TarefaServices tarefaServices) {
		this.tarefaServices = tarefaServices;
	}

    @PostMapping

    public ResponseEntity <TarefaEntities> create (@RequestBody TarefaEntities tarefaEntities) {
        TarefaEntities tarefanova = tarefaServices.salvarTarefas(tarefaEntities);
        return new ResponseEntity <> (tarefanova, HttpStatus.CREATED);
    }

    @GetMapping

    public ResponseEntity<List<TarefaEntities>> listar () {
        List<TarefaEntities> tarefas = tarefaServices.listarTarefas();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @GetMapping ("/{id}")

    public ResponseEntity<Optional<TarefaEntities>> buscar(@PathVariable Long id) {
		Optional<TarefaEntities> tarefa = tarefaServices.buscarTarefas(id);
		return ResponseEntity.ok(tarefa); 
    }

    @PutMapping ("/{id}")
	
	
	public ResponseEntity<TarefaEntities> atualizar(@PathVariable Long id, @RequestBody TarefaEntities tarefaEntities) {
    	Optional<TarefaEntities> existingTarefa = tarefaServices.buscarTarefas(id); // Se não existir, já lança exceção
    	tarefaEntities.setId(id);
    	TarefaEntities tarefaAtualizada = tarefaServices.salvarTarefas(tarefaEntities);
    	return ResponseEntity.ok(tarefaAtualizada);
}

	
	@DeleteMapping ("/{id}")
	 
	
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
    	tarefaServices.buscarTarefas(id); // Se não encontrar, já lança exceção
    	tarefaServices.deletarTarefas(id);
    	return ResponseEntity.noContent().build();
}

    
}