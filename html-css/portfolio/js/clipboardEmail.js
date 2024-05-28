(function() {
    const email = document.getElementById('email');
    const emailContainer = document.getElementsByClassName('contact__wrapperEmail')[0];

    emailContainer.addEventListener('click', (e) => {
        e.preventDefault();

        navigator.clipboard.writeText(email.textContent);

        alert('Email copiado para sua área de transferência!');
    })
})()