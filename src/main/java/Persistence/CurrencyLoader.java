package Persistence;

import java.util.List;
import Model.Currency;
/**
 *
 * @author David
 */
public interface CurrencyLoader {
    
     List<Currency> load();
     
}
