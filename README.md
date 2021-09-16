# Api-de-gestao-de-estoque

<h2>Descrição:</h2>

Este repositório guarda uma API de gerenciamento de estoque de uma loja de jogos feita em java com Spring Boot.

<h2>Endpoints e seus métodos</h2>

## Métodos GET:

```Ruby

Buscar todos os jogos cadastrados:
$ endpoint: http://localhost:8080/Jogos/ViewAllGames

Buscar todos os jogos disponiveis:
$ endpoint: http://localhost:8080/Jogos/ViewAvailableGames

Buscar jogo pelo id:
$ endpoint: http://localhost:8080/Jogos/FindById/id do jogo desejado

```

##  Métodos POST:

```Ruby                          
Cadastrar novo jogo:                   
$ endpoint: http://localhost:8080/Jogos/AddGame
$ body: "nomeDoJogo": "", "quantidadeEstoque": 0, "preco": 0.0,  "descricao": ""

```

## Métodos PATCH:

```Ruby                                 
Atualizar jogo:                   
$ endpoint: http://localhost:8080/Jogos/UpdateById/id do jogo desejado
$ body: "quantidadeEstoque": 0, "preco": 00.00

```

## Métodos DELETE:

```Ruby                                 
Excluir jogo:                   
$ endpoint: http://localhost:8080/Jogos/DeleteById/id do jogo desejado
```

## Especificação:

```python                                 
$ Java: 8
$ Spring Boot: 2.5.4
$ IDE: eclipse 2021-06

```
