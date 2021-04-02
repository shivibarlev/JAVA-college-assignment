package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckLang extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();
    Map<Character, Double> freqMap = new HashMap<>();

    public CheckLang(String[] arguments)
    {
        super(arguments);

        for(int i = 2; i < arguments.length; i++)
            args.add(arguments[i]);

        this.freqMap.put('a', 0.082);
        this.freqMap.put('b', 0.015);
        this.freqMap.put('c', 0.028);
        this.freqMap.put('d', 0.043);
        this.freqMap.put('e', 0.13);
        this.freqMap.put('f', 0.022);
        this.freqMap.put('g', 0.02);
        this.freqMap.put('h', 0.061);
        this.freqMap.put('i', 0.07);
        this.freqMap.put('j', 0.015);
        this.freqMap.put('k', 0.077);
        this.freqMap.put('l', 0.04);
        this.freqMap.put('m', 0.024);
        this.freqMap.put('n', 0.067);
        this.freqMap.put('o', 0.075);
        this.freqMap.put('p', 0.019);
        this.freqMap.put('q', 0.00095);
        this.freqMap.put('r', 0.06);
        this.freqMap.put('s', 0.063);
        this.freqMap.put('t', 0.091);
        this.freqMap.put('u', 0.028);
        this.freqMap.put('v', 0.0098);
        this.freqMap.put('w', 0.024);
        this.freqMap.put('x', 0.0015);
        this.freqMap.put('y', 0.02);
        this.freqMap.put('z', 0.00074);
    }

    public double countChars(String text, char check)
    {
        return text.length() - text.replace("check","").length();
    }

    @Override
    public boolean execute() throws IOException
    {
        String doc = Jsoup.connect(this.url).get().body().text();
        Map<Character, Double> docFreqMap = new HashMap<>();
        double docCharLength = 0;

        for(char i : this.freqMap.keySet())
        {
            double temp = countChars(doc, i);
            docFreqMap.put(i, temp);
            docCharLength += temp;
        }

        for(char i : docFreqMap.keySet())
            docFreqMap.put(i,docCharLength/docFreqMap.get(i));

        double var = 0;

        for(char i: this.freqMap.keySet())
            var += this.freqMap.get(i) - docFreqMap.get(i);
        return (0.04 >= var*var);
    }
}
