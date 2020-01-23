package Control;

import Model.Currency;
import Model.Money;
import View.Persistence.ExchangeRateLoader;
import View.UI.MoneyDialog;
import View.UI.MoneyDisplay;

public class CalculateCommand implements Command {

    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateLoader loader;

    private Currency eur = new Currency("EUR","Euro","€");

    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, ExchangeRateLoader loader) {
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.loader = loader;
    }

    @Override
    public String getName() {
        return "calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(performExchange(moneyDialog.get()));
    }

    private Money performExchange(Money money) {
        return new Money(money.getAmount() * rateOf(money.getCurrency()),eur);
    }

    private double rateOf(Currency currency) {
        return loader.load(eur, currency).getRate();
    }
}
