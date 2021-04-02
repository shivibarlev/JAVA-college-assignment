package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public boolean execute() throws IOException
    {
        Document doc = Jsoup.connect(this.url).get();

        return doc.body().text().contains(this.args.get(2));
    }
}
