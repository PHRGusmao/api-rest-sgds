function enviarDados() {
    const form = document.getElementById('form-cadastro');

    const dados = {
        "nome": form.querySelector('input[name="nomeCompleto"]').value,
        "cpf": form.querySelector('input[name="cpf"]').value,
        "email": form.querySelector('input[name="email"]').value,
        "senha": form.querySelector('input[name="senha"]').value,
        "telefone": form.querySelector('input[name="telefone"]').value,
        "cargo": form.querySelector('input[name="cargo"]').value
    };

    const url = 'https://panastech.com/usuarios';

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify(dados)
    };

    fetch(url, options)
        .then(response => response.json())
        .then(data => {
            console.log('Resposta do servidor:', data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}
