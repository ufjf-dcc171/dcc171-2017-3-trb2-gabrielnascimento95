
Nome: Gabriel dos Santos Nascimento 

Matrícula: 201376133

Curso: Sistemas de Informação

________________________________________________________________________________________________________________________________________
Cenário
O trabalho proposto visa criar um sistema gerencial para restaurante em java, neste cenário o usuário seja ele um funcionário ou dono do estabbelecimento consegue ter acesso ao historico geral de vendas que dá o total acumulado no dia bem como a hora de cada atualização de caixa. Durante a execução do programa, é carregada uma lista de pedidos, cardápio e lista de mesas disponiveis. Por meio de uma interface, o usuário tem a opção de selecionar em uma lista a mesa, o item do cardápio e adicionar o pedido. Também existe a possilibidade de excluir um pedido caso exista a desistência do mesmo ou até mesmo fechar uma mesa ao término dos serviços de uma determinada mesa. Também é possível alterar a quantidade de itens pedidos, alterando assim o total do pedido.
________________________________________________________________________________________________________________________________________
Modelo de dados utlizados
Foi utilizado ListModels para realizar ações que envolviam as classes histórico, pedido, mesa, cardapio.
Para exibição dos dados foi utilizado JScrollPane que tinha como função pegar os dados do JList criado a partir do ListModel e os exibir em tela além de ficar responsável por capturar  o objeto selecionado pelo usuário. Tal ação se repete quando o usuário manipula objetivos ArrayList das classes cardápio, mesa e pedidos. Toda movimentação de dados utiliza ListModels.
________________________________________________________________________________________________________________________________________
Protocolo de Persistência Utilizado
Para carregamento e gravação de dados, foi utilizado arquivos txt com demarcação de dados por "," sendo que cada dado é carregado e devidamente adicionado em cada objeto dentro do arrayList que é responsável pela guarda do mesmo. Arquivos são gravados na pasta raiz do projeto.
________________________________________________________________________________________________________________________________________
Campos necessário para construção de tela
Para construção da tela foi utilizado JPane, JScrollPane, JTextField, JLabel. Para manipular a disposição de objetos na tela foi utilizado GridLayout e BorderLayout em determinados lugares da tela.
________________________________________________________________________________________________________________________________________
Pontos importantes do funcionamento da interface
A interface trabalha de uma maneira simples com o usuário, ou seja, a mesma traz uma lista com barra de rolagem para escolha de dados, traz campos que se auto preenchem quando o usuário seleciona algum objeto em alguma lista, ou seja, durante a execução do programa o usuário manipula pouco dados e fica mais com a responsabilidade de manipular ações que se fazem necessárias durante a execução 
________________________________________________________________________________________________________________________________________
Pontos mais mais difíceis de implementar
Ponto mais dificil de implementar foi a regra de negócio básica de todo restaurante, ou seja, em cada pedido existe mais de um item, cada item compõe um valor e uma quantidade. Criar a mecânica em si do programa foi um ponto mais dífícil visto que a manipulação de objetos dentro de listModels se basea na busca do mesmo e na comparação com o objeto escolhido do usuário.
________________________________________________________________________________________________________________________________________
Melhorias futuras
Trabalhar mais a questão de edição de mesas e cardápio, ou seja, poder deixar uma mesa ativa ou inativa, um item do cardápio ativo ou inativo, poder implementar a questão de quantidade de um determinado item do cardápio, por exemplo, se a quantidade de coca-cola estiver 0, o item automaticamente fica inativo no cardápio. Poder trabalhar melhor a exclusão de pedidos, retirando o valor e o item do arquivo texto final. 



