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

    public ResponseEntity<TarefaEntities> buscar (@PathVariable Long id) {
        return tarefaServices.buscarTarefas(id)
        .map(ResponseEntity::ok)  // Se encontrado, retorna 200 OK
		            .orElseGet(() -> ResponseEntity.notFound().build());  // Se não encontrado, retorna 404 Not Found
    }

    @PutMapping ("/{id}")
	
	public ResponseEntity<TarefaEntities> atualizar (@PathVariable Long id, @RequestBody TarefaEntities tarefaEntities) {
		return tarefaServices.buscarTarefas(id)
	            .map(existingTarefa -> {
	                tarefaEntities.setId(id);
	                TarefaEntities tarefaAtualizada = tarefaServices.salvarTarefas(tarefaEntities);
	                return ResponseEntity.ok(tarefaAtualizada);  // Retorna 200 OK com a tarefa atualizada
	            })
	            .orElseGet(() -> ResponseEntity.notFound().build());  // Retorna 404 Not Found se a tarefa não existir
	}
	
	@DeleteMapping ("/{id}")
	 
	public ResponseEntity<Void> deletar (@PathVariable Long id) {
		Optional<TarefaEntities> tarefaExistente = tarefaServices.buscarTarefas(id);
		if (tarefaExistente.isPresent()) {
			tarefaServices.deletarTarefas(id);
			return new ResponseEntity<> (HttpStatus.NO_CONTENT); //se existir a tarefa vai ser excluida e retorna 204
		}
		return new ResponseEntity<> (HttpStatus.NOT_FOUND); // se não existir a tarefa retorna o erro 404
	}
    
}