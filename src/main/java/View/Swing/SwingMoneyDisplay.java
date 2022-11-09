package View.Swing;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Money;
import View.MoneyDisplay;
/**
 *
 * @author David
 */
public class SwingMoneyDisplay extends JPanel implements MoneyDisplay{
    
    private Money money;

    public SwingMoneyDisplay() {
        this.setBackground(new Color(255, 255, 255));
    }
    
    public void display(Money money) {
        this.money = money;
        this.removeAll();
        this.add(displayAmount(), BorderLayout.CENTER);
        this.add(displayCurrency(), BorderLayout.EAST);
        this.updateUI();
    }

    private JLabel displayAmount() {
        JLabel label = new JLabel(String.valueOf(this.money.getAmount()));
        label.setFont(new Font("Verdana", Font.BOLD, 18));
        label.setForeground(new Color(0, 0, 102));
        return label;
    }

    private JLabel displayCurrency() {
        JLabel label = new JLabel(this.money.getCurrency().getCode());
        label.setFont(new Font("Verdana", Font.BOLD, 18));
        label.setForeground(new Color(0, 0, 102));
        return label;
    }
}
