# Multiplication Table for Prime Numbers.

## Objective

	Write a program that prints out a multiplication table of the first 10 prime numbers.
	The program must run from the command line and print one table to STDOUT.
	First line and first column should present the 10 primes, and the body of the table should contain 
	the product of multiplying these numbers.

## Notes

	- Consider complexity and performance
	- Do Not use any library method for Prime (write your own solution)
	- Write Tests. TDD/BDD

## How to build the project:

    The solution was developed using Java 8;
    From the commandLine navigate to the project's directory (..\MultiplicationTable)
    When in the project's root, to run the tests - this command will compile the code and execute unit tests:

        mvn test

    To compile the project and generate the executable jar - use this command:

        mvn package or mvn clean package

    To run the program:

        java -jar target/MultiplicationTable-0.0.1-spring-boot.jar

    The same command with parameter - will generate the result for the amount of numbers informed:

        java -jar target/MultiplicationTable-0.0.1-spring-boot.jar 4
        java -jar target/MultiplicationTable-0.0.1-spring-boot.jar 15
        java -jar target/MultiplicationTable-0.0.1-spring-boot.jar 50
		
## Considerations:

    - For the default 10 first prime numbers, the code runs fast enough - a bit over 60 milliseconds;
    - Scaling to a large number of primes (>500), ideally the program should keep the numbers 
	already calculated (store), in memory/file/data base;
    - Another point of attention, if the program requirements are scaled, should be pre-calculating 
	the values in the multiplication table;
    - The code is prepared to receive a positive integer between 0 and 50000;
    - The argument will be validate and if the number is large, warning messages will be displayed.

    - Given the complexity of the code, the tests didn't require any mocks;

## Result:

	Multiplication table with the first 10 prime numbers:
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|    x|    2|    3|    5|    7|   11|   13|   17|   19|   23|   29|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|    2|    4|    6|   10|   14|   22|   26|   34|   38|   46|   58|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|    3|    6|    9|   15|   21|   33|   39|   51|   57|   69|   87|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|    5|   10|   15|   25|   35|   55|   65|   85|   95|  115|  145|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|    7|   14|   21|   35|   49|   77|   91|  119|  133|  161|  203|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|   11|   22|   33|   55|   77|  121|  143|  187|  209|  253|  319|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|   13|   26|   39|   65|   91|  143|  169|  221|  247|  299|  377|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|   17|   34|   51|   85|  119|  187|  221|  289|  323|  391|  493|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|   19|   38|   57|   95|  133|  209|  247|  323|  361|  437|  551|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|   23|   46|   69|  115|  161|  253|  299|  391|  437|  529|  667|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
	|   29|   58|   87|  145|  203|  319|  377|  493|  551|  667|  841|
	+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+

	>java -jar target/MultiplicationTable-0.0.1-spring-boot.jar 5
	Multiplication table with the first 5 prime numbers:
	+-----+-----+-----+-----+-----+-----+
	|    x|    2|    3|    5|    7|   11|
	+-----+-----+-----+-----+-----+-----+
	|    2|    4|    6|   10|   14|   22|
	+-----+-----+-----+-----+-----+-----+
	|    3|    6|    9|   15|   21|   33|
	+-----+-----+-----+-----+-----+-----+
	|    5|   10|   15|   25|   35|   55|
	+-----+-----+-----+-----+-----+-----+
	|    7|   14|   21|   35|   49|   77|
	+-----+-----+-----+-----+-----+-----+
	|   11|   22|   33|   55|   77|  121|
	+-----+-----+-----+-----+-----+-----+
