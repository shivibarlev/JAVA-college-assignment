package Command;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.util.*;

/**
 * A command type class, this command searches the web page from the URL for words that are in the file provided by the user.
 */
public class WordSearch extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();

    /**
     * Class constructor, builds the object from arguments given by the user.
     * @param arguments holds the URL, and the path to the file containing the words to search.
     */
    public WordSearch(String[] arguments)
    {
        super(arguments);
        for(int i = 2; i < arguments.length; i++)
            this.args.add(arguments[i]);
    }

    /**
     * A method that runs this commands test, checking if the content type of the URL is "text",
     * and searches the page for the words provided by the user.
     * @return true if web page contains ALL words, false if not.
     */
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
