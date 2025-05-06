public class MainJFree {
    public static void main(String[] args) {
        Grapher grapher = new Grapher();

        // Set 1
        grapher.graphQuadratic(-10, 10, 1, "quadraticData1");   // Set 1: Quadratic
        grapher.graphSine(-10, 10, 1, "sineData1");             // Set 1: Sine
        grapher.graphAbsolute(-10, 10, 1, "absoluteData1");     // Set 1: Absolute

        // Set 2
        grapher.graphQuadratic(-25, 25, 1, "quadraticData2");   // Set 2: Quadratic
        grapher.graphSine(-25, 25, 1, "sineData2");             // Set 2: Sine
        grapher.graphAbsolute(-25, 25, 1, "absoluteData2");     // Set 2: Absolute

        // Set 3
        grapher.graphQuadratic(-50, 50, 1, "quadraticData3");   // Set 3: Quadratic
        grapher.graphSine(-50, 50, 1, "sineData3");             // Set 3: Sine
        grapher.graphAbsolute(-50, 50, 1, "absoluteData3");     // Set 3: Absolute
    }
}
