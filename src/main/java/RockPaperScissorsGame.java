import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        // Allows user to type in responses in console
        Scanner input = new Scanner(System.in);

        // This string array holds the options for the user to type in
        String[] options = {"rock", "paper", "scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Please choose one of the following options: rock, paper, or scissors");

        String playerChoice = input.nextLine().toLowerCase();;
        System.out.println("You chose: " + playerChoice);



    }
}
