public class TrainerCard extends Card implements PlayCard {
    
    private String type;
    private String effect;


    //Making a construtor to initialize the trainercard
    public TrainerCard(String name, String type, String effect) {
        super(name);                                            //Calling the superclass constructor to set the name using its superclass.
        this.type = type;
        this.effect = effect;
    }

    @Override
    public void play(){
        System.out.println("You are using the " + this.getName() + "this does: " + this.getEffect());
    }



    public String getType(){
        return type;
    }
    
    public String getEffect(){
        return effect;
    }

    public void setType(String userType){
        this.type = userType;
    }

    public void setEffect(String userEffect){
        this.effect = userEffect;
    }
}
