/**
 * CTCI 17.7
 */
package moderate;

public class IntegerEnglishPhrase {
    public static String[] digits = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    public static String[] teens = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    public static String[] tens = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    public static String[] bigs = { "", "Thousand", "Million", "Billion" };

    public static String numToString(int num) {
        if (num == 0) {
            return "Zero";
        } else if (num < 0) {
            return "Negative" + numToString(-num);
        }
        String ans = "";
        for (int count = 0; num > 0; num /= 1000, count++) {
            if (num % 1000 != 0) {
                ans = numToString100(num % 1000) + bigs[count] + " " + ans;
            }
        }
        return ans;
    }

    public static String numToString100(int num) {
        String ans = "";
        if (num >= 100) {
            ans += digits[num / 100 - 1] + " Hundred ";
            num %= 100;
        }
        if (num >= 11 && num <= 19) {
            return ans + teens[num - 11] + " ";
        } else if (num == 10 || num >= 20) {
            ans += tens[num / 10 - 1] + " ";
            num %= 10;
        }
        if (num >= 1 && num <= 9) {
            ans += digits[num - 1] + " ";
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(IntegerEnglishPhrase.numToString(19323984));
    }
}
