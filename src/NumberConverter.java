public class NumberConverter {
    private int[] digits;
    private int base;
    private String originalNum;
    private final String forConversion = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
    //char[] numsAndLettersForConv = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public NumberConverter(String number, int base) {
        String numberAsString = number;
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            int d = forConversion.indexOf(String.valueOf(number.charAt(i)));
            digits[i] = d;
        }
        this.base = base;
    }

    public String display(int[] x) {
        String o = "";
        for (int i = 0; i < x.length; i++) {
            o += forConversion.charAt(x[i]);
        }
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] digitsTemp;
        int temp = 0;
        int pow = 0;
        int x = 0;
        for (int i = getDigits().length - 1; i >= 0; i--) {
            temp += getDigits()[i] * Math.pow(base, x);
            x++;
        }
        while (Math.pow(10, pow) <= temp) {
            pow++;
        }
        digitsTemp = new int[pow];
        pow--;
        for (int i = 0; i < digitsTemp.length; i++) {
            digitsTemp[i] = (int) (temp / Math.pow(10, pow));
            temp -= digitsTemp[i] * (Math.pow(10, pow));
            pow--;
        }
        return digitsTemp;
    }

    /**
     * Failed experiment of changing it to return an integer. rip
     *
     * public int convertToDecimal() {
     * int[] referenceToCharList = new int[getDigits().length - 1];
     * int converted = 0;
     * int x = 0;
     * for(int i = getDigits().length - 1; i >= 0; i--){
     * referenceToCharList[x] = forConversion.indexOf(getDigits()[i]);
     * converted += referenceToCharList[x] * Math.pow(10, i);
     * x++;
     * }
     * return converted;
     * }
     **/


    public int[] convertEverything(int convertBase) {
        int pow = 0;
        int[] x;
        int num;

        if (base != convertBase) {
            if (base != 10) {
                num = Integer.parseInt(display(convertToDecimal()));
            }
            else num = Integer.parseInt(display(digits));
            while (Math.pow(convertBase, pow) <= num) {
                pow++;
            }
            x = new int[pow];
            pow--;
            for (int i = 0; i < x.length; i++) {
                x[i] = num / (int) (Math.pow(convertBase,pow));
                num %= (int) (Math.pow(convertBase,pow));
                pow--;
            }
            return x;
        }
        return null;
    }
}