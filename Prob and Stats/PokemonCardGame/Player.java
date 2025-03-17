import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Deck{
    
    private ArrayList<Card> hand;                         //The player's hand of cards
    private ArrayList<Card> active = new ArrayList<>();   //Creating an active arraylist to hold the pokemon in the active slot.
    private ArrayList<Card> bench = new ArrayList<>();    //Creating a bench arraylist to hold the pokemon in the bench slots.
    private ArrayList<Card> discardPile = new ArrayList<>(); //Creating a discard pile arraylist to hold pokemon that have been knocked out.
    private ArrayList<Card> prizeCardsArray = new ArrayList<>();  //Creating a prize cards arraylist to hold the prize cards of a player. 
    private int prizeCardsDrawn = 0;                         //Creating a variable that keeps track of how many prize cards have been drawn.

    public Player(){
        super(20, 12);          //Calling the deck constructer with preset values
        hand = new ArrayList<>();                         //Initializing the hand of player
    }

    //Method that sets up the beginning of the game (draw cards, check mulligan, and draw prize cards)
    public void startingGame(Deck deck, Mulligan mulligan){ 
        
        startingHand(deck, mulligan);                     //Draws starting hand and also check if a mulligan occurs.
        drawPrizeCards(deck);                             //Draws prize cards.
    }


    //The purpose of this method is to call this when starting the game and giving the player's their starting deck
    public void startingHand(Deck deck, Mulligan mulligan){
        boolean hasPokemonCard = false;                             //Creates a variable thats set to false to check if theirs a Pokemon card.

        while(!hasPokemonCard) {                                    //While there's no pokemon card
            for(int i = 0; i < 7; i++){                             //loops through 7 times.
                Card drawnCard = deck.drawCard(hand);               //Creating a variable where drawn card equals adding the drawn card into the hand.
                
                if(drawnCard != null){                              //Handling null case.
                    System.out.println("You have drawn: " + drawnCard.getName()); //Printing our the cards drawn
                }
                else{
                    System.out.println("No more cards in the deck.");
                }
            }
    
            hasPokemonCard = !mulligan.checkMulligan(this, deck);   //Checks for mulligan using the mulligan method.
        }
    }
    
    //Method that draws the prize cards after the players starting hand has been drawn.
    public void drawPrizeCards(Deck deck){
        for(int i = 0; i < 6; i++){                                     //Loops 6 times.
            
            Card drawnCard = deck.drawCard(hand);                       //Creates a variable of drawing a card.
            prizeCardsArray.add(drawnCard);                             //Adds the prize card into the prize pool from the deck.
        }
    }
    
    //The purpose of this method is to call this and show the player's current hand and what it contains
    public void showHand(){
        System.out.println("Your hand has: ");
        for(int i = 0; i < hand.size(); i++){                               //loops through depending on the size of your hand
            System.out.println((i+1) + ". " + hand.get(i).getName());       //prints out the name of each card in your hand
        }
    }

    //Returns the hand of the player.
    public ArrayList<Card> getHand(){
        return hand;
    }

    public void attack(PokemonCard opponentActivePokemon){
        if(active.isEmpty()){                                                 //If theres no pokemon in the active slot
            System.out.println("No active Pokemon in play.");               //Prints a statement saying theres no active pokemon.
            return;
        }

        PokemonCard activePokemon = (PokemonCard) active.get(0);        //Creates a variable that gets the active pokemon from the active Arraylist.
        activePokemon.attack(opponentActivePokemon);                          //Attacking the opponents active pokemon.

        if(opponentActivePokemon.getHp() <= 0){
            System.out.println(opponentActivePokemon.getName() + " has been knocked out!");
            addToDiscardPile(opponentActivePokemon);                          //The knocked out Pokemon will be sent to the discard pile.
        }

        if(!prizeCardsArray.isEmpty()){
            Card prizeCard = prizeCardsArray.remove(0);                 //Creating a variable that removes the top prize card from the arraylist.
            hand.add(prizeCard);                                              //Adds the following prize card into the players hand.
            System.out.println("You have drawn the prize card:  " + prizeCard.getName());
            prizeCardsDrawn++;                                                //Increasing the increament for amount of prize cards drawn.

            if(prizeCardsDrawn >= 3){                                         //If you have drawn 3 or more prize cards
                System.out.println("You have drawn 3 prize cards by knocking out 3 of your opponents pokemon. You have won the game!"); //Prints a statement saying the player has won.
                System.exit(0);                                        //Ends the game since you have won.
            }
            
            else{
                System.out.println("No more prize cards remaining.");
            }
        }
    }

    //Method that returns the current active pokemon
    public PokemonCard getActivePokemon(){
        if(!active.isEmpty()){                                                 //If the active slot is not empty.
            return (PokemonCard) active.get(0);                          //Return the active pokemon in the active arraylist.
        }

        return null;
    }

    //Method that takes pokemon that are knocked out and send them to the discard pile.
    public void addToDiscardPile(Card card){
        discardPile.add(card);                                                           //Adding the card into the discard pile arraylist
        System.out.println(card.getName() + " has been sent to the discard pile.");
    }

    //Method that allows for an active pokemon to retreat and be moved to the bench if they have the corresponding amount of energy attached.
    public void retreat(){
        Scanner askUser = new Scanner(System.in);                                         //Creating a scanner variable
        
        if(active.isEmpty()){                                                             //If there aren't any pokemon in the active slot
            System.out.println("You don't have an active pokemon.");                    //Prints a statement saying you don't have any pokmeon in the active slot.
            return;                                                                       
        }

        if(bench.isEmpty()){
            System.out.println("You don't have any other bench Pokemon to play into active. Cannot retreat");
            return;
        }

        PokemonCard activePokemon = (PokemonCard) active.get(0);                    //Creates a variable that gets the active pokemon.
        int retreatCost = activePokemon.getRetreatCost();                                 //Creates a variable that gets the active pokemon retreat cost.
    
        if(activePokemon.getAttachedEnergy().size() < retreatCost){                       //If the active Pokemon has less than the amount neccessary to retreat.
            System.out.println("Cannot retreat. " + activePokemon.getName() + " needs " + retreatCost + "energy to retreat.");
            return;
        }
        
        showBench();                                                                      //Shows all pokemon in the bench

        System.out.println("Choose a pokemon to switch from the bench to active (Number): ");   //Asking user what pokemon they want to switch with
        int choice = askUser.nextInt() - 1;                                                       //Making a choice variable that tracks user input number.

        if(choice < 0 || choice >= bench.size()){                                                 //If user's choice is out of range  
            System.out.println("Not a valid number. Retreat failed.");                          //Retreat fails
            return;
        }

        Card swapPokmeon = bench.get(choice);                                             //Creating a variable of the users pokemon choice.

        bench.add(activePokemon);                                                         //Adds the active pokemon to the bench array.
        active.remove(0);                                                            //Removes the active pokemon from the arraylist.

        activePokemon.removeEnergy(retreatCost);                                          //Remove the amount of energy depending on the retreat cost.
        System.out.println("The pokemon: " + activePokemon.getName() + " has retreated and moved to the bench.");
        System.out.println(swapPokmeon.getName() + " has been moved to the active slot.");
    }

    //Method that shows whats on the bench.
    public void showBench(){
        if(bench.isEmpty()){                                                              //If bench is empty.
            System.out.println("Your bench is empty.");
        }

        else{
            System.out.println("Your bench contains: ");
            for(int i = 0; i < bench.size(); i++){                                        //Loops through the bench based on its size
                System.out.println((i + 1) + ". " + bench.get(i).getName());              //Prints out the number of place the pokmeon is on the bench along with its name.
            }
        }
    }


    

    //The purpose of this method in which it uses the card that the user wants.
    public void playCard(){
        Scanner askUser = new Scanner(System.in);                               //Creating a askUser variable that takes in what User types to the System.

        System.out.println("Play a card from your hand(Insert numbers): ");   //asking the player to pick which card to play from hand
        int decision = askUser.nextInt() - 1;                                   //creating a decision variable that keeps track of what number the user picked. Subtracting 1 from it to keep it index based counting.

        if(decision >= 0 && decision < hand.size()){                            //Checking to make sure that the user inputted a non-negative number and a number that isn't greater than the size of the hand.
            Card selectedCard = hand.remove(decision);                          //Creating variable that removes the card chosen to be used from the hand.
            System.out.println("You've played " + selectedCard.getName());      //Outputting message stating the selected card has been played.

        
            if(selectedCard instanceof PokemonCard){                            //If the card that's selected is a pokemon card
                pokemonCardLogic((PokemonCard) selectedCard);                   //Call upon the method to invoke the logic
            }
            else if(selectedCard instanceof TrainerCard){                       //If the card that's selected is a trainer card
                trainerCardLogic((TrainerCard) selectedCard);                   //Call upon the method to invoke the logic
            }
            else if(selectedCard instanceof EnergyCard){                        //If the card that's selected is a trainer card
                energyCardLogic((EnergyCard) selectedCard);                     //Call upon the method to invoke the logic
            }
            
            else{
                System.out.println("Card can't be used here.");               //If invalid choice is made, card won't be played
                hand.add(selectedCard);                                         //Add's the card back to the hand
            }
    }
        else{
            System.out.println("Not a valid choice. Try again.");             //If user gives anything besides the appropriate numbers, will be prompted to try again.
        }
}

    //This method provides the logic in how a Pokemon card would interact with the field alongside energy cards being attached to it and trainer cards being effected by it.
    public void pokemonCardLogic(PokemonCard pokemonCard){
        Scanner askUser = new Scanner(System.in);                               //Creating a askUser variable that takes in what User types to the System.

        System.out.println("Where would you like to play your " + pokemonCard.getName() + "?"); //Asking user where they would like to put their pokemon in
        System.out.println("1. Active");                //Asking if user wants to play pokemon in active slot
        System.out.println("2. Bench");                 //Asking if user wants to play pokemon in bench slot

        int choice = askUser.nextInt();                   //Creating variable to keep track of users choice

        if(choice == 1){                                  //If users choice is 1 (active slot)
            System.out.println(pokemonCard.getName() + " has been placed to the active"); //Prints out a statement saying pokemons name has been added to active slot.
            active.add(pokemonCard);                                                      //Adds the pokemon to the active arraylist.
        }
        else if(choice == 2){
            if(bench.size() < 5){                                                             //Checks if you currently have less than 5 pokemon in the bench
                System.out.println(pokemonCard.getName() + " has been placed on the bench");  //Prints out a statement saying pokemons name has been added to bench.
                bench.add(pokemonCard);                                                       //Adds the pokemon to the bench arraylist.
            }
            else{
                System.out.println("You can't add any more pokemon to bench. It already has 5 pokemon.");   //Returns statement saying bench is full
                hand.add(pokemonCard);                                                                        //Add's removed card back to hand.
                for(int i=0; i < bench.size(); i++){                                                          //loops through the bench
                    System.out.println("You have " + bench.get(i).getName());                                 //displays all Pokemon currently in the filled bench
                }
            }
        }
        else{
            System.out.println("Not a possible choice. The card hasn't been played.");                      //If invalid choice was given, the card won't be played.
            hand.add(pokemonCard);                                                                            //Removed card is returned back to hand.
        }
    }
    //This method provides the logic in how trainer cards interract with the field. Whether they are activated onto a pokemon or just onto the field
    public void trainerCardLogic(TrainerCard trainerCard){
        trainerCard.play();                                     
        System.out.println(trainerCard.getEffect());
    }

    //This method provides the logic in how the energy cards will be added to the pokmeon card. 
    public void energyCardLogic(EnergyCard energyCard){
        Scanner askUser = new Scanner(System.in);                               //Creating a askUser variable that takes in what User types to the System.


        if(bench.isEmpty() && active.isEmpty()){                    //If either the bench or active is empty, you can't put an energy card anywhere
            hand.add(energyCard);                                   //Returning the energy card back to the hand.
            System.out.println("There are no Pokemon to attach the energy to.");
            return;
        }

        System.out.println("Who would you like to attach the energy to?");  //Asking user who to attach energy to.
        System.out.println("1. Active Pokemon");                            //Option of choosing active Pokemon to attach the energy to.
        for(int i = 0; i < bench.size(); i++){                                //Looping through the size of the bench
            System.out.println((i + 2) + ". " + bench.get(i).getName());      //Showing all Pokemon in the bench and allowing user to choose
        }

        int decision = askUser.nextInt() - 1;                                 //Creating a decision variable that keeps track of what number the user picked. Subtracting 1 from it to keep it index based counting.

        if(decision == 0){                                                    //If user chooses to attach to active pokemon.
            if(!active.isEmpty()){                                            //If active slot is not empty
                PokemonCard activePokemonCard = (PokemonCard) active.get(0); //Creating a variable to represent the active pokemon in the array list which is index 0
                activePokemonCard.attachEnergy(energyCard);                   //Attaching energy card to active Pokemon
                System.out.println("Energy card has been attached to active Pokemon: " + activePokemonCard.getName()); //Outputting statement of who the energy card has been attached to in the active slot
            }
            else{                                                                 //If there isn't any active Pokemon.
                System.out.println("No active Pokemon to add energy card to."); //Prints a statement saying there isn't any active pokmeon to attach the energy card to.
                hand.add(energyCard);                                             //Returning energy card back to hand since it wasn't added
            }
        }

        else if(decision > 0 && decision <= bench.size()){                        //If the number that the user picks is within the range of the bench size.
            PokemonCard benchPokemonCard = (PokemonCard) bench.get(decision - 1); //Creating a variable that refers to the benched Pokemon depending on the choice of the user.
            benchPokemonCard.attachEnergy(energyCard);                            //Attaching energy card to the benched Pokemon.
            System.out.println("Energy card has been attached to benched Pokemon: " + benchPokemonCard.getName()); //Outputting statement of who the energy card has been attached to in the benched slot.
        }

        else{
            System.out.println("Not a valid choice, energy card wasn't played"); //If invalid choice, the card won't be played.
            hand.add(energyCard);                                                  //Returns the energy card back to the hand.
        }
    }
}

