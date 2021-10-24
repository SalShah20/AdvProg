
/**
 * Write a description of class Articles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Articles
{
    // instance variables - replace the example below with your own
    public Articles() 
    {
    }

    public boolean isArticle (String word) 
    {
        if (word.equalsIgnoreCase("a") || word.equalsIgnoreCase("an") ||
        word.equalsIgnoreCase("the")) 
        {
            return true;
        }
        return false;
    }

    public int countWords (String book) 
    {
        int count = 0;
        for (int i = 0; i < book.length(); i++) 
        {
            if (book.substring(i, i+1).equals(" "))
            {
                count++;
            }
        }
        return count;
    }

    public int countArticles (String tome) 
    {
        int count = 0;
        for (int i = 0; i < tome.length(); i++) 
        {
            int space = tome.indexOf(" ", i);
            String word = tome.substring(i, space);
            if (isArticle(word)) 
            {
                count++;
            }
            i += word.length();
        }
        return count;
    }

    public int calculateArticlePercentage (String manuscript) 
    {
        double articles = (double) countArticles(manuscript);
        int words = countWords(manuscript);
        double percent = (articles/words) * 100;
        return (int)percent;
    }

    public String removeArticles (String str) 
    {
        String minus = "";
        for (int i = 0; i < str.length(); i++) 
        {
            int space = str.indexOf(" ", i);
            String word = str.substring(i, space);
            if (!isArticle(word)) {
                minus += word + " ";
            }
            i += word.length();
        }
        return minus;
    }

    public String[] generateArrayWithoutArticles (String document) 
    {
        int words = countWords(document);
        int articles = countArticles(document);
        int pos = 0;
        String[] array = new String[words - articles];
        for (int i = 0; i < document.length(); i++) 
        {
            int space = document.indexOf(" ", i);
            String word = document.substring(i, space);
            if (!isArticle(word)) 
            {
                array[pos] = word + " ";
                pos++;
            }
            i += word.length();
        }
        return array;
    }
}
