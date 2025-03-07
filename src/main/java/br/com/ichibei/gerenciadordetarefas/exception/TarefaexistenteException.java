package br.com.ichibei.gerenciadordetarefas.exception;

public class TarefaexistenteException extends RuntimeException {
    
    public TarefaexistenteException (String message) {
        super(message);
    }
}
