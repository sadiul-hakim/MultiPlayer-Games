const gameId = "game-tic-tac-toe-123";  // Unique game session ID (you can improve this)
let stompClient = null;
let currentPlayer = "X";

function connect() {
    let socket = new SockJS('/game');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        // console.log("Connected: " + frame);
        stompClient.subscribe('/topic/tic-tac-toe', function (response) {
            updateGame(JSON.parse(response.body));
        });
    });
}

function sendMove(row, col) {
    if (stompClient) {
        stompClient.send("/app/move-tic-tac-toe", {}, JSON.stringify({gameId: gameId, row: row, col: col}));
    }
}

function updateGame(gameState) {
    console.log(gameState)

    let board = gameState.board;
    let statusText = "";
    currentPlayer = gameState.currentPlayer;

    document.getElementById("board").innerHTML = "";
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            let cell = document.createElement("div");
            cell.className = "cell";
            cell.textContent = board[i][j] !== " " ? board[i][j] : "";

            if (!gameState.gameOver && board[i][j] === " " && gameState.currentPlayer === currentPlayer) {
                cell.addEventListener("click", () => sendMove(i, j));
            } else {
                cell.classList.add("disabled");
            }
            document.getElementById("board").appendChild(cell);
        }
    }

    if (gameState.gameOver) {
        statusText = gameState.winner === "Draw" ? "It's a Draw!" : `Player ${gameState.winner} Wins!`;
    } else {
        statusText = `Player ${gameState.currentPlayer}'s Turn`;
    }
    document.getElementById("status").textContent = statusText;
}

document.addEventListener("DOMContentLoaded", () => {
    connect();
    updateGame({
        board: [[" ", " ", " "], [" ", " ", " "], [" ", " ", " "]],
        currentPlayer: "X",
        gameOver: false,
        winner: null
    });
});