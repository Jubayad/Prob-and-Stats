import java.util.Random;

public class Doors{

    public String[] door(){
        String door[] = {"good", "bad", "bad"};                  //creating an array with the three options
        return door;
    }

    public double notChangeDoor(int userInputNumbers){
        Random random = new Random();                            //creating random function
        int win = 0;
        int lose = 0;

        for(int i=0; i < userInputNumbers; i++){
            int randomDoor = random.nextInt(3);            //choose one of the 3 doors randomly
            if(randomDoor == 0){                                 //if they picked the right door, they win and adds to counter
                win++;
            }
            else if(randomDoor == 1 || randomDoor == 2){         //if they chose either of the bad doors, they lose and adds to counter
                lose++;
            }
        }
        double ratio = (double) win / lose;                      //give the ratio of win to lose.
        return ratio;
        }
            
        public double changeDoor(int userInputNumbers){
            Random random = new Random();                            //creating random function
            int win = 0;
            int lose = 0;

            for(int i=0; i < userInputNumbers; i++){
                int randomPick = random.nextInt(3);            //choose one of the 3 doors randomly

                if(randomPick == 1){                                 //if they picked the right door, they win and adds to counter
                    win++;
                }
                else if(randomPick == 2 || randomPick == 3){         //if they chose either of the bad doors, they lose and adds to counter
                    if (randomPick == 2){
                        int randomPick2 = random.nextInt(door().length);
                        if(randomPick2 == 3){
                            lose++;
                        }
                        if(randomPick2 == 1){}
                    }
                    lose++;
                }
            }

            double ratio = (double) win / lose;
            return ratio;
    }
}