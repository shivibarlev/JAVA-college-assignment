package Exercises;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ContentType extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();

    public ContentType(String[] arguments)
    {
        super(arguments);

        for(int i = 2; i < arguments.length; ++i)
            args.add(arguments[i]);
    }

    @Override
    public boolean action()
    {
        try
        {
            Connection.Response response = Jsoup.connect(this.url).ignoreContentType(true).execute();
            System.out.println(response.contentType());
            return response.contentType().contains(this.args.get(0));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
