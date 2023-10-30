function enviarDados() {
    console.log("Script carregado")
    const form = document.getElementById('form-cadastro');

    const nome = form.querySelector('input[name="nomeCompleto"]').value;
    const cpf = form.querySelector('input[name="cpf"]').value;
    const email = form.querySelector('input[name="email"]').value;
    const senha = form.querySelector('input[name="senha"]').value;
    const telefone = form.querySelector('input[name="telefone"]').value;
    const cargo = form.querySelector('input[name="cargo"]').value;

    const dados = {
        "nome": nome,
        "cpf": cpf,
        "email": email,
        "senha": senha,
        "telefone": telefone,
        "cargo": cargo
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
