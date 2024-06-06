(function () {
  const relogio = document.querySelector(".relogio");

  let time;
  let segundos = 0;

  document.addEventListener("click", e => {
    const ele = e.target;

    if (ele.classList.contains("iniciar")) {
      clearInterval(time);
      time = setInterval(() => {
        segundos++;
        mostraCronometro();
      }, 1000);

      relogio.style.color = "black";
    }

    if (ele.classList.contains("pausar")) {
      clearInterval(time);
      relogio.style.color = "red";
    }

    if (ele.classList.contains("zerar")) {
      clearInterval(time);
      segundos = 0;
      mostraCronometro();
      relogio.style.color = "black";
    }
  });

  function criarCronometro(segundos) {
    const segudosParaMs = segundos * 1000;
    const data = new Date(segudosParaMs);
    return Intl.DateTimeFormat("pt-BR", {
      hour12: false,
      timeZone: "UTC",
      timeStyle: "medium",
    }).format(data);
  }

  function mostraCronometro() {
    relogio.innerText = criarCronometro(segundos);
  }
})();
