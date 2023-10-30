function enviarDados() {
    const form = document.querySelector('.form-cadastro');
    // URL do endpoint onde você deseja enviar os dados
    const url = 'https://panastech.com/usuarios';

    // Dados que você quer enviar (no formato JSON)
    const dados = {};
    form.querySelectorAll('.form-input').forEach(input => {
        dados[input.name] = input.value;
    });

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