document.addEventListener("DOMContentLoaded", () => {
    // Dados iniciais
    const maskedWordElement = document.getElementById("masked-word");
    const feedbackElement = document.getElementById("feedback");
    const errorCountElement = document.getElementById("error-count");
    const hintButton = document.getElementById("hint-button");
    const hintElement = document.getElementById("hint");
    const hangmanParts = ["head", "body", "left-arm", "right-arm", "left-leg", "right-leg"];

    let maskedWord = "_____"; // Palavra oculta
    let actualWord = "JAVASCRIPT"; // Palavra correta
    let errors = 0;

    // Função para atualizar a palavra mascarada
    function updateMaskedWord(letter) {
        let updatedWord = "";
        for (let i = 0; i < actualWord.length; i++) {
            if (actualWord[i] === letter) {
                updatedWord += letter;
            } else {
                updatedWord += maskedWord[i];
            }
        }
        return updatedWord;
    }

    // Exibir dica
    hintButton.addEventListener("click", () => {
        hintElement.textContent = "Linguagem de programação usada no front-end.";
        hintElement.style.display = "block";
    });

    // Atualizar erros
    function updateErrors() {
        if (errors < hangmanParts.length) {
            document.getElementById(hangmanParts[errors]).style.display = "block";
            errors++;
            errorCountElement.textContent = errors;
        }
    }

    // Função de feedback
    function showFeedback(message, isCorrect) {
        feedbackElement.textContent = message;
        feedbackElement.className = isCorrect ? "text-success" : "text-danger";
        const sound = isCorrect ? "success-sound" : "error-sound";
        document.getElementById(sound).play();
    }

    // Submissão do formulário
    document.getElementById("guess-form").addEventListener("submit", (e) => {
        e.preventDefault();
        const guess = document.getElementById("guess-input").value.toUpperCase();
        document.getElementById("guess-input").value = "";

        if (actualWord.includes(guess)) {
            maskedWord = updateMaskedWord(guess);
            maskedWordElement.textContent = maskedWord;
            showFeedback("Acertou!", true);
        } else {
            updateErrors();
            showFeedback("Errou! Tente novamente.", false);
        }

        if (errors >= hangmanParts.length) {
            alert("Você perdeu! A palavra era: " + actualWord);
            location.reload();
        } else if (!maskedWord.includes("_")) {
            alert("Parabéns! Você venceu!");
            location.reload();
        }
    });
});
