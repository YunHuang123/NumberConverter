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
        //String[] numbers = new String[number.length()];
        boolean hasLetter = false;
        for (int i = 0; i < number.length(); i ++)
        {
            //numbers[i] = number.substring(i, i + 1);
            if (Character.isLetter(number.charAt(i)))
            {
                hasLetter = true;
            }
        }

        if (hasLetter == false)
        {
            if (choice.equals("2"))
            {
                while (number.contains("2") || number.contains("3") || number.contains("4") || number.contains("5") || number.contains("6") || number.contains("7") || number.contains("8") || number.contains("9"))
                {
                    System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                }
            }
            if (choice.equals("8"))
            {
                while (number.contains("8") || number.contains("9"))
                {
                    System.out.println("Sorry, this number contains incorrect digit(s) for this base.");
                    System.out.print("Enter your number: ");
                    number = s.nextLine();
                }
            }
        }
        else
        {
            System.out.println("Invalid Input");
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
