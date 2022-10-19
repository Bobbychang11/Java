
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConnectFour {

  //characters for players (R for Red, Y for Yellow)
  private static final char[] PLAYERS = {'R', 'Y'};
  // dimensions for our board
  private final int width, height;
  // board
  private final char[][] board;
  //store last move made by a player
  private int lastCol = -1, lastTop = -1;

  public ConnectFour(int w, int h) {
    width = w;
    height = h;
    board = new char[h][];

    // create the board with blank spots 
    for (int i = 0; i < h; i++) {
      Arrays.fill(board[i] = new char[w], '.');
      //fill board with . to represent empty spots
    }
  }

  //use Streams to make a more concise method 
  // for representing the board
  public String toString() {
    return IntStream.range(0,  width).
           mapToObj(Integer::toString).
           collect(Collectors.joining()) + 
           "\n" +
           Arrays.stream(board).
           map(String::new).
           collect(Collectors.joining("\n"));
  }

  //string representation of the row containing the last play 
  public String rows() {
    return new String(board[lastTop]);
  }

  //string representation of the column containing the last play 
  public String column() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      sb.append(board[h][lastCol]);
    }

    return sb.toString();
  }

  //string representation of the "/" diagonal containing the last play 
  public String slashDiagonal() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      int w = lastCol + lastTop - h;

      if (0 <= w && w < width) {
        sb.append(board[h][w]);
      }
    }

    return sb.toString();
  }

  //string representation of the other "\" diagonal containing the last play
  public String backslashDiagonal() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      int w = lastCol - lastTop + h;

      if (0 <= w && w < width) {
        sb.append(board[h][w]);
      }
    }

    return sb.toString();
  }

  //method checking if a substring is in string
  public static boolean contains(String str, String substr) {
    return str.indexOf(substr) >= 0;
  }

  //create a method checking if last play is a winning play
  public boolean isWinningPlay() {
    if (lastCol == -1) {
      return false;
    }

    char d = board[lastTop][lastCol];
    // winning win with the last play disk
    String win = String.format("%c%c%c%c", d, d, d, d);

    // check if win is in row, col, diagonal or backslash diagonal
    return contains(rows(), win) || 
           contains(column(), win) || 
           contains(slashDiagonal(), win) || 
           contains(backslashDiagonal(), win);
  }

  // prompts the user for a column, repeating until a valid choice is made
  public void chooseAndDrop(char disk, Scanner input) {
    do {
      System.out.println("\nPlayer " + disk + " turn: ");
      int col = input.nextInt();

     
      if (!(0 <= col && col < width)) {
        System.out.println("Column must be between 0 and " + (width - 1));
        continue;
      }

      //place the disk to the first available row in the asked column
      for (int h = height - 1; h >= 0; h--) {
        if (board[h][col] == '.') {
          board[lastTop = h][lastCol = col] = disk;
          return;
        }
      }

      // if column is full, need to ask for a new input
      System.out.println("Column " + col + " is full.");
    } while (true);
  }

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      // dimensions and num max of moves
      int height = 6; int width = 7; int moves = height * width;
      
      ConnectFour board = new ConnectFour(width, height);

      //explain how to enter their choices
      System.out.println("Use 0-" + (width - 1) + " to choose a column");
      //display initial board
      System.out.println(board);

      //iterate until max num moves is reached

      for (int player = 0; moves-- > 0; player = 1 - player) {
        //disk for current player
        char disk = PLAYERS[player];

        //ask user to choose a column
        board.chooseAndDrop(disk, input);

        //display the board
        System.out.println(board);

        //need to check if a player won. If not, 
        //continue, otherwise, display a message
        if (board.isWinningPlay()) {
          System.out.println("\nPlayer " + disk + " wins!");
          return;
        }
      }
    
      System.out.println("Game over. No winner. Try again!");
    }
  }

}