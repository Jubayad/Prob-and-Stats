import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    
    public static void main(String[] args) {
        
        Birthday birthday = new Birthday();

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(4, 5, 6, 7));

        ArrayList<Integer> unionResult = birthday.union(A, B);
        ArrayList<Integer> intersectResult = birthday.intersect(A, B);
        ArrayList<Integer> complementResult = birthday.complement(A, B);
        

        System.out.println("Union: " + unionResult);
        System.out.println("Intersection: " + intersectResult);
        System.out.println("Complement (A - B): " + complementResult);



        Mulligan mulligan = new Mulligan();
        System.out.println("Pokemon Cards | Mulligan Probability");
        System.out.println("------------------------------------");

        for (int pokemonCount = 1; pokemonCount <= 60; pokemonCount++) {
            double mulliganChance = mulligan.oddsOfMulligan(pokemonCount, 10000) * 100;
            System.out.printf("%13d | %.2f%%%n", pokemonCount, mulliganChance);
        }

 
        Brick brick = new Brick();
        System.out.println("Rare Candy    | Brick(Lose) Probability");
        System.out.println("---------------------------------");

        for (int trainerCard = 1; trainerCard <= 4; trainerCard++) {
            double brickChance = brick.oddsOfBrick(trainerCard, 10000) * 100;
            System.out.printf("%13d | %.2f%%%n", trainerCard, brickChance);
        }

    }
}

