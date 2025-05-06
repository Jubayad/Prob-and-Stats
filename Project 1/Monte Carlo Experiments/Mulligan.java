import java.util.ArrayList;
import java.util.Collections;

public class Mulligan{

    public ArrayList<String> deck(int pokemonCount, int trainerCount) {
        ArrayList<String> deck = new ArrayList<>();           //creating an arraylist that's called deck
        
        int energyCount = 60 - pokemonCount - trainerCount;   //energy count will always be the remaining amount of cards left after subtracting from pokemon cards

        for(int j = 0; j < energyCount; j++){
                deck.add("Energy");                         //inserting energy cards into the deck, totaling 60
            }
        
        for(int i = 0; i < trainerCount; i++){                
        }
        
        for(int i = 0; i < pokemonCount ; i++){                     
                deck.add("Pokemon");                        //adding pokemon cards into the deck replacing energy cards but keeping total cards to be 60 total
            }

        return deck;                                          //returns the deck
    }

    public double oddsOfMulligan(int pokemonCount, int userInputNumbers){
        int mulligan = 0;
        int trainerCount = 15;

        for(int i = 0; i < userInputNumbers; i++){                                   //loop that runs depending on what the userinput is
            ArrayList<String> shuffledDeck = new ArrayList<>(deck(pokemonCount, trainerCount));
            Collections.shuffle(shuffledDeck);                                       //Shuffling the deck and making sure that it's random every time
        
            int pokemonCard = 0;

            for(int j = 0; j < 7; j++) {                                              //draw 7 cards
                if(shuffledDeck.get(j).equals("Pokemon")) {                  //if there is a pokemon card in your hand, add to pokemonCard count
                    pokemonCard++;
                }
            }

            if(pokemonCard == 0){                                                    //if there is no pokemon card, mulligen count increases
                mulligan++;
            }
        }
        return (double) mulligan / userInputNumbers;
    }
}