package br.com.ichibei.gerenciadordetarefas.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.ichibei.gerenciadordetarefas.exception.ListaCheiaException;
import br.com.ichibei.gerenciadordetarefas.exception.TarefaexistenteException;
import br.com.ichibei.gerenciadordetarefas.exception.TarefanaoEncontradaException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
 @ExceptionHandler (ListaCheiaException.class)
 
    public ResponseEntity<String> handleListaCheiaException (ListaCheiaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

 @ExceptionHandler (TarefaexistenteException.class)

    public ResponseEntity<String> handleTarefaExistenteException (TarefaexistenteException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

 @ExceptionHandler (TarefanaoEncontradaException.class)

    public ResponseEntity<String> handleTarefanaoEncontradaException (TarefanaoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
