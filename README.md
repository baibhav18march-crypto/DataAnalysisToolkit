# DataAnalysisToolkit 📊

A Java-based data analysis toolkit for performing basic statistics on numeric data.

## Features

- **Data Loading**: Read numeric data from CSV files
- **Statistical Operations**: 
  - Sum calculation
  - Average/Mean calculation
  - Variance calculation
- **Strategy Pattern**: Flexible architecture using aggregation strategies

## Project Structure

```
com/toolkit/dataanalysis/
├── Main.java                    # Entry point
├── Dataset.java                 # Data management
├── AggregationStrategy.java     # Strategy interface
├── SumStrategy.java            # Sum calculation
├── AverageStrategy.java        # Average calculation
└── VarianceStrategy.java       # Variance calculation
```

## How It Works

1. The program reads numeric data from `project2.csv`
2. Applies statistical analysis using different strategies
3. Outputs the calculated results

## Sample Output

When running with a sample dataset:

```
File: project2.csv
Column: marks
Number of records = 6
Sum = 150.5
Mean = 25.083333333333332
Variance = 45.24305555555556```

## Code Example

```java
// Load data from CSV file
Dataset dataset = new Dataset(new File("project2.csv"));
double[] data = dataset.getColumn("marks");
// Calculate statistics
double sum = new SumStrategy().execute(data);
double mean = new AverageStrategy().execute(data);
double variance = new VarianceStrategy().execute(data);

// Display results
System.out.println("Sum: " + sum);
System.out.println("Mean: " + mean);
System.out.println("Variance: " + variance);
```

## Deployment

🚀 **Live Deployment**: [View on GitHub Pages](https://baibhav18march-crypto.github.io/DataAnalysisToolkit/)

The project is automatically deployed using GitHub Actions whenever changes are pushed to the main branch.

## GitHub Actions Workflow

The project uses CI/CD with GitHub Actions:
- ✅ Automatic compilation on push
- ✅ Builds with JDK 11
- ✅ Creates deployment artifacts
- ✅ Deploys to GitHub Pages

## Technologies Used

- **Language**: Java 11
- **Build Tool**: GitHub Actions
- **Deployment**: GitHub Pages
- **Design Pattern**: Strategy Pattern

## How to Run Locally

```bash
# Compile the code
javac -d build com/toolkit/dataanalysis/*.java

# Run the program
java -cp build com.toolkit.dataanalysis.Main
```

## License

Open source project for educational purposes.

---

*Built with ☕ Java*
