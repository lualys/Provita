import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private WordRepository wordRepository;

    @Override
    public void run(String... args) throws Exception {
        if (wordRepository.count() == 0) {
            wordRepository.saveAll(List.of(
                new Word("JAVA", "Linguagem de programação"),
                new Word("SPRING", "Framework Java")
                // Adicione mais palavras, se necessário
            ));
        }
    }
}

    }
}
