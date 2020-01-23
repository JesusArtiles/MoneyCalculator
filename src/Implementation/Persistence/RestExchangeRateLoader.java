package Implementation.Persistence;

import Model.Currency;
import Model.ExchangeRate;
import View.Persistence.ExchangeRateLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RestExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {

        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private double read(String from, String to) throws IOException {
        InputStream is = new URL("http://data.fixer.io/api/latest?access_key=f16e24aa15194246a8c4e551fdc68797&base="+from+"&symbols="+to).openStream();
        String line = new String();
        int i;

        while((i = is.read())!=-1) {
            line+=(char)i;
        }
        return Double.parseDouble(line.substring(line.indexOf("rates")+14,line.indexOf("}")));
    }

}
