package dw.gameshop.service;

import dw.gameshop.model.Game;
import dw.gameshop.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class GameService {
    @Autowired
    GameRepository gameRepository;
    public Game saveGame(Game game) {
        gameRepository.save(game);
        return  game;
    }
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
    public  Game getGameByld(long id) {
        Optional<Game> game = gameRepository.findByld(id);
        if (game.isEmpty()) {
            return null;
        } else  {
            return game.get();
        }
    }
    public Game updateGameByld(long id, Game game) {
        Optional<Game> game1 = gameRepository.findByld(id);
        if (game1.isPresent()) {
            game1.get().setTitle(game.getTitle());
            game1.get().setGenre(game.getGenre());
            game1.get().setPrice(game.getPrice());
            game1.get().setImage(game.getImage());
            game1.get().setText(game.getText());
            gameRepository.save(game1.get());

            return game1.get();
        } else {
            return null;
        }
    }
    public Game deleteGameBlyd(long id) {
        Optional<Game> game = gameRepository.findByld(id);
        if (game.isPresent()) {
            gameRepository.deleteByld(id);
            return game.get();
        } else {
            return null;
        }
    }
}
