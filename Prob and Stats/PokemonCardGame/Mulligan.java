import java.util.Collections;

public class Mulligan{

 
    //Makes a class that checks if the starting hand has any pokemon cards. If the player has no pokemon cards, then the hand will be put into the deck, shuffled, and redrawn a new starting hand. This will repeat itself until you have a pokemon card in the starting hand.
    public boolean checkMulligan(Player player, Deck playerDeck){
        boolean hasPokemon = false;                             //Creates a variable thats set to false.

        while(true){                                                //While the following is true.
            
            for(Card card : player.getHand()){                      //Goes through the players hand for every card.
                if (card instanceof PokemonCard){                   //If there's a card that is a Pokemon card.
                    hasPokemon = true;                              //Then the hasPokemon variable becomes true.
                    break;                                          //Breaks out of the while loop if theres a pokemon card.
                }
            }

            if(hasPokemon == true){                                 //If hasPokemon is true
                break;                                              //Breaks the loop since you have a pokemon card in hand.
            }

            System.out.println("Their are no Pokemon cards in your starting hand, Mulligan occured. Cards in hand will be put back in the deck. Reshuffling and redrawing.");

            playerDeck.getDeck().addAll(player.getHand());          //Adds all the current hand cards into the deck.
            
            player.getHand().clear();                               //Clears the players hand.

            Collections.shuffle(playerDeck.getDeck());              //Shuffles the players deck.
        }
        return !hasPokemon;
    }
}



