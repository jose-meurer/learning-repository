const containerParagrafos = document.querySelector('.wrapper-paragrafos');

// NodeList se comporta muito parecido com um array
const paragrafos = containerParagrafos.querySelectorAll('p');

const estilosBody = getComputedStyle(document.body);
const backgroundColorBody = estilosBody.backgroundColor;
console.log(backgroundColorBody);

for(const p of paragrafos) {
    p.style.backgroundColor = backgroundColorBody;
    p.style.color = 'white';
}