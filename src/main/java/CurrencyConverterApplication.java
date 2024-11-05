import java.util.Scanner;

public class CurrencyConverterApplication {

    //79c1593c3d1784757963c370 (chave da api)

    private final String menu = "##############################\n" +
            "\n" +
            "CURRENCY OPTIONS: \n\n" +
            "1. ARS - Argentine Peso\n" +
            "2. BRL - Brazilian Real\n" +
            "3. CHF - Swiss Franc\n" +
            "4. CNY - Chinese Renminbi\n" +
            "5. EUR - Euro\n" +
            "6. GBP - Pound Sterling\n" +
            "7. JPY - Japanese Yen\n" +
            "8. USD - United States Dollar\n" +
            "\n" +
            "##############################";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String referenceCurrency, currency;
        double amount;
        while (true) {
            System.out.println(menu + "\nEnter the reference currency (type any other character to exit): ");
            if ((referenceCurrency = this.getCurrencyIsoCode(scanner.nextLine())) == null) break;

            System.out.println("\nEnter the conversion currency (type any other character to exit): ");
            if ((currency = this.getCurrencyIsoCode(scanner.nextLine())) == null) break;

            if((amount = ExchangeRateAPI.getCurrencyValue(referenceCurrency,currency)) == -1)
                System.out.println("Sistema temporariamente indisponível. Tente novamente após alguns minutos.");
            else
                System.out.println("1.00 " + referenceCurrency + " = "
                    + amount + " " + currency);

            scanner.nextLine();
        }
        System.out.println("\n*******************************\n" +
                "PROGRAM COMPLETED SUCCESSFULLY!\n" +
                "*******************************");
        scanner.close();
    }

    private String getCurrencyIsoCode(String option) {
        switch (option) {
            case "1": return "ARS";
            case "2": return "BRL";
            case "3": return "CHF";
            case "4": return "CNY";
            case "5": return "EUR";
            case "6": return "GBP";
            case "7": return "JPY";
            case "8": return "USD";
            default: return null;
        }
    }
}