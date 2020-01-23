package View.Persistence;

import Model.Currency;
import Model.ExchangeRate;

public interface ExchangeRateLoader {

    ExchangeRate load(Currency from, Currency to);

}
