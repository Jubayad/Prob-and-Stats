import java.util.Scanner;

public class Turn{

    private Player player;                          //Making a player variable.
    private Player opponent;                        //Making a opponent variable.
    private Deck playerDeck;                        //Making a playerdeck variable which is the player's deck.

    //Creating a constructer class for Turn
    public Turn(Player player, Player opponent, Deck playerDeck){

        this.player = player;
        this.opponent = opponent; 
        this.playerDeck = playerDeck;
    }

    //Creating the start method which starts the game by starting the turn logic
    public void StartGame(){
        Scanner scanner = new Scanner(System.in);                          

        Card drawnCard = playerDeck.drawCard(player.getHand());            //Creates a variable in where drawnCard equals drawing a card to the players hand.

            if(drawnCard == null){                                         //If you have no cards remaining in the deck or null.
                System.out.println("You have no remaining cards in your deck. You have lost. Game Over."); //Game's over since no more cards remaning in deck.
                System.exit(0);                                                                       //Exits the game since you have lost.
            }
            else{
                System.out.println("You drew a: " + drawnCard.getName());
            } 

            Board();                                                           //Displays the board.


            boolean turnEnded = false;                                         //Creating a boolean variable

            while(!turnEnded){                                                 //While turn ended is false
                System.out.println("\nWhat would you like to do?");          //Gives the player a list of options to choose from
                System.out.println("1. Play a card");
                System.out.println("2. Attack");
                System.out.println("3. Switch active pokemon");
                System.out.println("4. See the Board");
                System.out.println("5. See your hand.");
                System.out.println("6. End your turn");
                System.out.println("Enter your choice (number): ");
                
                int choice = scanner.nextInt();
                if (choice == 1){
                    player.playCard();              //plays the card
                }
                else if (choice == 2){
                    attack();
                }
                else if (choice == 3){
                    player.retreat();
                }
                else if (choice == 4){
                    Board();
                }
                else if(choice == 5){
                    System.out.println("\nYour hand has: ");
                    showHand();
                }
                else if(choice == 6){
                    System.out.println("Ending your turn.");
                    turnEnded = true;               //Ends the turn
                }
                else{
                    System.out.println("Not a valid choice. Please try again."); //if given an invalid choice, prompts the user to choose again.
                }
            }
        }

    //Method that shows the current board.
    private void Board(){        
        System.out.println("\n---------- Board ----------");

        PokemonCard activePokemon = player.getActivePokemon();      //Creating a variable to get the active pokemon of the player.

        if(activePokemon != null){                                  //If active pokemon does not equal null
            System.out.println("\nActive Pokemon: " + activePokemon.getName()); //Returns the active Pokemon of the board of the player.
        }
        else{
            System.out.println("\nActive Pokemon: None");
        }

        
        System.out.println("\nBench: ");
        player.showBench();                                         //Returns the bench of the player.
        System.out.println("-------------------------------");
    }

    //Method that shows the hand
    private void showHand(){
        System.out.println("Your hand: ");
        player.showHand();                                          //Shows the players hand.
    }
    //Method that attacks the opponents pokemon.
    public void attack(){
        if(opponent.getActivePokemon() != null){                       //Checks to see if the opponent has an active pokemon.
            player.attack(opponent.getActivePokemon());                //Calls the opponents pokemon and attacks it.
        }
        else{
            System.out.println("Your opponent has no active Pokemon in play.");
        }
    }
}