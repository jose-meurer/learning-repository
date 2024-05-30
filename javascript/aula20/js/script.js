(function() {
    const form = document.querySelector('.form');
    const result = document.querySelector('.result');

    const persons = [];

    function eventForm(e) {
        e.preventDefault();

        const name = form.querySelector('.nome');
        const lastName = form.querySelector('.sobrenome');
        const weight = form.querySelector('.peso');
        const height = form.querySelector('.altura');
        
        persons.push(person(name, lastName, weight, height));
        console.log(persons);
        result.innerHTML += `<p>${name.value} ${lastName.value} ${weight.value} ${height.value} </p>`; 
    }

    function person(name, lastName, weight, height) {
        return {
            nome: name.value,
            sobrenome: lastName.value,
            peso: weight.value,
            altura: height.value
        }
    }

    form.addEventListener('submit', eventForm);
})()