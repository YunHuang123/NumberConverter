public class NumberConverter {
    int[] digits;
    int base;
    int number;
    public NumberConverter(int number, int base) {
        this.number = number;
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int convertToDecimal() {
        int num = 0;
        int power = 0; 3
        if (base == 2)
        {
            if (number % 10 == 1)
            {
                num += Math.pow(2, power);
                power ++;
                number = number / 10;
            }
            else
            {
                power ++;
                number = number / 10;
            }
        }
        return num;
    }

    public int[] convertToBinary() {
        return null;
    }

    public int[] convertToOctal() {
        return null;
    }
}

