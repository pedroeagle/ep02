# Exercício Programado 2

## Introdução

No mundo de Pokémon, existem criaturas chamadas Pokémons. Estas criaturas possuem
diversas caracterísiticas e atributos.

Os Pokémons se organizam em tipos, e podem ser capturados por treinadores.

Neste Exercício Programado, você irá criar a sua Pokédex, uma aplicação para
visualizar informações dos Pokémons que cada treinador possui.

## Objetivo

Construir uma Pokédex simples. Onde os treinadores possam se cadastrar,
e cadastrar os seus Pokémons. E possam ver as características destes Pokémons.

## Critérios de Aceitação

* Realizar, quando necessário, requisição para API externa utilizada no EP através de métodos HTTP;

* Listar atributos e habilidades do Pokémon após o nome deste ser informado;

* Listar os nomes de todos os Pokémons de um determinado tipo;

* Permitir o cadastro de um treinador;

* Permitir a associação de um Pokémon a um treinador. E a visualização dos Pokémons que um treinador possui;


### Critérios de funcionalidades da Pokédex

* Implementar funcionalidades da Pokédex;
    * Pesquisar Pokémons pelo nome;
    * Pesquisar Pokémons pelo tipo;
    * Cadastrar um treinador;
    * Selecionar um treinador e atribuir os Pokémons que este possui;
    * Visualizar os Pokémons de um treinador.

### Critérios de implementação

* Implementar interface gráfica para a Pokédex, utilizando Java Swing. Todas as
funcionalidades devem poder ser realizadas através da interface.

* A API externa que será consumida na realização do projeto se encontra neste [link](https://pokeapi.co/api/v2/).

* Para implementação do EP, fica a cargo do aluno selecionar a IDE de sua preferência (Android Studio, Eclipse, NetBeans).

### Pontuação extra

* Será acrescido de pontuação extra o projeto que possuir, em seu conteúdo, testes unitários (valores a serem definidos).


## Critérios de Avaliação

A avaliação será realizada seguindo os seguintes critérios:

| ITEM | COMENTÁRIO | VALOR |
|----|----------|:-----:|
| **Consumo da API**     |     O código deve consumir a API fornecida e extrair as informações necessárias     |  1.5     |
| **Cadastrar um treinador**     | Deve ser possível cadastrar treinadores na Pokedex   |   1.0   |
| **Buscar Pokemon**     |    Deve ser possível buscar um Pokemon pelo seu **nome**, ou pelo seu **tipo**. Após a busca devem ser exibidos os atributos do Pokemon   |   1.5    |
| **Visualizar os Pokemons de um treinador**| Após os cadastros dos treinadores e seus Pokemons deve ser possível vizualizar a lista dos Pokemons de um treinador | 1.0 |
| **Modelagem** | Referente a organização e relacionamento entre classes | 1.5 |
| **Polimorfismo** |  Ao menos uma aplicação de Polimorfismo deve ocorrer corretamente  |    1.0   |
| **Herança** |      Herança entre classes que forem identificadas a necessidade     |   1.0    |
| **Apresentação**     |    A apresentação das informações ao usuário deve ser clara        |    0.5   |
| **Qualidade do Código**   |     O código deve conter bons nomes, ser modularizado, identado e com bom desempenho       |  0.5    |
| **Repositório**   |     Commits frequentes e com mensagens claras, utilização correta do repositório       |    0.5   |

* Os critérios de avaliação podem sofrer alteração de **ITEM**, **COMENTÁRIO** ou **VALOR** para atender as necessidades da turma.
