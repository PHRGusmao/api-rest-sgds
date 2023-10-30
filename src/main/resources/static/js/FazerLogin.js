function fazerLogin() {
    const cpf = document.getElementById('inputCpf').value;
    const senha = document.getElementById('inputSenha').value;

    fetch(`https://panastech.com/usuarios/search/findByCpf?cpf=${cpf}`)
    .then(response => {
        if (!response.ok) {
            throw new Error('CPF incorreto');
        }
        return response.json();
    })
    .then(data => {
        const usuario = data._embedded.usuarios[0];
        const senhaDoUsuario = usuario.senha;

        if (senhaDoUsuario && senhaDoUsuario === senha) {
            alert('Login bem-sucedido!');
            window.location.href = '../root/pages/Perfil.html';
        } else {
            alert('Senha incorreta');
        }
    })
    .catch(error => {
        alert(error.message); // Exibe a mensagem de erro, seja "CPF incorreto" ou outro erro
    });
}
