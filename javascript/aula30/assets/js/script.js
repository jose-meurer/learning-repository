(function () {
  const dateTitle = document.querySelector(".dateTitle");
  const data = new Date();

  setDataAtual();

  function setDataAtual() {
    const diaSemana = diaDaSemana(data.getDay());
    const dia = data.getDate();
    const mesAno = nomeMes(dataAgora.getMonth());
    const ano = data.getFullYear();
    const horas = data.getHours();
    const minutos = data.getMinutes();

    dateTitle.innerHTML = montaData(diaSemana, dia, mesAno, ano, horas, minutos);
  }

  function montaData(diaSemana, dia, mesAno, ano, hora, minuto) {
    return `${diaSemana}, ${dia} de ${mesAno} de ${ano} ${hora}:${minuto}`;
  }

  function diaDaSemana(dia) {
    switch (dia) {
      case 0:
        return "Domingo";
      case 1:
        return "Segunda-feira";
      case 2:
        return "Terça-feira";
      case 3:
        return "Quarta-feira";
      case 4:
        return "Quinta-feira";
      case 5:
        return "Sexta-feira";
      case 6:
        return "Sabado";
      default:
        return "Dia invalido";
    }
  }

  function nomeMes(mes) {
    const meses = [
      "Janeiro",
      "Fevereiro",
      "Março",
      "Abril",
      "Maio",
      "Junho",
      "Julho",
      "Agosto",
      "Setembro",
      "Outubro",
      "Novembro",
      "Dezembro",
    ];

    return meses[mes];
  }
})();


// Outra forma, utilizando as ferramentas da linguagem
// const h1 = document.querySelector('.container h1');
// const data = new Date();
// h1.innerHTML = data.toLocaleString('pt-BR', {dateStyle: 'full', timeStyle: 'short'});