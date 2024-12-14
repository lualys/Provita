import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query(value = "SELECT w FROM Word w ORDER BY FUNCTION('RANDOM') LIMIT 1", nativeQuery = true)
    Word findRandomWord();
}
