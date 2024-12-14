import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private int bestScore;

    private LocalDateTime bestScoreDate;

    // Construtor vazio (necessário para JPA)
    public Player() {
    }

    // Construtor com parâmetros
    public Player(String nickname, int bestScore, LocalDateTime bestScoreDate) {
        this.nickname = nickname;
        this.bestScore = bestScore;
        this.bestScoreDate = bestScoreDate;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public LocalDateTime getBestScoreDate() {
        return bestScoreDate;
    }

    public void setBestScoreDate(LocalDateTime bestScoreDate) {
        this.bestScoreDate = bestScoreDate;
    }
}
