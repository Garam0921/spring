package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @PostMapping("/api/game")
    public Game saveGame(@ResponseBody Game game) {
        return gameService.saveGame(game);
    }
    @GetMapping("/api/game")
    public List<Game> getAllGames() {
        return gameService.getAllGames;
    }
    @GetMapping("/api/game/{id}")
    public Game getGameByld(@PathVariable long id,
                            @RequestBody Game game) {
        return gameService.getGameByld(id, game);
    }
    @PutMapping("/api/game/{id}")
    public Game updateGameByld(@PathVariable long id,
                               @RequestBody Game game) {
        return gameService.updateGameByld(id, game);
    }
    public Game deleteGameByld(@PathVariable long id) {
        return gameService.deleteGameByld(id);
    }
}
