public class Stadium {
    
    public void battle(Pokemon Pika, Pokemon Charmander){
        //normally check speed first

        int PikaHp = Pika.getHp();
        int CharmanderHp = Charmander.getHp();
        
        while(Pika.getHp() >= 0 && Charmander.getHp() >= 0) {
            if(Pika.getSpeed() > Charmander.getSpeed()){
                    CharmanderHp = Charmander.getHp() - Pika.getAttack();

                    if(PikaHp <= 0){
                        System.out.println("Pikachu has fainted");
                    }
                    if(CharmanderHp <= 0){
                        System.out.println("Charmander has fainted");
                        break;
                    }
                
            else if(Charmander.getSpeed() > Pika.getSpeed()){
                
                    PikaHp = Pika.getHp() - Charmander.getAttack();
                    
                    if(PikaHp <= 0){
                        System.out.println("Pikachu has fainted");
                    }
                    if(CharmanderHp <= 0){
                        System.out.println("Charmander has fainted");
                        break;
                    }
            }
    }
}
        //Put this in a loop until one is knocked out.

        //p1 attacks p2 //Battle math subtract from hp the difference of attack and defense

        //Check other pokemon if hp over 0;

        //p2 attacks p1
}
}