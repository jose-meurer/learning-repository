(function () {
  function criaCalculadora() {
    return {
      display: document.querySelector(".display"),

      inicia() {
        this.cliqueBotoes();
        this.pressionarTeclas();
      },

      cliqueBotoes() {
        document.addEventListener("click", e => {
          const ele = e.target;

          if (ele.classList.contains("btn--num")) {
            this.btnParaDisplay(ele.textContent);
          }

          if (ele.classList.contains("btn--clear")) {
            this.clearDisplay();
          }

          if (ele.classList.contains("btn--del")) {
            this.apagaUmChar();
          }

          if (ele.classList.contains("btn--eq")) {
            this.realizaConta();
          }
        });
      },

      pressionarTeclas() {
        document.addEventListener("keypress", e => {
          e.preventDefault();

          if (e.key === "Enter") {
            this.realizaConta();
          }
        });
      },

      realizaConta() {
        let conta = this.display.value;
        try {
          conta = eval(conta);

          if (!conta) {
            alert("Conta inválida");
            return;
          }

          this.display.value = conta;
        } catch (e) {
          alert("Conta inválida");
        }
      },

      apagaUmChar() {
        this.display.value = this.display.value.slice(0, -1);
      },

      btnParaDisplay(valor) {
        this.display.value += valor;
      },

      clearDisplay() {
        this.display.value = "";
      },
    };
  }

  const calculadora = criaCalculadora();
  calculadora.inicia();
})();
