import java.util.Scanner;

class Main {
    public static String calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Incorrect input format. Expected: Num1 operation Num2");
        }

        int a = Integer.parseInt(parts[0]);
        String operation = parts[1];
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10");
        }

        return switch (operation) {
            case "+" -> String.valueOf(a + b);
            case "-" -> String.valueOf(a - b);
            case "*" -> String.valueOf(a * b);
            case "/" -> String.valueOf(a / b);
            default ->
                    throw new IllegalArgumentException("Incorrect operation, allowed values are +, -, *, /");
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.println("Enter operation: ");
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Result: " + result);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
