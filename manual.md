## Documentação linguagem Orange

![](https://github.com/leobsilva/Orange-lang/blob/main/orange.jpg)

**Orange** é uma linguagem de programação construída em Java de forma similar a mesma, por exemplo os caracteres de operações (+,-,*,/). Atualmente ,com a linguagem 
criada, é possivel declarar variaveis, fazer operações matematicas basicas, imprimir na tela e receber entrada do teclado. Lembrando que para a linguagem funcionar 
corretamente é necessário um espaço entre cada elemento para o correto processamento. *O nome orange se deu pelo simples fato da cor do ceu no dia em que iniciei o 
trabalho estava laranja, como mostrado na foto no inicio do manual.*

**Obs:** Para utilizar a linguagem criada é necessario o uso da sua propria extenção .orange. Ao contrario será apontado um erro de extenção não reconhecida.

#### Características:
* Declaração de variáveis e atribuição de valores;
* Leitura de Impressão de dadosç
* Expressões com no mínimo dois operandos, ex.: a + b;
* Operações:
  * adição: +
  * subtração: -
  * divisão: /
  * multiplicação: *
  * atribuição: =


#### Declaração de variáveis:
Uma variavel, independente do tipo, chama-se **seed**. Para sua implementação correta deve ser feita da ordem *seed*(que representa uma variavel), *nomeDaVariavel*,
podendo ou não seguir uma atribuição *=* e o *valor* que a variavel assumirá. Para o funcionamento correto deve ser usado um espaço entre cada elemento da linha 
mesmo que o valor seja 0.
Exemplos:
seed nomeDaVariavel
seed nomeDaVariavel2 = 42
seed notas
seed qntProvas = 3
seed soma = 276
    
Se uma atribuição for feita usando numeros decimais deverá ser usado o separados "." e não ",".

#### Leitura e Impressão na tela:
Para leitura é usado o comando "in" seguido do valor numero ou de uma string, que deverá estar entre aspas duplas(""). Para imprimir valores e strings é usado o 
comando "out".
Exemplos:

Entradas                         |Saídas
---------------------------------|--------------------------------
out "Qual foi sua nota na prova?"|
in nota                          | (nota digitada pelo usuario)
---------------------------------|--------------------------------
seed nota = 8.7                  | 8.7
out nota                         | 



#### Realizando operações matemáticas
Primeiramente é nescessário atribuir uma variavel para depois atribuir uma operação.  Também é possivel atribuir apenas um valor a uma variavem e depois fazer uma
operação utilizando apenas os nomes: 'seed a = 2 + 5', 'seed b = 5', 'seed c = 23', 'seed resposta = c - b'. Não foi implementada precedencia de sinais com o uso dos
"()", logo ele não é suportado na linguagem Orange. Porem existe a precedencia de sinais seguindo primeiro * ou / e depois + e -.
Exemplos:

Entradas                         |Saídas
---------------------------------|--------------------------------
seed soma = 10 + 15              |
out soma                         | 25.0
---------------------------------|--------------------------------
seed nota1 = 8.7                 | 
seed nota2 = 7.3                 |
seed soma = nota1 + nota2        | 
out soma                         | 16.0 
seed media = soma / 2            |
out media                        | 8.0


  
-----------------------------------------------------------------------------------------------------------------------------
