import java.io.IOException;
import java.util.AbstractMap;

public class ExchangeRateAPI {

     static double getCurrencyValue(String referenceCurrency, String currency) {
        try {
            String str = ApiConsumer.getJsonAsString("https://v6.exchangerate-api.com/v6/79c1593c3d1784757963c370/latest/" + referenceCurrency);
            str = str.substring(str.lastIndexOf(currency.toUpperCase())+5);
            return Double.parseDouble(str.substring(0, str.indexOf(",")));
        } catch(IOException | InterruptedException e){
            return -1.0;
        }
    }
}