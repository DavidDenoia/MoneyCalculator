package App;

import Control.Command;
import Model.Currency;
import Persistence.ExchangeRateLoader;
import View.MoneyDisplay;
import View.Swing.SwingMoneyDialog;
import View.Swing.SwingMoneyDisplay;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author David
 */
public class MainFrame extends JFrame {
    private MoneyDisplay display;
    private SwingMoneyDialog dialog;
    private final List<Currency> currencies;
    private final ExchangeRateLoader loader;
    private Command command;
    
    
    public MainFrame(List<Currency> currencies, ExchangeRateLoader loader) {
        this.currencies = currencies;
        this.loader = loader;
        this.setTitle("Calculo de Monedas");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0, 0, 102));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.add(displayTitle(), Component.LEFT_ALIGNMENT);
        this.add(moneyDialog(), Component.CENTER_ALIGNMENT);
        this.add(moneyDisplay(), Component.CENTER_ALIGNMENT);
        this.setVisible(true);
    }

    public MoneyDisplay getDisplay() {
        return display;
    }

    public SwingMoneyDialog getDialog() {
        return dialog;
    }
    
    private JLabel displayTitle() {
        JLabel label = new JLabel("Convertidor de Divisas");
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        label.setForeground(new Color(255, 255, 255));
        label.setFont(new Font("Arial Black", 1, 14));
        return label;
    }
    
    private Component moneyDisplay() {
        SwingMoneyDisplay moneyDisplay = new SwingMoneyDisplay();
        this.display = moneyDisplay;
        this.dialog.setDisplay(this.display);
        return moneyDisplay;
    }
    
    private Component moneyDialog() {
        SwingMoneyDialog moneyDialog = new SwingMoneyDialog(this.currencies, this.loader);
        this.dialog = moneyDialog;
        return moneyDialog;
    }
}
