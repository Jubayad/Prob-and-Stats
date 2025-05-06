import java.io.IOException;
import java.util.ArrayList;

public class Smoother {
    private DataHandler dataHandler = new DataHandler();                   //Create a DataHandler object

    public void dataSmoother(String inputFile, String outputFile, int windowSize) {
        try {
            ArrayList<Point> points = dataHandler.loadData(inputFile);     //Loads the x and y values from the file

            ArrayList<Point> smoothedPoints = new ArrayList<>();           //Creates a new arraylist called smoothpoints

            for (int i = 0; i < points.size(); i++) {                      //For loop that goes through depending on how many points in the file there are
                double sum = 0;                                            //Sum variable
                int count = 0;                                             //Count variable

                int start = Math.max(0, i - windowSize);                 //Finds the starting y value by subrating it from the window size
                int end = Math.min(points.size() - 1, i + windowSize);     //Finds the end values by adding it to the window size

                for (int j = start; j <= end; j++) {                      //Loop through from the start to the end
                    sum += points.get(j).y;                               //Adds the y value to the sum
                    count++;                                              //Increase the count increment
                }

                double avgY = sum / count;                                //avgY variable which finds the sum divided by count.
                smoothedPoints.add(new Point(points.get(i).x, avgY));     //Adds the new smoothed point into the arraylist
            }

            dataHandler.saveData(smoothedPoints, outputFile);             //Saves the x and y smoothed data to a CSV file

        } catch (IOException e) {                                         //If something goes wrong, shows error
            e.printStackTrace();                                          //Print error for debugging
        }
    }
}
