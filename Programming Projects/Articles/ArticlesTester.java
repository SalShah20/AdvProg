/**
 * Write a concise summary of class ArticlesTester here.
 * 
 * @author  (your name) 
 *   With assistance from 
 *
 * @version (a version number or a date) 
 */
public class ArticlesTester 
{
    /* ArticlesTester methods: */

    /**
     * Write a description of method here.
     *
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        // Write your code here
        Articles art = new Articles();

        String word = "ten";
        System.out.println("\nWord: " + word);
        System.out.println("Is article? " + art.isArticle(word));

        word = "an";
        System.out.println("\nWord: " + word);
        System.out.println("Is article? " + art.isArticle(word));

        word = "then";
        System.out.println("\nWord: " + word);
        System.out.println("Is article? " + art.isArticle(word));

        String book = "The quick brown fox jumped over the lazy dog ";
        System.out.println("\nBook: " + book);
        System.out.println("Count words: " + art.countWords(book));

        book = "The quick brown fox jumped over the lazy dog and its bone in theory ";
        System.out.println("\nBook: " + book);
        System.out.println("Count words: " + art.countWords(book));

        String tome = "The quick brown fox jumped over the lazy dog ";
        System.out.println("\nTome: " + tome);
        System.out.println("Count articles: " + art.countArticles(tome));

        tome = "The quick brown fox jumped over the lazy dog and its bone in theory ";
        System.out.println("\nTome: " + tome);
        System.out.println("Count articles: " + art.countArticles(tome));

        String manuscript = "The quick brown fox jumped over the lazy dog ";
        System.out.println("\nManuscript: " + manuscript);
        System.out.println("Percent of articles: " + 
            art.calculateArticlePercentage(manuscript));

        manuscript = "The quick brown fox jumped over the lazy dog and its bone in theory ";
        System.out.println("\nManuscript: " + manuscript);
        System.out.println("Percent of articles: " + 
            art.calculateArticlePercentage(manuscript));

        String str = "The quick brown fox jumped over the lazy dog ";
        System.out.println("\nStr: " + str);
        System.out.println("Without articles: " + art.removeArticles(str));

        str = "The quick brown fox jumped over the lazy dog and its bone in theory ";
        System.out.println("\nStr: " + str);
        System.out.println("Without articles: " + art.removeArticles(str));

        String document = "The quick brown fox jumped over the lazy dog ";
        System.out.println("\nDocument: " + document);
        System.out.println("Array without articles: ");
        String[] array = art.generateArrayWithoutArticles(document);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        document = "The quick brown fox jumped over the lazy dog and its bone in theory ";
        System.out.println("\nDocument: " + document);
        System.out.println("Array without articles: ");
        String[] array1 = art.generateArrayWithoutArticles(document);
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }
}
