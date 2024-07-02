class ValidaFormulario {
  constructor() {
    this.formulario = document.querySelector(".formulario");
    this.eventos();
  }

  eventos() {
    this.formulario.addEventListener("submit", event => this.handleSubmit(event));
  }

  handleSubmit(event) {
    event.preventDefault();

    const camposValidos = this.camposValidos();
    const senhasValidas = this.validaSenha();

    if (camposValidos && senhasValidas) {
      this.formulario.submit();
      alert("Formulário enviado.");
    }
  }

  camposValidos() {
    let valido = true;

    this.formulario.querySelectorAll(".form-erro").forEach(erro => erro.remove());
    this.formulario.querySelectorAll(".validar").forEach(elemento => {
      const label = elemento.parentElement.innerText;

      if (!elemento.value) {
        this.criaErro(elemento, `Campo "${label}" não pode estar em branco.`);
        valido = false;
      }

      if (elemento.classList.contains("cpf")) {
        if (!this.validaCPF(elemento)) {
          valido = false;
        }
      }

      if (elemento.classList.contains("usuario")) {
        if (!this.validaUsuario(elemento)) {
          valido = false;
        }
      }
    });

    return valido;
  }

  validaSenha() {
    let valido = true;

    const senha = this.formulario.querySelector(".senha");
    const repetirSenha = this.formulario.querySelector(".repetir-senha");

    if (senha.value !== repetirSenha.value) {
      this.criaErro(senha, "As senhas não são iguais.");
      this.criaErro(repetirSenha, "As senhas não são iguais.");
      valido = false;
    }

    if (senha.value.length < 6 || senha.value.length > 12) {
      this.criaErro(senha, "Senha precisa estar entre 6 e 12 caracteres");
      valido = false;
    }

    return valido;
  }

  validaUsuario(elemento) {
    const usuario = elemento.value;
    let valido = true;

    if (usuario.length < 3 || usuario.length > 12) {
      this.criaErro(elemento, "Usuário precisa ter entre 3 e 12 caracteres.");
      valido = false;
    }

    if (!usuario.match(/^[a-zA-Z0-9]+$/g)) {
      this.criaErro(elemento, "Nome de usuário precisa conter apenas letras e números.");
      valido = false;
    }

    return valido;
  }

  validaCPF(elemento) {
    const cpf = new ValidaCPF(elemento.value);

    if (!cpf.valida()) {
      this.criaErro(elemento, "CPF inválido.");
      return false;
    }

    return true;
  }

  criaErro(elemento, mensagem) {
    const div = this.criaDiv();
    div.classList.add("form-erro");

    const p = this.criaP();
    p.innerText = mensagem;
    div.appendChild(p);

    // elemento.insertAdjacentElement("beforebegin", div);
    elemento.parentElement.insertBefore(div, elemento);
  }

  criaDiv() {
    return document.createElement("div");
  }

  criaP() {
    return document.createElement("p");
  }
}

const formularioValidado = new ValidaFormulario();
