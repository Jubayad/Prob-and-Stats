public class EnergyCard extends Card implements PlayCard{
    
    String energyType;

    //Making a constructor class
    public EnergyCard(String name, String energyType) {
        super(name);                                    //Calling the superclass constructor to set the name using its superclass.
        this.energyType = energyType;
    }


    public String getEnergyCard(){
        return energyType;
    }

    public void setEnergyType(String energyType){
        this.energyType = energyType;
    }


    @Override
    public void play(){
        System.out.println("Energy card has been attached to the pokemon!");
    }

    @Override
    public String getEffect(){
        return "Adds an energy to the Pokemon";
    }
}
