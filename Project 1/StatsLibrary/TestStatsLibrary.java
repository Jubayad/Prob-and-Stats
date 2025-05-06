import java.util.Arrays;
import java.util.List;

public class TestStatsLibrary
{
    public static void main(String[] args){
        StatsLibrary tester = new StatsLibrary();
        
        int[] userInputNumbers = {1, 2, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        List<Integer> listB = Arrays.asList(3, 4, 5, 6);
        int sampleSize = 10;
        int favorableA = 4;
        int favorableB = 5;
        int union = 2;

        System.out.println("Mean: " + tester.getMean(userInputNumbers)); 

        System.out.println("Median: " + tester.getMedian(userInputNumbers));

        System.out.println("Mode: " + tester.getMode(userInputNumbers));

        System.out.println("Standard Deviation: " + tester.getStandardDeviation(userInputNumbers));

        System.out.println("Variance: " + tester.getVariance(userInputNumbers));

        System.out.println("Factorial of 7: " + tester.getFactorial(7));

        System.out.println("Permutation P(7, 5): " + tester.getPermutation(7, 5));

        System.out.println("Combination C(7, 5): " + tester.getCombination(7, 5));

        System.out.println("Independent Intersection of listA and listB: " + tester.independentIntersection(listA, listB));

        System.out.println("Dependent Intersection of listA and listB: " + tester.dependantIntersection(listA, listB));

        System.out.println("Exclusive Union of listA and listB: " + tester.exclusiveUnion(listA, listB));

        System.out.println("Inclusive Union of listA and listB: " + tester.inclusiveUnion(listA, listB));

        System.out.println("Probability of A: " + tester.findProbabiltyA(favorableA, sampleSize));

        System.out.println("Probability of B: " + tester.findProbabiltyB(favorableB, sampleSize));

        System.out.println("Probability of A and B: " + tester.findProbabiltyAandB(union, sampleSize));

        System.out.println("Are A and B dependent? " + tester.findDependent(favorableA, favorableB, sampleSize));

        System.out.println("Are A and B independent? " + tester.findIndependent(favorableA, favorableB, sampleSize));

        System.out.println("Binomial Distribution P(X = 3): " + tester.getBinomialDistribution(5, 0.5, 0.0, 3));

        System.out.println("Geometric Distribution P(X = 3): " + tester.getGeometricDistribution(3, 0.5));

        System.out.println("Hypergeometric Distribution P(X = 2): " + tester.getHyperGeometricDistribution(5, 2, 10, 3));

        System.out.println("Negative Binomial Distribution P(Y = 5): " + tester.getNegativeBinomialDistribution(0.5, 3, 5));
    }
}