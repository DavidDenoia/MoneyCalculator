package Control;

import Model.Currency;
import Model.Money;
import Persistence.ExchangeRateLoader;
import View.MoneyDialog;
import View.MoneyDisplay;
import View.Swing.SwingMoneyDialog;

/**
 *
 * @author David
 */
public class ExchangeCommand implements Command {
    
    private ExchangeRateLoader exchangeRateLoader;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public ExchangeCommand(ExchangeRateLoader exchangeRateLoader, MoneyDialog moneyDialog, MoneyDisplay moneyDisplay) {
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
    }

    
    @Override
    public void execute(){
        this.moneyDisplay.display(exchange(this.moneyDialog.getFrom(), this.moneyDialog.getTo()));
    }
    
    private Money exchange(Money money, Currency currency){
        double exchangeResult = money.getAmount() * exchangeRate(money.getCurrency(), currency);
        return new Money(exchangeResult, currency);
    }
    
    private double exchangeRate(Currency from, Currency to){
        return exchangeRateLoader.load(from, to).getRate();
    }
}
