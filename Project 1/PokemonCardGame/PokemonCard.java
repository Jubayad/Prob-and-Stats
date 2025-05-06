import java.util.ArrayList;


public class PokemonCard extends Card implements PlayCard{

    private String name;
    private int hp;
    private int maxHp;
    private int attackDamage;
    private String type;
    private String weakness;
    private int retreatCost;
    private String resistance;
    private String attackName;
    private ArrayList<EnergyCard> attachedEnergy = new ArrayList<>();  //Creating a variable array list that keeps the energy cards attached to a Pokemon.


    //Making a construtor to initialize the pokemon card
    public PokemonCard(String name, int hp, int attackDamage, int retreatCost, String weakness, String attackName) {
        super(name);                                                                    //Calling the superclass constructor to set the name using its superclass.
        this.hp = hp;
        this.maxHp = hp;
        this.attackDamage = attackDamage;
        this.retreatCost = retreatCost;
        this.weakness = weakness;
        this.attackName = attackName;
    }

    public void attack(PokemonCard target){
        if(attachedEnergy.size() >= 1){                                                 //If the pokemon has 1 or more energy attached to it.
            System.out.println(this.name + "used " + this.attackName + "!");
            target.takeDamage(this.attackDamage);
        }
        else{
            System.out.println(this.name + "doesn't have enough energy to attack.");
        }
    }

    //Method that calculates the damage to a Pokemon
    public void takeDamage(int damage){
        this.hp -= damage;                          //Subtracts damage from hp.

        if(this.hp < 0){                            //Prevents hp from being a negative number.
            this.hp = 0;                            //Sets hp to 0 if goes below 0.
        }

        System.out.println(this.name + "took " + damage + " damage! Remaining HP: " + this.hp); //Prints out stating who took damage and how much hp is left.
    }

   
    //Creating a method where we override and use this method if we are calling the play method that's a Pokemon card.
    @Override
    public void play(){
        System.out.println(this.getName() + " pokemon has been put into play");     //prints out an output of the pokemons name and that it has been put into play.
    }

    //Creating a method that shows the list of attacks a pokemon cards has
    @Override
    public String getEffect(){
        return this.getName() + " pokemon can attack with " + this.getAttackName();
    }

    //Creating a method that attaches an energy card.
    public void attachEnergy(EnergyCard energyCard){
        attachedEnergy.add(energyCard);
    }

    public  ArrayList<EnergyCard> getAttachedEnergy(){
        return attachedEnergy;
    }

    //Method that removes the amount of energy based on an inputted integer.
    public void removeEnergy(int amount){
        for(int i = 0; i < amount; i++){
            if(!attachedEnergy.isEmpty()){
                attachedEnergy.remove(0);
            }
        }
    }



        public int getHp(){
            return hp;
        }

        public int getMaxHp(){
            return maxHp;
        }

        public int getAttackDamage(){
            return attackDamage;
        }

        public String getType(){
            return type;
        }
        
        public String getWeakness(){
            return weakness;
        }

        public int getRetreatCost(){
            return retreatCost;
        }

        public String getResistance(){
            return resistance;
        }

        public String getAttackName(){
            return attackName;
        }

        public void setHp(int userHp){
            if(userHp < 0){
                this.hp = 0;                         //removes the need to deal with negative hp
            }
            else if(userHp > maxHp){
                this.hp = maxHp;                     //prevents hp from going over max hp
            }
            else{
                this.hp = userHp;
            }
        }

        public void setAttackDamage(int userAttackDamage){
            this.attackDamage = userAttackDamage;
        }

        public void setType(String userType){
            this.type = userType;
        }

        public void setWeakness(String userWeakness){
            this.weakness = userWeakness;
        }
        
        public void setRetreatCost(int userRetreatCost){
            this.retreatCost = userRetreatCost;
        }

        public void setResistance(String userResistance){
            this.resistance = userResistance;
        }

        public void setAttackName(String userAttackName){
            this.attackName = userAttackName;
        }
}
