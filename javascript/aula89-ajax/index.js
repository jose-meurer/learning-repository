// Asynchronous JavaScript and XML

const request = obj => {
  return new Promise((resolve, reject) => {
    const xhr = new XMLHttpRequest();
    xhr.open(obj.method, obj.url, true);
    xhr.send();

    xhr.addEventListener("load", e => {
      if (xhr.status >= 200 && xhr.status < 300) {
        resolve(xhr.responseText);
      } else {
        reject(xhr.statusText);
      }
    });
  });
};

document.addEventListener("click", event => {
  const element = event.target;
  const tag = element.tagName.toLowerCase();

  if (tag === "a") {
    event.preventDefault();
    carregaPagina(element);
  }
});

async function carregaPagina(element) {
  const href = element.getAttribute("href");

  const objConfig = {
    method: "GET",
    url: href,
  };

  try {
    const response = await request(objConfig);
    carregaResultado(response);
  } catch (err) {
    console.error(err);
  }
}

function carregaResultado(response) {
  const resultado = document.querySelector(".resultado");
  resultado.innerHTML = response;
}
