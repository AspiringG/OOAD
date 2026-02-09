import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    private Random rand = new Random();

    /*
     * Creates and returns an ArrayList of n random numbers
     * using one of the three random number generators.
     */
    public ArrayList<Double> populate(int n, int randNumGen) {
        ArrayList<Double> values = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double x;

            if (randNumGen == 1) {
                x = rand.nextDouble();
            } else if (randNumGen == 2) {
                x = Math.random();
            } else {
                x = ThreadLocalRandom.current().nextDouble();
            }

            values.add(x);
        }

        return values;
    }

    /*
     * Calculates the number of elements (n), mean,
     * sample standard deviation, minimum and maximum.
     * Returns results in the order:
     * [n, mean, stddev, min, max]
     */
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        int n = randomValues.size();

        double sum = 0.0;
        double min = randomValues.get(0);
        double max = randomValues.get(0);

        for (int i = 0; i < n; i++) {
            double v = randomValues.get(i);
            sum += v;

            if (v < min) min = v;
            if (v > max) max = v;
        }

        double mean = sum / n;

        double stddev = 0.0;
        if (n > 1) {
            double sqSum = 0.0;
            for (int i = 0; i < n; i++) {
                double diff = randomValues.get(i) - mean;
                sqSum += diff * diff;
            }
            stddev = Math.sqrt(sqSum / (n - 1));
        }

        ArrayList<Double> result = new ArrayList<>();
        result.add((double) n);
        result.add(mean);
        result.add(stddev);
        result.add(min);
        result.add(max);

        return result;
    }

    /*
     * Displays the results in a tabular format in the console
     * with or without a header.
     */
    public void display(ArrayList<Double> results, boolean headerOn) {
    if (headerOn) {
        System.out.printf("%-18s %-8s %-12s %-12s %-12s %-12s%n",
                "Generator", "n", "mean", "stddev", "min", "max");
        System.out.println("--------------------------------------------------------------------------");
    }

    System.out.printf("%-8.0f %-12.6f %-12.6f %-12.6f %-12.6f%n",
            results.get(0), results.get(1), results.get(2), results.get(3), results.get(4));
}


    /*
     * Calls populate, statistics, and display methods
     * for all combinations of n values and generators.
     */
    public void execute() {
    int[] nValues = {10, 1000, 100000};

    System.out.printf("%-18s %-8s %-12s %-12s %-12s %-12s%n",
            "Generator", "n", "mean", "stddev", "min", "max");
    System.out.println("--------------------------------------------------------------------------");

    for (int i = 0; i < nValues.length; i++) {
        int n = nValues[i];

        for (int gen = 1; gen <= 3; gen++) {
            ArrayList<Double> values = populate(n, gen);
            ArrayList<Double> stats = statistics(values);

            System.out.printf("%-18s ", generatorName(gen));
            display(stats, false);
        }
    }
}



    private String generatorName(int gen) {
        if (gen == 1) return "java.util.Random";
        if (gen == 2) return "Math.random()";
        return "ThreadLocalRandom";
    }
}