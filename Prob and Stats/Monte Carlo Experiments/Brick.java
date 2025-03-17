import java.util.ArrayList;
import java.util.Collections;

public class Brick {
    
    public ArrayList<String> deck(int trainerCount) {
        ArrayList<String> deck = new ArrayList<>();           //creating an arraylist that's called deck
        
        int pokemonCount = 26;                                
        int energyCount = 60 - pokemonCount - trainerCount;   //energy cards will always be the amount of cards subtracted by the amount of pokemon cards and trainer cards. Always totaling 60             

        for(int i = 0; i < pokemonCount ; i++){                     
            deck.add("Pokemon");                            //inserting pokemon cards into the deck
        }   

        for(int k = 0; k < trainerCount; k++){                
                deck.add("Rare Candy");                     //inserting trainer cards into the deck
        }
           
        for(int j = 0; j < energyCount; j++){
            deck.add("Energy");                             //inserting energy cards into the deck
        }   
        return deck;                                          //returns the deck
    }

    public double oddsOfBrick(int trainerCount, int userInputNumber){
        int brick = 0;
        
        for(int i = 0; i < userInputNumber; i++){                          //loop that runs depending on what the userinput is
            ArrayList<String> shuffledDeck = new ArrayList<>(deck(trainerCount));
            Collections.shuffle(shuffledDeck);                              //Shuffling the deck and making sure that it's random every time
        
            int pokemonCard = 0;
            int trainerCard = 0;
            int energyCard = 0;

            for(int j = 0; j < 7; j++) {                                    //draw 7 cards into hand
                if(shuffledDeck.get(j).equals("Pokemon")) {        //if there is an pokemon card in your hand, add to pokemonCard count
                    pokemonCard++;
                }
                if(shuffledDeck.get(j).equals("Rare Candy")) {     //if there is an energy card in your hand, add it to trainerCard count
                    trainerCard++;
                }
                if(shuffledDeck.get(j).equals("Energy")) {         //if there is a pokemon card in your hand, add to energyCard count
                    energyCard++;
                }
            }

            int rareCandyInPrizePool = 0; 
            for(int k = 7; k < 13; k++) {                                   //draw 6 more cards for the prize card pool. Starts from the 8th card  
                if(shuffledDeck.get(k).equals("Rare Candy")) {     //if any of the prize pool cards are Rare Candy, brick increases.
                    rareCandyInPrizePool++;
                }
            }

            if(rareCandyInPrizePool > 0){
                brick++;
            }
        }
        return (double) brick / userInputNumber;
    }
}