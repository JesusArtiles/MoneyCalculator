package Implementation.Persistence;

import Model.Currency;
import View.Persistence.CurrencyListLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyListLoader implements CurrencyListLoader {

    private String filename;

    public FileCurrencyListLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Currency> load() {

        List<Currency> list = new ArrayList<>();
        try{

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine()) != null) {
                list.add(toCurrencyof(line));
            }

            fr.close();
        }

        catch(IOException ioe)

        {

            System.err.println("IOException: " + ioe.getMessage());

        }

        return list;
    }

    private Currency toCurrencyof(String line) {

        String[] parts = line.split(",");
        return new Currency(parts[0],parts[1],parts[2]);

    }

}
