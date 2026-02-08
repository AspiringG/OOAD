import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

//You are required to implement a Java program that generates random numbers using different built-in Java random number generators and analyzes the generated data using descriptive statistics.

public class Generator
{


    // Creates and returns an ArrayList of n random numbers using one of the three random
    // number generators.
    ArrayList<Double> populate(int n, int randNumGen) 
    {
        ArrayList<Double> al = new ArrayList<>();
        Random rand = new Random();
        
        //print 3 random numbers, store in the array list
        for (int i = 1; i <=3; i++)
        {
            al.add(rand.nextDouble(0,1));
        }

        return al;
    }  


    // Calculates the number of elements (n), mean, sample standard deviation, minimum, 
    // and maximum, and returns the results in the following order:
    // [n, mean, stddev, min, max]
    ArrayList<Double> statistics(ArrayList<Double> randomValues)
    {

    }
}