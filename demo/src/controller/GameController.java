@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/guess")
    public String makeGuess(@RequestParam String letter, Model model) {
        boolean isCorrect = gameService.processGuess(letter);

        // Atualizar estado do jogo
        model.addAttribute("maskedWord", gameService.getMaskedWord());
        model.addAttribute("errors", gameService.getErrorCount());
        model.addAttribute("maxErrors", gameService.getMaxErrors());

        return "game";
    }
}
