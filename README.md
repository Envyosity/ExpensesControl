UNIVERSIDADE DO VALE DO TAQUARI - UNIVATES
TÉCNICAS E PRÁTICAS DE PROGRAMAÇÃO (2023/B)
Prof. Mouriac Halen Diemer

TRABALHO FINAL
Desenvolver um sistema para controlar as despesas de uma família. 
1) O sistema deve ter um cadastro de categorias de despesas, portanto o nome das categorias é configurado pelo usuário (refeições, lazer, educação, moradia, vestuário, … ). Deve ser possível realizar todas as operações CRUD (Create, Read, Update e Delete) sobre os registros deste cadastro.
2) O sistema deve ter um cadastro de membros da família, pois cada despesa será associada a uma categoria e a um membro da família (quem realizou o gasto). Deve ser possível realizar todas as operações CRUD (Create, Read, Update e Delete) sobre os registros deste cadastro.
3) O sistema deve ter uma funcionalidade central que é justamente registrar as despesas. Cada despesa tem uma data de ocorrência, pertence a uma categoria (refeições, lazer, educação, moradia, vestuário, … ), tem a indicação de quem foi a pessoa da família que realizou o gasto e, obviamente, qual foi a despesa (uma descrição textual) e o valor que foi gasto. Deve ser possível realizar todas as operações CRUD (Create, Read, Update e Delete) sobre os registros de despesas.
4) A parte mais importante do sistema são as telas de consulta, afinal o sistema foi criado justamente para gerar informações sobre as despesas. Então crie quantas telas ou relatórios ou formas de obter as informações do jeito que você julgar ser mais adequado. No mínimo deve ser possível saber: a) quanto a família inteira gastou em determinado período; b) quanto um membro da família gastou num determinado período; c) quanto a família inteira gastou em uma categoria em um certo período; d) quanto um membro da família gastou em uma categoria em um certo período. Seja criativo para gerar a(s) tela(s) de consulta.

Especificação genérica das relações do banco de dados. Os tipos de dados devem ser adaptados aos tipos usados no sistema gerenciador do banco de dados que você utilizar para implementar o sistema (Postgres, MySQL ou SQLite).
pessoa ( integer id_pessoa, string nome_pessoa )
categoria ( integer id_categoria, string nome_categoria )
despesa ( integer id_despesa, date data, integer id_categoria, integer id_pessoa, string descricao, double valor)


CRITÉRIOS DE AVALIAÇÃO
1) cadastro de categorias de despesas com todas as funcionalidades - 10 pontos
2) cadastro de pessoas da família com todas as funcionalidades - 10 pontos
3) função central para registrar as despesas com todas as funcionalidades - 15 pontos
4) técnicas utilizadas para implementação da solução - 15 pontos

Técnicas obrigatórias (sem isto, estes 15 pontos não serão computados, com isso você também não conquista os 15 pontos):
implementação em 3 camadas, 
utilização do padrão DAO, 
utilização de interface gráfica para as telas 
salvar em banco de dados utilizando instruções SQL
Técnicas recomendadas para conquistar estes 3 pontos: 
utilização da interface IDAO, 
utilização do padrão Factory para criar os DAOs, 
utilização do padrão Singleton para criar um ambiente para o sistema, 
utilização da classe de gerenciamento de acesso ao banco de dados, 
criatividade e beleza da interface gráfica, 
utilização de JTable para exibir as consultas, 
utilização de componentes gráficos criados pelo usuário para campos com restrições ou formatações específicas, 
utilização da biblioteca Ogiva como uma das dependências do sistema, 
utilização de exceptions.

