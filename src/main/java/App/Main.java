package App;

import Model.Currency;
import Persistence.CurrencyLoader;
import Persistence.ExchangeRateLoader;
import Persistence.FileCurrencyLoader;
import Persistence.WebServiceExchangeRateLoader;
import java.util.List;

/**
 *
 * @author David
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FileCurrencyLoader("currencies");
        List<Currency> currencies = currencyLoader.load();
        ExchangeRateLoader exchangeRateLoader = new WebServiceExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencies, exchangeRateLoader);
    }
    
}
