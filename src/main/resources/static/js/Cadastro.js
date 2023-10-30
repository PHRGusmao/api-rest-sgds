function enviarDados() {
    console.log("Script carregado")
    const form = document.getElementById('form-cadastro');

    const nome = form.querySelector('input[name="nome"]').value;
    console.log('Valor do Nome:', nome);
    const cpf = form.querySelector('input[name="cpf"]').value;
    console.log('Valor do cpf:', cpf);
    const email = form.querySelector('input[name="email"]').value;
    console.log('Valor do e-mail:', email);
    const senha = form.querySelector('input[name="senha"]').value;
    console.log('Valor da senha:', senha);
    const telefone = form.querySelector('input[name="telefone"]').value;
    console.log('Valor do telefone:', telefone);
    const cargo = form.querySelector('select[name="cargo"]').value;
    console.log('Valor do cargo:', cargo);

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
            alert('Cadastro efetuado com sucesso!');
            console.log('Resposta do servidor:', data);
        })
        .catch(error => {
            alert('Erro:', error);
            console.error('Erro:', error);
        });
}
