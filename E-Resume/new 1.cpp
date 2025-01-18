#include <iostream>
#include <array>

// Constants for the size of the board and the characters used to represent
// each player
constexpr int kBoardSize = 3;
constexpr char kPlayerX = 'X';
constexpr char kPlayerO = 'O';

// Represents the state of the game
struct GameState {
  std::array<std::array<char, kBoardSize>, kBoardSize> board;
  char current_player;
};

// Initializes the game state with an empty board and player X's turn
void InitGame(GameState* state) {
  for (int i = 0; i < kBoardSize; i++) {
    for (int j = 0; j < kBoardSize; j++) {
      state->board[i][j] = ' ';
    }
  }
  state->current_player = kPlayerX;
}

// Prints the current game board
void PrintBoard(const GameState& state) {
  std::cout << "  ";
  for (int i = 0; i < kBoardSize; i++) {
    std::cout << i << " ";
  }
  std::cout << std::endl;
  for (int i = 0; i < kBoardSize; i++) {
    std::cout << i << " ";
    for (int j = 0; j < kBoardSize; j++) {
      std::cout << state.board[i][j] << " ";
    }
    std::cout << std::endl;
  }
}

// Asks the player for their next move and makes it
void GetPlayerMove(GameState* state) {
  int row, col;
  std::cout << "Enter row and column: ";
  std::cin >> row >> col;
  state->board[row][col] = state->current_player;
}

// Returns true if the given player has won
bool CheckWin(const GameState& state, char player) {
  // Check rows
  for (int i = 0; i < kBoardSize; i++) {
    if (state.board[i][0] == player &&
        state.board[i][1] == player &&
        state.board[i][2] == player) {
      return true;
    }
  }
  // Check columns
  for (int i = 0; i < kBoardSize; i++) {
    if (state.board[0][i] == player &&
        state.board[1][i] == player &&
        state.board[2][i] == player) {
      return true;
    }
  }
  // Check diagonals
  if (state.board[0][0] == player &&
      state.board[1][1] == player &&
      state.board[2][2] == player) {
    return true;
  }
  if (state.board[0][2] == player &&
      state.board[1][1] == player &&
      state.board[2][0] == player) {
    return true;
  }
  return false;
}
