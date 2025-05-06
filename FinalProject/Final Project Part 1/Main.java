public class Main {

    public static void main(String[] args) {
        OriginalFormula graph = new OriginalFormula();                //Create object to generate function data
        Salter salt = new Salter();                                   //Create object to add salt (random noise)
        Smoother smooth = new Smoother();                             //Create object to smooth salted data

        //Set 1: Quadratic -10 to 10
        graph.quadratic(-10, 10, "quadraticData.csv");                //SET1
        salt.dataSalter("quadraticData.csv", "quadraticSalted.csv", 10);         //SET1
        smooth.dataSmoother("quadraticSalted.csv", "quadraticSmoothed.csv", 1);  //SET1

        //Set 2: Quadratic -25 to 25
        graph.quadratic(-25, 25, "quadraticData2.csv");               //SET2
        salt.dataSalter("quadraticData2.csv", "quadraticSalted2.csv", 25);       //SET2
        smooth.dataSmoother("quadraticSalted2.csv", "quadraticSmoothed2.csv", 3); //SET2

        //Set 3: Quadratic -50 to 50
        graph.quadratic(-50, 50, "quadraticData3.csv");               //SET3
        salt.dataSalter("quadraticData3.csv", "quadraticSalted3.csv", 50);       //SET3
        smooth.dataSmoother("quadraticSalted3.csv", "quadraticSmoothed3.csv", 7); //SET3

        //Set 1: Sine -10 to 10
        graph.sine(-10, 10, "sineData.csv");                          //SET1
        salt.dataSalter("sineData.csv", "sineSalted.csv", 10);       //SET1
        smooth.dataSmoother("sineSalted.csv", "sineSmoothed.csv", 1); //SET1

        //Set 2: Sine -25 to 25
        graph.sine(-25, 25, "sineData2.csv");                         //SET2
        salt.dataSalter("sineData2.csv", "sineSalted2.csv", 25);     //SET2
        smooth.dataSmoother("sineSalted2.csv", "sineSmoothed2.csv", 3); //SET2

        //Set 3: Sine -50 to 50
        graph.sine(-50, 50, "sineData3.csv");                         //SET3
        salt.dataSalter("sineData3.csv", "sineSalted3.csv", 50);     //SET3
        smooth.dataSmoother("sineSalted3.csv", "sineSmoothed3.csv", 7); //SET3

        //Set 1: Absolute -10 to 10
        graph.absolute(-10, 10, "absoluteData.csv");                 //SET1
        salt.dataSalter("absoluteData.csv", "absoluteSalted.csv", 10); //SET1
        smooth.dataSmoother("absoluteSalted.csv", "absoluteSmoothed.csv", 1); //SET1

        //Set 2: Absolute -25 to 25
        graph.absolute(-25, 25, "absoluteData2.csv");                //SET2
        salt.dataSalter("absoluteData2.csv", "absoluteSalted2.csv", 25); //SET2
        smooth.dataSmoother("absoluteSalted2.csv", "absoluteSmoothed2.csv", 3); //SET2

        //Set 3: Absolute -50 to 50
        graph.absolute(-50, 50, "absoluteData3.csv");                //SET3
        salt.dataSalter("absoluteData3.csv", "absoluteSalted3.csv", 50); //SET3
        smooth.dataSmoother("absoluteSalted3.csv", "absoluteSmoothed3.csv", 7); //SET3
    }
}
