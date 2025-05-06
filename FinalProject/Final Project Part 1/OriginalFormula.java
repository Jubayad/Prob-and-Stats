import java.io.IOException;
import java.util.ArrayList;

public class OriginalFormula {
    private DataHandler dataHandler = new DataHandler();          //Create a DataHandler object

    public void quadratic(int lowerBound, int upperBound, String outputFile) {
        ArrayList<Point> points = new ArrayList<>();              //Creates a points array list

        for (int x = lowerBound; x <= upperBound; x++) {          //Loops from the lower bound to the upper bound
            double y = Math.pow(x, 2) - 4 * x + 3;              //Uses the quadratic formula y = x^2 - 4x + 3
            points.add(new Point(x, y));                          //Adds the x and y as a new point to the arraylist
        }

        try {
            dataHandler.saveData(points, outputFile);             //Save all the x and y values to the CSV file
        } catch (IOException e) {
            e.printStackTrace();                                  //Prints error if saving fails, for debugging
        }
    }

    public void sine(int lowerBound, int upperBound, String outputFile) {
        ArrayList<Point> points = new ArrayList<>();              //Creates a points array list

        for (int x = lowerBound; x <= upperBound; x++) {          //Loops from lower bound to upper bound
            double y = -2 * Math.sin(x) + 1;                      //Uses the sine formula y = -2sin(x) + 1
            points.add(new Point(x, y));                          //Adds the x and y as a new point to the list
        }

        try {
            dataHandler.saveData(points, outputFile);             //Save all the x and y values to the CSV file
        } catch (IOException e) {
            e.printStackTrace();                                  //Prints error if saving fails, for debugging
        }
    }

    public void absolute(int lowerBound, int upperBound, String outputFile) {
        ArrayList<Point> points = new ArrayList<>();              //Creates a points array list

        for (int x = lowerBound; x <= upperBound; x++) {          //Loops from lower bound to upper bound
            double y = Math.abs(x) - 2;                           //Uses the absolute value formula y = |x| - 2
            points.add(new Point(x, y));                          //Adds the x and y as a new point to the list
        }

        try {
            dataHandler.saveData(points, outputFile);             //Save all the x and y values to the CSV file
        } catch (IOException e) {
            e.printStackTrace();                                  //Print error if saving fails
        }
    }
}