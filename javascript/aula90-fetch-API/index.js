document.addEventListener("click", event => {
  const element = event.target;
  const tag = element.tagName.toLowerCase();

  if (tag === "a") {
    event.preventDefault();
    carregaPagina(element);
  }
});

async function carregaPagina(ele) {
    const href = ele.getAttribute("href");

    try{
        //Me retorna uma promise e a mesma me retorna um objeto Response
        const response = await fetch(href);

        if(response.status < 200 && response.status >= 300) {
           throw new Error("NOT FOUND");
        }

        const html = await response.text();
        carregaResultado(html)
    }
    catch(e) {
        console.error(e);
    }
}

function carregaResultado(response) {
    const resultado = document.querySelector(".resultado");
    resultado.innerHTML = response;
}