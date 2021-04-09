package Command;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * A command type class, this command checks if the web page from the URL provided by the user contains an image.
 */
public class CheckImg extends  BaseCommand
{
    /**
     * Class constructor, builds the object from arguments given by the user.
     * @param arguments holds the command and the URL.
     */
    public CheckImg(String[] arguments)
    {
        super(arguments);
    }

    /**
     * A method that runs this commands test, checking if the web page has an image.
     * @return true if web page contains an image, false if not.
     */
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
