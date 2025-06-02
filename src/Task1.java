import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for two integers
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        // Prompt for a floating-point number
        System.out.print("Enter a floating-point number: ");
        double floatNum = scanner.nextDouble();

        // Prompt for a single character
        System.out.print("Enter a single character: ");
        char ch = scanner.next().charAt(0);

        // Prompt for a boolean value
        System.out.print("Enter a boolean value (true/false): ");
        boolean boolValue = scanner.nextBoolean();

        // Clear the input buffer
        scanner.nextLine(); // Consume the remaining newline

        // Prompt for the user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Process and display results
        System.out.println("\nSum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
        System.out.println("Difference between " + num1 + " and " + num2 + " is: " + (num1 - num2));
        System.out.println("Product of " + num1 + " and " + num2 + " is: " + (num1 * num2));
        System.out.println(floatNum + " multiplied by 2 is: " + (floatNum * 2));
        System.out.println("The next character after '" + ch + "' is: " + (char)(ch + 1));
        System.out.println("The opposite of " + boolValue + " is: " + (!boolValue));
        System.out.println("Hello, " + name + "!");

        scanner.close();
    }
}
