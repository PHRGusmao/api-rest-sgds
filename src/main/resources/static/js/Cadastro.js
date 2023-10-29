function enviarDados() {
    // URL do endpoint onde você deseja enviar os dados
    const url = 'https://panastech.com/usuario/adicionar';

    // Dados que você quer enviar (no formato JSON)
    const dados = {
        nome: 'value1',
        cpf: 'value2',
        email: '',
        senha: '',
        telefone: '',
        cargo: '',
    };

    // Configuração da requisição
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify(dados)
    };

    // Faz a requisição usando o fetch
    fetch(url, options)
        .then(response => response.json())
        .then(data => {
            console.log('Resposta do servidor:', data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}