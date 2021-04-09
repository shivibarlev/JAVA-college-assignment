package Command;

import org.jsoup.Jsoup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * A command type class, this command checks if the language of the web page provided by the user is in a specific language.
 */
public class CheckLang extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();
    Map<Character, Double> freqMap = new HashMap<>();

    /**
     * Class constructor, builds the object from arguments given by the user and sets the correct frequency table.
     * @param arguments holds the URL and the language the user wants to check.
     */
    public CheckLang(String[] arguments)
    {
        super(arguments);

        for(int i = 2; i < arguments.length; i++)
            args.add(arguments[i]);
        setFreqTable(args.get(0));
    }

    /**
     * A function that sets the correct frequency table to compare with the web page frequency table.
     * @param lang holds the language to be checked.
     */
    public void setFreqTable(String lang)
    {
        switch (lang)
        {
            case "english":
                setEnglish();
        }

    }

    /**
     * A function that sets the frequency table for the english language.
     */
    public void setEnglish()
    {
        this.freqMap.put('a', 0.0748);
        this.freqMap.put('b', 0.0134);
        this.freqMap.put('c', 0.0411);
        this.freqMap.put('d', 0.0308);
        this.freqMap.put('e', 0.1282);
        this.freqMap.put('f', 0.024);
        this.freqMap.put('g', 0.0185);
        this.freqMap.put('h', 0.0414);
        this.freqMap.put('i', 0.0725);
        this.freqMap.put('j', 0.0014);
        this.freqMap.put('k', 0.0053);
        this.freqMap.put('l', 0.0403);
        this.freqMap.put('m', 0.0340);
        this.freqMap.put('n', 0.0673);
        this.freqMap.put('o', 0.0785);
        this.freqMap.put('p', 0.0314);
        this.freqMap.put('q', 0.0010);
        this.freqMap.put('r', 0.0609);
        this.freqMap.put('s', 0.0614);
        this.freqMap.put('t', 0.1002);
        this.freqMap.put('u', 0.0316);
        this.freqMap.put('v', 0.0108);
        this.freqMap.put('w', 0.0131);
        this.freqMap.put('x', 0.0044);
        this.freqMap.put('y', 0.0127);
        this.freqMap.put('z', 0.0011);
    }

    /**
     * A function that counts the number of occurrences of a character in a string.
     * @param text holds the string to check.
     * @param check holds the character to count.
     * @return number of occurrences of 'check' in 'text'.
     */
    public double countChars(String text, char check)
    {
        return text.replaceAll(" ","").length() - text.replace(check, ' ').replaceAll(" ","").length();
    }

    /**
     * A method that runs this commands test, checking if the web page is in the language specified.
     * By creating a frequency table of the web page's text and matching it to existing frequency tables of different languages.
     * @return true if web page is in the specified language and false if not.
     */
    @Override
    public boolean action()
    {
        if(this.args.get(0).compareTo("english") == 0)
        {
            try
            {
                String doc = Jsoup.connect(this.url).get().body().text().toLowerCase(Locale.ROOT);
                doc = doc.replaceAll("[^a-z]", "");
                Map<Character, Double> docFreqMap = new HashMap<>();
                int docCharLength = doc.length();

                for (char i : this.freqMap.keySet())
                {
                    docFreqMap.put(i, countChars(doc, i) / docCharLength);
                }

                double var = 0;


                for (char i : this.freqMap.keySet())
                    var += (this.freqMap.get(i) - docFreqMap.get(i)) * (this.freqMap.get(i) - docFreqMap.get(i));

                return (0.04 >= var);
            }
            catch (Exception e)
            {
                System.out.println("error");
                return false;
            }
        }
        return false;
    }
}
