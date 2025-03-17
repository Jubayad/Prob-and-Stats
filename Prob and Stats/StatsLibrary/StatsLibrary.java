
import java.math.BigInteger;
import java.util.List;



public class StatsLibrary{

    public double getMean(int[] userInputNumbers){
        int total = 0;
        for(int singleNumber: userInputNumbers){                  //loop through the list
            total = total + singleNumber;                         //getting the total value
        }
        double result = (double) total / userInputNumbers.length; //dividing total by the amount
        return result;
    }


    public double getMedian(int[] userInputNumbers) {
        boolean swap;

        for(int i = 0; i < userInputNumbers.length - 1; i++){           //bubble sort algorithm
            swap = false;
            for (int j = 0; j < userInputNumbers.length - i - 1; j++){  //loops through all values of the array - 1 - the amount of loops
                if(userInputNumbers[j] > userInputNumbers[j+1]) {       //if first value is greater then second
                    int temp = userInputNumbers[j];                     //temp variable to hold j
                    userInputNumbers[j] = userInputNumbers[j+1];        //j swaps with next value
                    userInputNumbers[j+1] = temp;                       //swapped value becomes the temp value
                    swap = true;
                }
            }
            if (!swap){                                                //if there were no swap, sort is complete and we break out of loop
                break;
            }
            }
        if (userInputNumbers.length % 2 == 0){                         //if it's an even amount, divide the two numbers and get the average
            return(userInputNumbers[userInputNumbers.length / 2 - 1] + userInputNumbers[userInputNumbers.length / 2]) / 2.0; //gives the sum of the two middle numbers and gives the average between them
        }
        else{
            return userInputNumbers[userInputNumbers.length / 2];      //if it's odd amount, return the middle number
        }
    }


    public double getMode(int[] userInputNumbers){
        int mode = userInputNumbers[0];
        int max = 0;
        for(int i = 0; i < userInputNumbers.length; i++){         //loop through the array
            int count = 0;                                        //create a count variable
            for(int j = 0; j < userInputNumbers.length-1; j++){   //loop through the array for a specific value
                if(userInputNumbers[i] == userInputNumbers[j]){   //if array value matches a certain value from array
                    count++;                                      //if amount matches than count increases
                }
            }
            if(count > max){                                  //if theres more of a certain value
                max = count;                                  //max value is updated depending on what is the max amount
                mode = userInputNumbers[i];                   //mode becomes the new number
            }
        }
        return mode;
    }
    

    public double getStandardDeviation(int[] userInputNumbers){
        double sum = 0;
        double mean = getMean(userInputNumbers);                      //create a mean variable
                          
        for(int i=0; i < userInputNumbers.length; i++){               //loop through the list
            double subtractedValue = userInputNumbers[i] - mean;      //subtract the value with the mean
            double squaredValue = subtractedValue * subtractedValue;  //square the value
            sum += squaredValue;                                      //adds all the values
        }

        double sumValue = sum / userInputNumbers.length;              //divide the sum with the amount of numbers in the list
        
        double standardDeviation = Math.sqrt(sumValue);               //square root the sum to get standard deviation
        return standardDeviation;
    }


    public double getVariance(int[] userInputNumber){
        double number = getStandardDeviation(userInputNumber);       //finding the standard deviation of the numbers.

        double variance = Math.pow(number, 2);                     //variable variance is equal to squaring the standard deviation.
        return variance;                                             //returns the variable variance.
    }


    public BigInteger getFactorial(int n){
        BigInteger result = BigInteger.ONE;                         
        for (int i = 2; i <= n; i++) {                              //Start the loop from 2 since 1! is equal to 1 so we skip that. 
            result = result.multiply(BigInteger.valueOf(i));        //Multiplying each factorial value by each other.
        }
        return result;                                              //Returns the factorial value.
    }


    public BigInteger getPermutation(int n, int m){
        return getFactorial(n).divide(getFactorial(n - m));         //Returns the result of dividing the factorial of n by the factorial of n - m
    }

    
    public BigInteger getCombination(int n, int m){
        BigInteger result = getFactorial(m).multiply(getFactorial(n - m)); //Result equals m! times (n-m)!
        return getFactorial(n).divide(result);                             //Returns n! divided by the result variable
    }

    
    public boolean independentIntersection(List<Integer> I, List<Integer> J){
        for(int m : I){                                                    //Loop through all values of list I
            if(J.contains(m)){                                             //If list b contains the value m.
                return false;                                              //Return false if theres a value that both lists share.
            }
        }
        return true;                                                       //Return true otherwise.
    }


    public boolean dependantIntersection(List<Integer> I, List<Integer> J){
        for(int m : I){                                                    //Loop through all values of list I
            if(J.contains(m)){                                             //If list b contains the value m.
                return true;                                               //Return true if theres a value that both lists share.
            }
        }
        return false; 
    }


    public boolean exclusiveUnion(List<Integer> I, List<Integer> J){
        return independentIntersection(I, J);                              //Checking for if there are any unique elements.
    }


    public boolean inclusiveUnion(List<Integer> I, List<Integer> J){
        return dependantIntersection(I, J);                                //Checking for any of the same elements. 
    }


    public double findProbabiltyA(int I, int SampleSize){                  
        return (double) I / SampleSize;                                             //Returns the favorable outcomes divided by the sample size.
    }


    public double findProbabiltyB(int J, int SampleSize){
        return (double) J / SampleSize;                                             //Returns the favorable outcomes divided by the sample size.
    }


    public double findProbabiltyAandB(int union, int SampleSize){
        return (double) union / SampleSize;                                         //Returns the probabilty of a and b.
    }


    public boolean findDependent(int J, int K, int SampleSize){
        return findProbabiltyAandB(J + K, SampleSize) == findProbabiltyA(J, SampleSize) * findProbabiltyB(J, SampleSize);   //Returns whether the two probabilties are dependent
    }


    public boolean findIndependent(int J, int K, int SampleSize){
        return !findDependent(J, K, SampleSize);                           //Returns whether the two probabilies are independent. Which is the opposite of dependent.
    }


    public double getBinomialDistribution(int J, double K, double L, int M){
        BigInteger combination = getCombination(J, M);                     //Finding the combination
        double combinationToDouble = combination.doubleValue();            //Converting BigInteger value to a double

        return combinationToDouble * Math.pow(K, L) * Math.pow(1-K, J-M);  //Finding 1-K to the J-M power.
    }


    public double getGeometricDistribution(int k, double p){
        return Math.pow(1 - p, k - 1) * p;                                 //Finding (1- p)^ k-1 times p
    }


    public double getHyperGeometricDistribution(int r, int y, int N, int n){
        BigInteger numerator = getCombination(r, y).multiply(getCombination(N-r, n-y)); //Finds C(r y) * C(N - r, n - y).
        BigInteger denominator = getCombination(N, n);                                  //Find C(N n)

        double numeratorDouble = numerator.doubleValue();                               //Changes it to a double value.
        double denominatorDouble = denominator.doubleValue();                           //Changes it to a double value.

        return numeratorDouble / denominatorDouble;
    }


    public double getNegativeBinomialDistribution(double p, int r, int y){
        BigInteger firstBlock = getCombination(y-1, r-1);                               //Finding the value of combination(y-1 choose r-1).
        double secondBlock = Math.pow(p, r);                                            //Finding the value of p^r.
        double thirdBlock = secondBlock * Math.pow(1-p, y-r);                             //Finding the value of q^y-r.

        double firstBlockConvert = firstBlock.doubleValue();                            //Converting the BigInteger value to a double value

        return firstBlockConvert * thirdBlock;                                          //Returns the value of combination times the powers.
    }
}