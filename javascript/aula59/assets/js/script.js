(function () {
  //Funcao construtora
  function Calculadora() {
    this.display = document.querySelector(".display");

    this.inicia = () => {
      this.cliqueBotoes();
      this.pressionarTeclas();
    };

    this.cliqueBotoes = () => {
      document.addEventListener("click", event => {
        const elemento = event.target;

        if (elemento.classList.contains("btn--num")) this.btnParaDisplay(elemento.textContent);

        if (elemento.classList.contains("btn--clear")) this.clear();

        if (elemento.classList.contains("btn--del")) this.del();

        if (elemento.classList.contains("btn--eq")) this.realizaConta();
      });
    };

    this.pressionarTeclas = () => {
      document.addEventListener("keypress", event => {
        event.preventDefault();

        if (event.key === "Enter") this.realizaConta();
      });
    };

    this.clear = () => (this.display.value = "");

    this.del = () => (this.display.value = this.display.value.slice(0, -1));

    this.btnParaDisplay = valor => (this.display.value += valor);

    this.realizaConta = () => {
      let conta = this.display.value;
      try {
        conta = eval(conta);

        if (!conta && conta !== 0) {
          alert("Conta Inválida");
          return;
        }

        this.display.value = conta;
      } catch (e) {
        alert("Conta Inválida");
        return;
      }
    };
  }

  const calculadora = new Calculadora(); //Calcudora agora foi criada com uma funcao construtora;
  calculadora.inicia();
  calculadora.;
})();
