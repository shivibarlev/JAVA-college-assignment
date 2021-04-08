package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CheckImg extends  BaseCommand
{
    public CheckImg(String[] arguments)
    {
        super(arguments);
    }

    @Override
    public boolean action()
    {
        try
        {
            Document doc = Jsoup.connect(this.url).get();

            Elements imageElements = doc.select("img");

            if(imageElements.size() < 1)
                return false;
            return true;
        }
        catch (Exception e)
        {
            System.out.println("error");
            return false;
        }
    }
}
