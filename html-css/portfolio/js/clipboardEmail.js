(function () {
  const email = document.getElementById("email");
  const emailContainer = document.getElementsByClassName("contact__wrapperEmail")[0];

  emailContainer.addEventListener("click", eventCopyEmail);

  emailContainer.addEventListener("keypress", e => {
    if (e.keyCode === 13) {
      eventCopyEmail();
    }
  });

  function copyEmail() {
    navigator.clipboard.writeText(email.textContent);
  }

  function eventCopyEmail() {
    copyEmail();
    feedbackCopied(emailContainer);
  }

  function feedbackCopied(ele) {
    const span = document.createElement('span');
    span.classList.add('copied');
    span.textContent = 'COPIADO'
    ele.appendChild(span);

    setTimeout(() => {
        emailContainer.removeChild(span)
        alert("Email copiado para sua área de transferência!");
    }, 500);    
  }

})();
