import java.io.*;
import java.util.ArrayList;

public class DataHandler {

    public ArrayList<Point> loadData(String csvFile) throws IOException {
        ArrayList<Point> data = new ArrayList<>();                              //Creates a new data arraylist

        try (BufferedReader buffer = new BufferedReader(new FileReader(csvFile))) { //Tries to open and read the csvFile
            buffer.readLine();                                                      //Skips the header line in the CSV (x,y)

            String line;
            while ((line = buffer.readLine()) != null) {                        //Keeps reading until there are no lines left
                String[] values = line.split(",");                        //Splits the line by the comma to get x and y
                double x = Double.parseDouble(values[0].trim());                //Converts the first value to x (as a double)
                double y = Double.parseDouble(values[1].trim());                //Converts the second value to y (as a double)
                data.add(new Point(x, y));                                      //Stores the x and y values into the list as a Point
            }
        }

        return data;                                                            //Returns the list of x,y points that were loaded
    }

    public void saveData(ArrayList<Point> points, String outputFile) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile)) {               //Opens the output file try to write to it
            writer.write("x,y\n");                                       //Writes the header as x,y

            for (Point p : points) {                                         //Loops through every point in the list
                writer.write(p.x + "," + p.y + "\n");                        //Writes the x and y value to the CSV file
            }

            System.out.println("Data written to " + outputFile + " successfully.");  //Confirm if the file was written to successfully
        }
    }
}
