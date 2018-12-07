import java.util.Scanner;

public class Pig {
	
	public static int dice () {
		return (int) (Math.random() * 6) + 1; // generates a number between 1 and 6 which indicates a side of the dice
	}
	
	public static void playGame(boolean player1, boolean player2) {
		int score1 = 0; 
		int score2 = 0; 
		boolean turn = true; // true is player one's turn
		
		while (score1 < 100 && score2 < 100) {
			System.out.println("Player 1 Score: " + score1);
			System.out.println("Player 2 Score: " + score2);
			System.out.println();
			
			if (turn == true) // if it's player one's turn
				score1 += playTurn(player1, 1, score1); // calls the play turn method for player 1
			else if (!turn)
				score2 += playTurn(player2, 2, score2); // calls the play turn method for player 2
			
			turn = !turn; // switches the player's turns	
		}
		
		System.out.println("Player 1 Score: " + score1);
		System.out.println("Player 2 Score: " + score2);
		
		if (score1 > score2)
			System.out.println("Player 1 Wins!");
		else
			System.out.println("Player 2 Wins!");
	}

	public static int playTurn(boolean player, int number, int totalScore) {
		int turnScore = 0;
		int roll = 0;
		boolean hold = false; // indicates that the player is continuing to roll
		
		if (player)
			System.out.println("Player " + number + "'s Turn (Human)");
		else
			System.out.println("Player " + number + "'s Turn (Computer)");
		
		while (!hold) {
			roll = dice(); // sets the player's roll to the random side of the dice generated
			turnScore += roll; // keeps track of the turn score for said turn
			System.out.println("Rolled a " + roll);
			if (roll != 1)
				hold = getDecision(player, turnScore, totalScore); // calls the get decision method 
			else {
				turnScore = 0;
				hold = true;
			}	
		}
			
		System.out.println("Turn Over");
		System.out.println();
		
		return turnScore; // displays turn score after turn is over
			
	}
	
	public static boolean getDecision(boolean player, int turnScore, int totalScore) {
		Scanner in = new Scanner (System.in);
		
		System.out.println("Turn Score: " + turnScore);
		if (player == true) { // human player
			System.out.print("Hold or Roll? (h or r) ");
			String choice = in.next();
			if (choice.equals("h")) {
				System.out.println("Human player holds");
				return true;
			}
			else {
				System.out.println("Human player rolls");
				return false;
			}
				
		}
		else { // computer player
			int total = turnScore + totalScore;
			if (total >= 20) { // hold at 20 or goal strategy 
				System.out.println("Computer player holds");
				return true;
			}
			else if (total >= 100) { // if the computer wins it will stop playing
				System.out.println("Computer player holds");
				return true;
			}
			else {
				System.out.println("Computer player rolls");
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("The Game of Pig");
		System.out.println("--------------------------------------");
		System.out.println("1. Human vs. Human");
		System.out.println("2. Human vs. Computer");
		System.out.println("3. Computer vs. Computer");
		System.out.println();
		System.out.print("What kind of game to you want to play?");
		int game = in.nextInt();
		System.out.println();
		
		if (game == 1)
			playGame(true, true); // human vs. human
		else if (game == 2)
			playGame(true, false); // human vs. computer
		else if (game == 3)
			playGame(false, false); // computer vs. computer 
		
		
	}

}
