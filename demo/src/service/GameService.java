@Service
public class GameService {
    private int errorCount = 0;
    private final int maxErrors = 6;
    private String maskedWord = "";
    private String selectedWord = "EXEMPLO";

    public boolean processGuess(String letter) {
        if (!selectedWord.contains(letter)) {
            errorCount++;
            return false;
        }
        // Atualizar palavra mascarada aqui
        return true;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public int getMaxErrors() {
        return maxErrors;
    }

    public String getMaskedWord() {
        return maskedWord;
    }
}

