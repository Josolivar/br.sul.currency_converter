import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CurrencyResources {
    private static CurrencyResources uniqueInstance;
    private ArrayList<Currency> currencyResources = new ArrayList<>();

    private CurrencyResources() {}

    public static synchronized CurrencyResources getInstance() throws IOException {
        if(uniqueInstance == null)
            (uniqueInstance = new CurrencyResources()).setCurrencyResources();

        return uniqueInstance;
    }

    public ArrayList<Currency> getCurrencyResources() {
        return currencyResources;
    }

    private void setCurrencyResources() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\josol\\IdeaProjects\\currency-converter\\src\\main\\resources\\currencies.txt")));
        String line;
        String[] str = new String[3];
        while((line = bufferedReader.readLine()) != null) {
             str = line.split("-");
             this.currencyResources.add(new Currency(str[0], str[1], str[2]));
        }
        bufferedReader.close();
    }
}