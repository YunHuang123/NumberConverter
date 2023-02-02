import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        while (!choice.equals("2") && !choice.equals("8") && !choice.equals("10"))
        {
            System.out.println("Sorry, this base is not available.");
            System.out.print("Enter the base of your number (2, 8 or 10): ");
            choice = s.nextLine();
        }
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        if (choice.equals("2"))
        {
            for (int i = 2; i < 10; i ++)
            {
                while (number.contains(Integer.toString(i)))
                {
                    System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                }
            }
        }
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        if (base == 2)
        {
            System.out.println("Octal: " + nc.convertToOctal());
            System.out.println("Decimal: " + nc.convertToDecimal());
        }
        else if (base == 8)
        {
            System.out.println("Binary: " + nc.convertToBinary());
            System.out.println("Decimal: " + nc.convertToDecimal());
        }
        else if (base == 10)
        {
            System.out.println("Binary: " + nc.convertToBinary());
            System.out.println("Octal: " + nc.convertToOctal());
        }
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
    }
}
