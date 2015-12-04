/**
 * T H E   G A M E   O F   N I M
 * im already getting a headache
 * written by brandon berney
 */

import java.util.Scanner;
public class nim {
    private static Scanner input = new Scanner(System.in);

    private static final int
            MAX_STEALS = 2,
            PC_REMAINDER_ZERO = 2,
            PC_REMAINDER_ELSE = 1;
    private static final String
            PLAYER_PERSON = "Player",
            PLAYER_PC = "Computer";
    private static int remaining_stones;

    public static void main(String[] args) {
        introduction();
    }

    private static void introduction() {
        System.out.println("T H E   G A M E   O F   N I M"); // I have a headache
        System.out.print("Number of stones to start with: ");
        remaining_stones = input.nextInt();

        playFirstPrompt();
    }

    private static void playFirstPrompt() {
        String playFirst;

        System.out.print("\nWould you like to go first? (y/n) ");
        playFirst = input.next();

        if (playFirst.equalsIgnoreCase("y")) {
            playerTurn();
        }
        else if (playFirst.equalsIgnoreCase("n")) {
            pcTurn();
        }
        else {
            System.out.println("Invalid selection.");
            playFirstPrompt();
        }
    }

    private static void playAgainPrompt() {
        String playAgain;

        System.out.print("\nWould you like to play again? (y/n) ");
        playAgain = input.next();

        if (playAgain.equalsIgnoreCase("y")) {
            introduction();
        }
        else if (playAgain.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid selection.");
            playAgainPrompt();
        }
    }

    private static void next(String player) {
        System.out.printf("%nThere are %d stone(s) left.%ny", remaining_stones);

        if (remaining_stones == 0) {
            System.out.printf("%s won!", player);
            playAgainPrompt();
        }
        else if(player == PLAYER_PC) {
            pcTurn();
        }
        else {
            playerTurn();
        }
    }
    private static void playerTurn() {
        int player_stones_drawn;

        System.out.print("How many stones would you like to remove? [1-2] ");
        player_stones_drawn = input.nextInt();

        if (player_stones_drawn < 0) {
            System.out.println("You must remove a stone!");
            playerTurn();
        }
        else if (player_stones_drawn > MAX_STEALS) {
            System.out.println("You may not remove more than two stones.");
            playerTurn();
        }
        else if (player_stones_drawn > remaining_stones) {
            System.out.println("You've removed more stones than there are left in the pile!");
            playerTurn();
        }
        else {
            remaining_stones -= player_stones_drawn;
        }
        next(PLAYER_PC);
    }

    private static void pcTurn() {
        int remainder;

        remainder = (remaining_stones % 3);
        if (remainder == 0) {
            remaining_stones -= 2;
            System.out.println("The computer removed 2 stones.");
        }
        else {
            remaining_stones -= 1;
            System.out.println("The computer removed 1 stone.");
        }
        next(PLAYER_PERSON);
    }
}
