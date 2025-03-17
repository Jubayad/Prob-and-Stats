import java.util.Scanner;

public class GameSetup {
    
    private Player player1;
    private Player player2;
    private Deck player1Deck;
    private Deck player2Deck;

    public void GameSetup(){
        Scanner askUser = new Scanner(System.in);

        System.out.println("How many Pokemon Cards for player 1: ");
        int pokemonCountPlayer1 = askUser.nextInt();

        System.out.println("How many Trainer Cards for player 1: ");
        int trainerCountPlayer1 = askUser.nextInt();

        System.out.println("How many Pokemon Cards for player 2:");
        int pokemonCountPlayer2 = askUser.nextInt();

        System.out.println("How many Trainer Cards for player 2: ");
        int trainerCountPlayer2 = askUser.nextInt();

        player1Deck = new Deck(pokemonCountPlayer1, trainerCountPlayer1);
        player2Deck = new Deck(pokemonCountPlayer2, trainerCountPlayer2);

        player1 = new Player();
        player2 = new Player();

        Mulligan mulligan = new Mulligan();

        player1.startingHand(player1Deck, mulligan);
        player2.startingHand(player2Deck, mulligan);
    }


    public void startGame(){
        Turn player1Turn = new Turn(player1, player2, player1Deck);
        Turn player2Turn = new Turn(player2, player1, player2Deck);

        while(true){
            System.out.println("---------- Player 1's Turn ----------");
            player1Turn.StartGame();

            System.out.println("---------- Player 2's Turn ----------");
            player2Turn.StartGame();
        }
    }
}
