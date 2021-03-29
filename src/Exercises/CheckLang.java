package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class CheckLang extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();

    public CheckLang(String[] arguments)
    {
        super(arguments);
        for(int i = 2; i < arguments.length; i++)
            args.add(arguments[i]);
    }

    @Override
    public boolean execute() throws IOException
    {
        Document doc = Jsoup.connect(this.url).get();

        return true;
    }
}
