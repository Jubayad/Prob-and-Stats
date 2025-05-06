import java.io.IOException;                                         
import java.util.ArrayList;                                         
import java.util.Random;                                            

public class Salter {
    private Random rand = new Random();                                     // Create a random variable 
    private DataHandler dataHandler = new DataHandler();                    // Create a DataHandler object

    public void dataSalter(String inputFile, String outputFile, double saltBound) {
        if (saltBound <= 0) {                                               // If salt bound is not valid
            System.out.println("Salt bound must be greater than 0");
            return;                                                         // Stop the function
        }

        try {
            ArrayList<Point> points = dataHandler.loadData(inputFile);      // Load the x,y data from input CSV into points

            ArrayList<Point> saltedPoints = new ArrayList<>();              // Store    the salted x,y values
            for (Point p : points) {                                        // Loop through each point
                double salt = rand.nextDouble() * 2 * saltBound - saltBound;// Generate a random number between -saltBound and +saltBound
                saltedPoints.add(new Point(p.x, p.y + salt));               // Add the salt to the y value
            }

            dataHandler.saveData(saltedPoints, outputFile);                 // Save the salted data to a new CSV file

        } catch (IOException e) {                                           // If something goes wrong with file handling
            e.printStackTrace();                                            // Print the error
        }
    }
}
