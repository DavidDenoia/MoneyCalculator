package Persistence;

import Model.Currency;
import Model.ExchangeRate;
/**
 *
 * @author David
 */
public interface ExchangeRateLoader {
    
    ExchangeRate load(Currency from, Currency to);
}
