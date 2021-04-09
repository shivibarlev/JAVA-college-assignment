package Command;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.ArrayList;

/**
 * A command type class, this command checks the content type of a URL.
 */
public class ContentType extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();

    /**
     * Class constructor, builds the object from arguments given by the user.
     * @param arguments holds arguments given by the user, should contain URL and content type to check.
     */
    public ContentType(String[] arguments)
    {
        super(arguments);

        for(int i = 2; i < arguments.length; ++i)
            args.add(arguments[i]);
    }

    /**
     * A method that runs this commands test, checking if the content type of the URL matches the one provided by the user.
     * @return true if matches, false if not.
     */
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
