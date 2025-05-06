public class Potion extends TrainerCard{
    
    public Potion(){
        super("Potion", "item", "Heal 30 damage from 1 Pokemon.");
    }

    public void usePotion(PokemonCard pokemon){
        int newHp = pokemon.getHp() + 30;

        if(newHp > pokemon.getMaxHp()){
            newHp = pokemon.getMaxHp();             //prevents potion from overhealing the max hp limit
        }

        pokemon.setHp(newHp);

        System.out.println(pokemon.getName() + " has been healed for 30 points! New HP: " + pokemon.getHp());
    }
}
