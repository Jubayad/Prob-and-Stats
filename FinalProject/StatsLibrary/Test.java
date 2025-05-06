package StatsLibrary;

public class Test {
    public static void main(String[] args) {
        StatsLibrary stats = new StatsLibrary();

        double factorial = stats.getFactorial(5);
        System.out.println(factorial);

        double poisson = stats.poissonProbability(4.0, 2);
        System.out.println(poisson);

        double chebyshev = stats.chebyshevBound(2);
        System.out.println(chebyshev);

        double uniform = StatsLibrary.uniformDensity(5, 0, 10);
        System.out.println(uniform);

        double normal = StatsLibrary.normalDensity(0, 0, 1);
        System.out.println(normal);
    }
}
