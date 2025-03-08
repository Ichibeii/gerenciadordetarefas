# 📝 Gerenciador de Tarefas - Spring Boot  

Um sistema simples de **gerenciamento de tarefas** desenvolvido com **Spring Boot**. Ele permite criar, listar, atualizar e excluir tarefas, além de tratar exceções e fazer busca por id.

## 🚀 Tecnologias Utilizadas  

- **Java 17**  
- **Spring Boot** (Spring Web, Spring Data JPA)  
- **Banco de Dados H2** (Em memória)   
- **Postman** (Testes da API)

## 📌 Funcionalidades  

✅ Criar uma nova tarefa  
✅ Listar todas as tarefas  
✅ Buscar uma tarefa por ID  
✅ Atualizar uma tarefa existente  
✅ Deletar uma tarefa  
✅ Tratamento de exceções personalizado  

## 📂 Estrutura do Projeto  

```
📦gerenciador-de-tarefas:

├── 📁 src/main/java/br/com/ichibei/gerenciadordetarefas │ 
├── 📁 controller # Controladores REST │ 
├── 📁 entity # Entidades do banco │ 
├── 📁 exception # Classes de tratamento de erro │ 
├── 📁 infra # ExceçãoGlobal │
├── 📁 repository # Repositórios JPA │ 
├── 📁 service # Lógica de negócios │ 
├── GerenciadorDeTarefasApplication.java # Classe principal 
├── 📁 src/main/resources │ 
├── application.properties # Configuração do banco H2 
├── 📁 src/test/java # Testes automatizados 
├── README.md # Documentação └── pom.xml # Dependências Maven

```

## 🔄 Endpoints da API

| Método  | Endpoint       | Descrição                     |
|---------|--------------|--------------------------------|
| **POST**   | `/tarefas`      | Criar uma nova tarefa        |
| **GET**    | `/tarefas`      | Listar todas as tarefas      |
| **GET**    | `/tarefas/{id}` | Buscar uma tarefa pelo ID    |
| **PUT**    | `/tarefas/{id}` | Atualizar uma tarefa        |
| **DELETE** | `/tarefas/{id}` | Deletar uma tarefa          |

---

## ⚠️ Tratamento de Exceções

| Exceção                      | Resposta                                    |
|------------------------------|---------------------------------------------|
| `ListaCheiaException`        | **400 Bad Request** - Atingiu o limite de 30 tarefas. |
| `TarefaexistenteException`   | **400 Bad Request** - A tarefa com essa descrição já existe. |
| `TarefanaoEncontradaException` | **404 Not Found** - Tarefa não encontrada. |