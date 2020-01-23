package Implementation.UI;

import Model.Currency;
import Model.Money;
import View.UI.MoneyDialog;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;


public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private JTextField ammount;
    private List<Currency> currencies;
    private JComboBox currencyNames;

    public SwingMoneyDialog(List<Currency> currencies) {
        this.currencies=currencies;
        init();
    }

    private void init(){
        ammount = new JTextField(20);
        currencyNames = new JComboBox(getCurrencyNames().toArray());
        add(ammount);
        add(currencyNames);
    }

    public Money get() {
        return new Money(parseDouble(ammount.getText()), getSelectedCurrency());
    }

    private Currency getSelectedCurrency() {
        String selectedCurrency= currencyNames.getSelectedItem().toString();
        for (Currency currency : currencies){
            if (CurrencyFound(selectedCurrency, currency)){
                return currency;
            }
        }
        return null;
    }

    private boolean CurrencyFound(String selectedCurrency, Currency currency) {
        return currency.getName().equals(selectedCurrency);
    }

    public ArrayList<String> getCurrencyNames(){
        ArrayList<String> currencyNamesList = new ArrayList();
        for(Currency currency : currencies){
            currencyNamesList.add(currency.getName());
        }
        return currencyNamesList;
    }

}
