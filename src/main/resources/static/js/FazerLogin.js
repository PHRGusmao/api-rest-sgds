function fazerLogin() {
    const cpf = document.getElementById('inputCpf').value;
    const senha = document.getElementById('inputSenha').value;

    fetch(`https://panastech.com/usuarios/search/findByCpf?cpf=${cpf}`)
        .then(response => response.json())
        .then(data => {
            const usuario = data;
            const senhaDoUsuario = usuario.senha;

            if (senhaDoUsuario && senhaDoUsuario === senha) {
                alert('Login bem-sucedido!');
                window.location.href = '../pages/Perfil.html';
            } else {
                alert('Senha incorreta');
            }
        })
        .catch(error => {
            alert('CPF incorreto ou usuário não encontrado');
            console.error('Erro:', error);
        });
}
