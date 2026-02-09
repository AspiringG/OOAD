### Goal of the program 

In this project, I implemented a Java program that generates random double values in the range 
[0,1) using 3 different built-in Java random number generators: java.util.Random, Math.random(), and ThreadLocalRandom. 
For each generator and selected sample sizes, the program computes descriptive statistics and prints the results in a tabular format in the console.

### Method Descriptions
**populate**(int n, int randNumGen)

* I use this method to generate the random data. It returns an ArrayList<Double> which has exactly n random values. Inside the loop that runs n times,
  I choose which random number generator to use based on the value of randNumGen.

**statistics**(ArrayList<Double> randomValues)

* This method is responsible for calculating the statistics. First, we need to determine the sample size n from the list length.
  Then we loop through the list once to compute the sum, minimum, and maximum values. Using the sum, I calculate the mean. After that,
  I loop through the list again to compute the sample standard deviation using the formula that divides by (n - 1).
  The results are returned in the required order: n, mean, stddev, min, max

**display**(ArrayList<Double> results, boolean headerOn)

* I use this method only for output. If headerOn is true, the method prints the table header once.
  It then prints one row of numerical results using the values provided in the results list.
  The generator name is printed outside of this method so that each row clearly shows which random number generator was used.

**execute**()

* This method controls the execution of the entire program. I define the sample sizes in an array and print the table header at the beginning.
  Then I use nested loops to iterate over each sample size and each random number generator.
  For every combination, I call **populate()** to generate the values, **statistics()** to calculate the results, and **display()** to display the output.
  This produces a total of 9 result rows as per requiremetns.
