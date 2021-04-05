package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        try
        {
            Document doc = Jsoup.connect(this.url).get();
            File wordFile = new File(this.args.get(2));
            Scanner input = new Scanner(wordFile);
            while(input.hasNext())
            {
                String word = input.next();
                if(!doc.body().text().contains(word))
                    return false;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return true;
    }
}
