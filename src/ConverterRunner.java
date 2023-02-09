import java.util.Scanner;

class ConverterRunner {
    public static void main(String[] args) {
        int base = 0;
        String num = "";
        String thing = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter! No funny business");
        System.out.println("--------------------------------");
        System.out.print("Enter a base (1-64): ");

        for (int i = 0; i < 1; i++) {
            String choice = s.nextLine();
            if (Integer.parseInt(choice) > 0 && Integer.parseInt(choice) < 65) {
                base = Integer.parseInt(choice);
            } else {
                System.out.println("Not an available base");
                System.out.print("Enter base (1-64): ");
                i--;
            }
        }

        System.out.print("Enter a positive number: ");
        String number;
        boolean temp = true;
        while(temp){
            temp = false;
            number = s.nextLine();
            for (int j = 0; j < number.length(); j++) {
                if (thing.indexOf(number.charAt(j)) < 0) {
                    temp = true;
                    System.out.println("Invalid Number");
                    System.out.print("Enter a number: ");
                }
                if (thing.indexOf(number) >= base) {
                    temp = true;
                    System.out.println("Number does not compute with base input, Try again:");
                }

            }
            num = number;
        }
        NumberConverter nc = new NumberConverter(num, base);
        if (base != 2) {
            System.out.println("Bi: " + nc.display(nc.convertEverything(2)));
        }
        if (base != 8) {
            System.out.println("Oct: " + nc.display(nc.convertEverything(8)));
        }
        if (base != 10) {
            System.out.println("Deci: " + nc.display(nc.convertToDecimal()));
        }
        System.out.println("Choose another base to convert to: ");
        int newBase = s.nextInt();
        if (newBase > 64 || newBase < 1) {
            System.out.println("Invalid base, please try again by restarting");
            System.exit(0);
        } else
            System.out.println(newBase + ": " + nc.display(nc.convertEverything(newBase)));

    }
}