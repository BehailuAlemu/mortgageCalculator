//MORTGAGE CALCULATOR: Guided project
// (Intellij IDEA Community Edition)

import java.text.NumberFormat;
import java.time.Year;
import java.util.Scanner;
import static java.lang.System.*;
import static java.text.NumberFormat.*;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_OF_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annualInterest = 0;
        float monthlyInterest = 0;
        byte years = 0;
        int numberOfPayments = 0;


        Scanner scanner = new Scanner(System.in);

        while (true) {
            out.println("የብድር መጠን:  ");
            principal = scanner.nextInt();
            if (principal >= 5_000 && principal <= 20_000_000) {
                break;
            }
            System.out.println("የብድር መጠን ከ5,000 እስከ 20,000,000 ብር ??");
        }

        while (true) {
            System.out.println("የወለድ መጠን ያስገቡ:  ");
            annualInterest = scanner.nextInt();
            monthlyInterest = (annualInterest / PERCENT) /MONTHS_OF_YEAR;

            if (annualInterest >= 10 && annualInterest <= 25) {
                break;
            }
            System.out.println("ሁሉም ባንኮች የሚያበድሩት ከ10 እስከ 25 በመቶኛ ነው::" + "\n" + "እባክዎ ትክክለኛውን የወለድ መጠን ያስገቡ: ");
        }

        while (true) {
            System.out.println("የሚመልሱበት አጠቃላይ ዓመት: ");
            years = scanner.nextByte();
            if (years <= 12 && years >=1) {
                numberOfPayments = years * MONTHS_OF_YEAR;
                break;
            }
            System.out.println("እባክዎ ከ1 እስከ 12ዓመት ቁጥር ያስገቡ:   ");
        }

        double mortgage = principal
                * annualInterest * Math.pow((1 + annualInterest), numberOfPayments)
                / Math.pow((1 + annualInterest), numberOfPayments) - 1;

        String mortgageFormated = NumberFormat.getIntegerInstance().format(mortgage);

        System.out.println("ብድርዎን በ" + years + " ዓመት ከፍለው  ለመጨረስ በወር " + "\n" + mortgageFormated + " ብር መክፈል አለብዎት::");
    }
}