public class NumberConverter
{
    int[] digits;
    int base;
    int num;

    public NumberConverter(int number, int base)
    {
        num = number;
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++)
        {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber()
    {
        String o = "";
        for (int i = 0; i < digits.length; i++)
        {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }




    public String genBaseRule(int newBase)
    {
        String con = "";
        int i = 0;
        int b = 0;
        while (i < digits.length) //converts to decimal
        {
            b += digits[(digits.length-1) - i]*Math.pow(base, i);
            i++;
        }
        con = Integer.toString(b);


        if (newBase != 10) //converts from decimal
        {
            con = "";
            while (b > 0)
            {
                int c = b % newBase;
                b /= newBase;
                con = c + con;
            }
        }
        return con;
    }


    public int[] getDigits()
    {
        return digits;
    }

    public String convertToDecimal()
    {
        return genBaseRule(10);
    }

    public String convertToBinary()
    {
        return genBaseRule(2);
    }

    public String convertToOctal()
    {
        return genBaseRule(8);
    }
}
