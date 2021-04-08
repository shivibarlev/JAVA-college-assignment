package Command;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

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
        if(this.args.size() != 0)
        {
            try
            {
                Connection.Response response = Jsoup.connect(this.url).ignoreContentType(true).execute();
                return response.contentType().contains(this.args.get(0));
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
