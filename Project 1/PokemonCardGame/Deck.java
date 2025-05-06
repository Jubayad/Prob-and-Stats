import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    ArrayList<Card> deck = new ArrayList<>();                 //creating an arraylist that's called deck which is the deck of cards.

    //Initializing the deck with the three different kind of cards. Pokemon, trainer, and energy cards.
    public Deck(int pokemonCount, int trainerCount) {
        
        deck = new ArrayList<>();                             //creating an arraylist that's called deck
        int energyCount = 60 - pokemonCount - trainerCount;   //energy cards will always be the amount of cards subtracted by the amount of pokemon cards and trainer cards. Always totaling 60             
        
        while(energyCount + pokemonCount + trainerCount > 60){//if the amount of cards ever exceed 60, 
            energyCount--;                                    //subtract energycards until it becomes 60
        }
        
            addFourPokemonCards(pokemonCount);                //Add the amount of Pokemon cards depending on the Pokemon count

            addFourTrainerCards(trainerCount);                //Add the amount of Pokemon cards depending on the trainer count
           
        for(int j = 0; j < energyCount; j++){
            deck.add(new EnergyCard("Energy", "Normal")); //inserting energy cards into the deck, all normal type.
        }   
        Collections.shuffle(deck);                            //returns deck that is shuffled upon creation
}

    //Method to add only 4 of a kind of a Pokemon while also keeping the total number to match the Pokemon count.
    public void addFourPokemonCards(int pokemonCount){

        int count = 0;                                        //Variable to keep count

        for(int i = 0; i < 4 && count < pokemonCount; i++){   //For loop that loops 4 times and also less the then the total pokemon count.
            deck.add(new Pikachu());                          //Adding Pikachu into the deck only 4 times
            count++;                                          //Increasing count so that we have total number of pokemon cards in the deck.
        }

        for(int i = 0; i < 4 && count < pokemonCount; i++){ 
            deck.add(new Squirtle());
            count++;                                          
        }

        for(int i = 0; i < 4 && count < pokemonCount; i++){ 
            deck.add(new Bulbasaur());
            count++;                                          
        }

        for(int i = 0; i < 4 && count < pokemonCount; i++){ 
            deck.add(new Charmander());
            count++;                                          
        }

        for(int i = 0; i < 4 && count < pokemonCount; i++){ 
            deck.add(new Caterpie());
            count++;                                          
        }
    }

    //Method to add only 4 of a kind of a trainer while also keeping the total number to match the trainer count.
    public void addFourTrainerCards(int trainerCount){

        int count = 0;                                        //Variable to keep count

        for(int i = 0; i < 4 && count < trainerCount; i++){   //For loop that loops 4 times and also less the then the total trainer count.
            deck.add(new Potion());                           //Adding potion into the deck only 4 times
            count++;                                          //Increasing count so that we have total number of trainer cards in the deck.
        }                                       
    }


        //If you have cards remaining in the deck, you will draw the card that's on the top. It removes the following card and adds the card to hand. It takes from the deck and adds to the player's hand.
        public Card drawCard(ArrayList<Card> hand){
            if(deck.isEmpty()){                                                      //if there are no cards in the deck.
                System.out.println("There are no remaining cards in your deck.");  //Return statement saying you have no cards remaining.
                return null;                                                         //If deck is empty return null.
            }

            if(hand == null){                                                        //If hand has a null error case
                System.out.println("null");                             
                return null;                                                         //Return null.
            }
            
            Card drawACard = deck.remove(deck.size() - 1);                           //Creates a variable where it removes the top card of the deck
            hand.add(drawACard);                                                     //Adds the card into the hand
            return drawACard;                                                        //Returns the drawn card.
        }

    //Method that returns the deck.
    public ArrayList<Card> getDeck(){
        return deck;
    }

    //Method that returns the size of the deck.
    public int size(){
        return deck.size();
    }

    //Creates a method that shuffles the deck.
    public void shuffle(){
        Collections.shuffle(deck);                                               //Shuffles the deck.
    }
}
