package xyz.sadiulhakim.game.ticTacToe;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Controller
public class GameController {

    private final ConcurrentMap<String, TicTacToe> games = new ConcurrentHashMap<>();

    @MessageMapping("/move-tic-tac-toe")
    @SendTo("/topic/tic-tac-toe")
    public State makeMove(Move move) {

        String gameId = move.getGameId();
        TicTacToe game = games.computeIfAbsent(gameId, id -> new TicTacToe());

        boolean validMove = game.makeMove(move.getRow(), move.getCol());

        return new State(gameId, game.getBoard(), game.getCurrentPlayer(), game.isGameOver(), game.getWinner(),
                validMove);
    }

    @GetMapping("/tic-tac-toe")
    String page() {
        return "game/ticTacToe";
    }
}
