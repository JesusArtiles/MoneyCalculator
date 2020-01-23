package Control;

import Implementation.Persistence.FileCurrencyListLoader;
import Implementation.Persistence.RestExchangeRateLoader;
import Model.Currency;
import View.Persistence.CurrencyListLoader;
import View.Persistence.ExchangeRateLoader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CurrencyListLoader currencies = new FileCurrencyListLoader("data/currencies.txt");
        ExchangeRateLoader exchangeRate = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencies.load());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(),exchangeRate));
    }
}

