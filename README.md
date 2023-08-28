# TCC PanasTech - 2023 - api-rest-sgds 🧬🩺
Desenvolvimento de uma API para o TCC de 2023 do grupo `PanasTech` : `SGDS Sistema de Gestão de Saúde`.
- Uma API (Interface de Programação de Aplicativos) serve para permitir que diferentes softwares se comuniquem e compartilhem dados e funcionalidades, facilitando a integração, automação e acesso a serviços externos em aplicativos.
- Motivação do desenvolvimento: integração com sistemas de terceiros, como provedores de serviços médicos, laboratórios, seguradoras de saúde ou aplicativos de monitoramento de saúde. Usar uma API permitiria ao software acessar informações atualizadas e precisas de fontes confiáveis, como resultados de exames médicos, históricos de saúde e dados de tratamentos, sem a necessidade de desenvolver essas funcionalidades internamente. Isso economizaria tempo e recursos, ao mesmo tempo em que garantiria que os dados de saúde sejam manuseados de maneira segura e em conformidade com regulamentações.

# Etapas de desenvolvimento até (01/09/2023) ⚙⏳
- [ x ] Start na produção do projeto para o backend do sitema SGDS(Sistema de Gestão de Saúde) *croos-plataforma*.
- [ x ] API conectar com banco de dados. 
- [ x ] API tratar requisições pelo protocolo HTTP.
- [ x ] Definição de rotas mais elaboradas.
  - [ ! ] Corrigir arquitetura de sistema e nomeclaturas.
- [ x ] API tratar requisições de softwares terceiros.

# Previsão de desenvolvimento até (15/10/2023) ⚙⏳
- [ - ] Desenvolver suporte de segurança com *spring-security*.
- [ - ] Colocar a aplicação em um servidor.


## Alterações feitas 🛠
-> *Adição do Método de Busca por Nome:*

>Foi criado um novo método no controlador UsuarioRest para buscar usuários pelo nome. Utilizando a anotação `@GetMapping` e o parâmetro `@PathVariable`, o método aceita o nome como entrada e retorna uma lista de usuários correspondentes ou um status 404 caso nenhum usuário seja encontrado.

-> *Método para Atualização por CPF:*

>Foi implementado um novo método `alterarUsuarioByCpf` no controlador `UsuarioRest` para atualizar os detalhes de um usuário específico pelo CPF. Usando `@PutMapping` e `@RequestBody`, o método recebe um objeto JSON com as informações atualizadas do usuário e aplica as alterações no usuário correspondente no banco de dados.

->Ajustes de JSON e Roteamento:

>Algumas das mensagens de erro mencionavam problemas relacionados ao formato do JSON enviado nas requisições e também ao roteamento correto das URLs nos métodos do controlador. Foram feitos ajustes para garantir que o JSON enviado esteja correto e que as URLs estejam mapeadas corretamente nos métodos.

->Outras Melhorias:

>Foram feitas algumas melhorias na formatação do código, como garantir que os nomes dos métodos e parâmetros sigam as convenções adequadas, bem como adicionar anotações para documentar os métodos e tornar o código mais claro e legível.

->Ajustes em Endpoints Existentes:

>Os endpoints existentes, como salvar, alterar e delete, foram ajustados para lidar com listas de usuários como entrada.
>Motivo: Isso permite a realização de operações em lote, como salvar ou alterar vários usuários de uma só vez, o que pode ser mais eficiente em certos casos.

->Utilização de `@PathVariable`:

>A anotação `@PathVariable` foi usada para capturar valores de parâmetros da URL nos métodos dos controladores.
>Motivo: Isso permite que os parâmetros da URL, como CPF e ID, sejam passados diretamente para os métodos dos controladores, facilitando a construção de endpoints dinâmicos.
