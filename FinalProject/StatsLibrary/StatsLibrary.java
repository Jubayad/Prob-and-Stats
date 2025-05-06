package StatsLibrary;

public class StatsLibrary {

    //Computes the factorial of a number
    public double getFactorial(int number) {
        if (number < 0) return 0;                                             //Returns 0 if number is less than 0
        if (number <= 1) return 1;                                            //Returns 1 for any number greater than or equal to 1

        double product = 1;                                                   //Creates a product variable
        for (int val = 2; val <= number; val++) {                             //Loops from 2 to number
            product *= val;                                                   //Multiplies the result by the current value
        }
        return product;                                                       //Returns the final factorial value
    }

    //Calculates the Poisson probability
    public double poissonProbability(double averageRate, int numEvents) {
        double numerator = Math.pow(averageRate, numEvents) * Math.exp(-averageRate);   //Computes the numerator: λ^k * e^(-λ)
        double denominator = getFactorial(numEvents);                                   //Computes the denominator: k!
        return numerator / denominator;                                                 //Returns the division of the numerator and denominator
    }

    //Calculates the minimum probability from Chebyshev's
    public double chebyshevBound(double distanceInStdDevs) {
        double kSquared = distanceInStdDevs * distanceInStdDevs;              //Squares the number of standard deviations
        return 1.0 - (1.0 / kSquared);                                        //Returns Chebyshev bound: 1 - 1/k^2
    }

    //Finds the uniform distribution PDF
    public static double uniformDensity(double value, double start, double end) {
        boolean insideRange = value >= start && value <= end;                          //Checks if value is between start and end
        if (insideRange) {
            double midPoint = (start + end) / 2.0;                                      //Creates a variable midpoint that calculates the mean
            double spread = (end - start) * (end - start) / 12.0;                       //Creates a variable spread that calculates the variance

            System.out.println("Mean: " + midPoint);                                    //Prints the mean
            System.out.println("Variance: " + spread);                                  //Prints the variance

            return 1.0 / (end - start);                                                 //Returns the uniform PDF
        }

        return 0.0;                                                                     //Return 0 if value is outside of the range
}


    //Finds the normal distribution PDF
    public static double normalDensity(double input, double average, double stdDev) {
 
        double difference = input - average;                                           //Creates a variable difference that calculates the difference between the input and the average
        double expPower = -(difference * difference) / (2 * stdDev * stdDev);          //Computes exponent
        double scaleFactor = 1.0 / (stdDev * Math.sqrt(2 * Math.PI));                  //Compute coefficient

        return scaleFactor * Math.exp(expPower);                                       //Return normal PDF
    }
}
