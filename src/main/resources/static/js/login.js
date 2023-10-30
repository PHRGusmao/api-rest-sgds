'use strict'

const loginConteiner = document.getElementById('login-container')

const toggleOverlay = () => loginConteiner.classList.toggle('toggle')

document.getElementById('open-register').addEventListener('click', toggleOverlay)

document.getElementById('open-login').addEventListener('click', toggleOverlay)

document.getElementById('open-register-mobile').addEventListener('click', toggleOverlay)

document.getElementById('open-login-mobile').addEventListener('click', toggleOverlay)

const form = document.getElementById('form')
const campos = document.querySelectorAll('.required')
const emailRegex =/^\w+([-+.'] \w+)*@\w+([-.]\w+)*.\w+([-.]\w+)*$/;

function nameValidate(){
    if(campos[0].value.length <3 ){
        console.log('Nome deve ter 3 caracteres')
    }
    else{
        console.log('Nome Validado')
    }
}


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