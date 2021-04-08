package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordSearch extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();


    public WordSearch(String[] arguments)
    {
        super(arguments);
        for(int i = 2; i < arguments.length; i++)
            this.args.add(arguments[i]);
    }

    @Override
    public boolean action()
    {
        if(new ContentType(new String[]{"t", this.url, "text"}).action())
        {
            try
            {
                Document doc = Jsoup.connect(this.url).get();
                String urlDoc = doc.body().text().toLowerCase(Locale.ROOT);
                File wordFile = new File(this.args.get(0));
                Scanner input = new Scanner(wordFile);
                while (input.hasNext())
                {
                    String word = input.next().toLowerCase(Locale.ROOT);
                    if (!urlDoc.contains(word))
                        return false;
                }
            }
            catch (Exception e)
            {
                System.out.println("error");
                return false;
            }
        }
        else
            return false;

        return true;
    }
}
