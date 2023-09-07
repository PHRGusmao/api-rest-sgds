# TCC PanasTech - 2023 - api-rest-sgds 🧬🩺

![PanasTech logomarca](https://raw.githubusercontent.com/PHRGusmao/api-rest-sgds/main/src/main/resources/img/PanasTech%20logomarca.png)

Desenvolvimento da API para TCC 2023 do software SGDS.
© TCC de 2023 do grupo `PanasTech`  : `SGDS Sistema de Gestão de Saúde`.

# Etapas de desenvolvimento até (01/09/2023) ⚙⏳
- [ x ] Start na produção do projeto para o backend do sitema SGDS(Sistema de Gestão de Saúde) *croos-plataforma*.
- [ x ] API conectar com banco de dados. 
- [ x ] API tratar requisições pelo protocolo HTTP.
- [ x ] Definição de rotas mais elaboradas.
  - [ ! ] Corrigir arquitetura de sistema e nomeclaturas.
- [ x ] API tratar requisições de softwares terceiros.

# Previsão de desenvolvimento até (15/10/2023) ⚙⏳
- [ x ] Adicionar o suporte de segurança do _`spring-security`_.
- [ - ] Aprimorar e refinar a segurança com o _`spring-security`_.
- [ - ] Colocar a aplicação em um servidor.


## Alterações feitas 🛠

-> *Não foi concluída a etapa de desenvolvimento do _`spring-security`_, na aplicação, por completo*

> Levando isso em conta poderemos encontrar retorno de _STATUS HTTP_ (401 ou 403) fora do esperado no período de testes!

-> *Adição do spring-security!*

> O Spring Security é um framework de segurança amplamente utilizado em aplicativos Java para proteger recursos e controlar o acesso de usuários. De forma sucinta, o Spring Security serve para:

> *Autenticação:* Ele permite autenticar usuários, verificando suas credenciais (geralmente nome de usuário e senha) e concedendo ou negando acesso com base nessas credenciais.

> *Autorização:* Ele gerencia as permissões de acesso dos usuários a recursos específicos, como páginas da web, APIs ou métodos de serviço, garantindo que apenas usuários autorizados tenham acesso.

> Proteção contra ameaças de segurança:* O Spring Security ajuda a proteger aplicativos contra várias ameaças de segurança, como ataques de injeção SQL, CSRF (Cross-Site Request Forgery), XSS (Cross-Site Scripting) e outros ataques comuns.

> *Integração com outros frameworks:* Ele pode ser facilmente integrado a outros componentes do Spring, como o Spring Boot e o Spring MVC, tornando-o uma escolha popular para aplicativos Java empresariais.
 
> *Gerenciamento de Sessão:* Ele oferece recursos para gerenciar sessões de usuário, incluindo autenticação de vários fatores e controle de tempo de sessão.

## Versões anteriores a 1.2.0
 
-> *Adição do Método de Busca por Nome:*

>Foi criado um novo método no controlador UsuarioRest para buscar usuários pelo nome. Utilizando a anotação @GetMapping e o parâmetro @PathVariable, o método aceita o nome como entrada e retorna uma lista de usuários correspondentes ou um status 404 caso nenhum usuário seja encontrado.

-> *Método para Atualização por CPF:*

>Foi implementado um novo método alterarUsuarioByCpf no controlador UsuarioRest para atualizar os detalhes de um usuário específico pelo CPF. Usando @PutMapping e @RequestBody, o método recebe um objeto JSON com as informações atualizadas do usuário e aplica as alterações no usuário correspondente no banco de dados.

-> *Ajustes de JSON e Roteamento:*

>Algumas das mensagens de erro mencionavam problemas relacionados ao formato do JSON enviado nas requisições e também ao roteamento correto das URLs nos métodos do controlador. Foram feitos ajustes para garantir que o JSON enviado esteja correto e que as URLs estejam mapeadas corretamente nos métodos.

-> *Outras Melhorias:*

>Foram feitas algumas melhorias na formatação do código, como garantir que os nomes dos métodos e parâmetros sigam as convenções adequadas, bem como adicionar anotações para documentar os métodos e tornar o código mais claro e legível.

-> *Ajustes em Endpoints Existentes:*

>Os endpoints existentes, como salvar, alterar e delete, foram ajustados para lidar com listas de usuários como entrada.
>Motivo: Isso permite a realização de operações em lote, como salvar ou alterar vários usuários de uma só vez, o que pode ser mais eficiente em certos casos.

-> *Utilização de @PathVariable:*

>A anotação @PathVariable foi usada para capturar valores de parâmetros da URL nos métodos dos controladores.
>Motivo: Isso permite que os parâmetros da URL, como CPF e ID, sejam passados diretamente para os métodos dos controladores, facilitando a construção de endpoints dinâmicos.
