function fazerLogin() {
    const cpf = document.getElementById('inputCpf').value;
    const senha = document.getElementById('inputSenha').value;

    fetch(`https://panastech.com/usuarios/search/findByCpf?cpf=${cpf}`)
        .then(response => response.json())
        .then(data => {
            const usuario = data._embedded.usuarios[0];

            if (usuario) {
                if (usuario.senha === senha) {
                    alert('Login bem-sucedido!');
                    window.location.href = '../root/pages/Perfil.html';
                } else {
                    alert('Senha incorreta');
                }
            } else {
                alert('CPF incorreto');
            }
        })
        .catch(error => {
            console.error('Erro:', error);
        });
}