# API REST DE PARA CRIAÇÃO DE LISTAS DE  MÚSICAS

## Objetivo

Este projeto visa criar uma API RESTful para gerenciar listas e músicas.

## Pré-Requisitos

- Java 17
- Maven versão 3.2.5

## Framework Utilizado

- [Spring Boot](https://spring.io/projects/spring-boot)


## Testes com o Postman

Para testar a API, utilize o [Postman](https://www.postman.com/). Abaixo estão os endpoints disponíveis:

### Lista de Músicas

- **GET /http://localhost:8080/list**: Retorna todas as listas de músicas.
- **GET /http://localhost:8080/list/{name}**: Retorna uma lista específica pelo nome.
- **DELETE /http://localhost:8080/list/{name}**: Deleta uma lista pelo nome.
- **POST /http://localhost:8080/list**: Cria uma nova lista de músicas.

  - Corpo da requisição para inserção de uma lista:
    ```json
    {
      "nome": "string",
      "descricao": "string"
    }
    ```

  - Resposta da requisição de uma lista de músicas:
    ```json
    [
      {
        "id": long,
        "nome": "string",
        "descricao": "string",
        "musicas": [
          {
            "titulo": "string",
            "artista": "string",
            "album": "string",
            "ano": "string",
            "genero": "string"
          }
        ]
      }
    ]
    ```

### Músicas

- **GET /http://localhost:8080/music/{name}**: Retorna uma música específica pelo nome.
- **POST /http://localhost:8080/music**: Adiciona uma nova música.

  - Corpo da requisição para inserção de uma música:
    ```json
    {
      "titulo": "string",
      "artista": "string",
      "album": "string",
      "ano": "string",
      "genero": "string",
      "idList": long
    }
    ```

  - Resposta da requisição de uma música:
    ```json
    {
      "titulo": "string",
      "artista": "string",
      "album": "string",
      "ano": "string",
      "genero": "string"
    }
    ```


              