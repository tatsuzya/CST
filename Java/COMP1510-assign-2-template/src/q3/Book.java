package q3;

/**
 * Book.
 * 
 * @author Jay Lin
 * @version 1.0
 */
public class Book {
    /**
     * title type String.
     */
    private String title;
    /**
     * author type String.
     */
    private String author;
    /**
     * publisher type String.
     */
    private String publisher;
    /**
     * copyright date type string.
     */
    private String copyRightDate;

    /**
     * a no argument constructor for object of type book.
     * 
     */
    public Book() {
        title = "";
        author = "";
        publisher = "";
        copyRightDate = "";
    }

    /**
     * constructor with all initializers in param.
     * 
     * @param bookTitle title of the book
     * @param bookAuthor author of the book
     * @param bookPublisher publisher of the book
     * @param bookCopyRightDate CopyRightDate of the book
     */
    public Book(String bookTitle, String bookAuthor, 
            String bookPublisher, String bookCopyRightDate) {
        title = bookTitle;
        author = bookAuthor;
        publisher = bookPublisher;
        copyRightDate = bookCopyRightDate;
    }

    /**
     * get the title of the book.
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * get the author of the book.
     * 
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * get the publisher of the book.
     * 
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * get the copyright date of the book.
     * 
     * @return copyRightDate
     */
    public String getCopyRightDate() {
        return copyRightDate;
    }

    /**
     * set the title of the book.
     * 
     * @param bookTitle
     *            title of the book
     */
    public void setBookTitle(String bookTitle) {
        title = bookTitle;
    }

    /**
     * set the author of the book.
     * 
     * @param bookAuthor
     *            author of the book
     */
    public void setBookAuthor(String bookAuthor) {
        author = bookAuthor;
    }

    /**
     * set the publisher of the book.
     * 
     * @param bookPublisher
     *            publisher of the book
     */
    public void setBookPublisher(String bookPublisher) {
        publisher = bookPublisher;
    }

    /**
     * set the copyright date of the book.
     * 
     * @param bookCopyRightDate
     *            copyright date of the book
     */
    public void setBookCopyRightDate(String bookCopyRightDate) {
        copyRightDate = bookCopyRightDate;
    }

    /**
     * print the result.
     * 
     * @return result of get methods
     */
    public String toString() {
        return "" + getTitle() + "\n" + getAuthor() 
        + "\n" + getPublisher() + "\n" + getCopyRightDate() + "\n";

    }

    /**
     * Bookshelf.
     * 
     * @author jay
     * @version 1.0
     */
    public static class Bookshelf {
        /**
         * Drives the program.
         * 
         * @param args
         *            command line arguments.
         */
        public static void main(String[] args) {
            Book book1;
            Book book2;
            Book book3;
            Book book4;
            Book book5;
            Book book6;

            book1 = new Book();
            book1.setBookTitle("Java Software Solutions");
            book1.setBookAuthor("John Lewis Willaim Loftus");
            book1.setBookPublisher("Pearson");
            book1.setBookCopyRightDate("2014");
            book2 = new Book();
            book2.setBookTitle("Web Development");
            book2.setBookAuthor("Terry Felke-Morris");
            book2.setBookPublisher("Pearson");
            book2.setBookCopyRightDate("2009");
            book3 = new Book();
            book3.setBookTitle("Ajax,JavScript and PHP");
            book3.setBookAuthor("Phil Ballard Michael Moncur");
            book3.setBookPublisher("SAMS");
            book3.setBookCopyRightDate("2010");
            book4 = new Book("Java Software Solutions", 
                    "John Lewis Willaim Loftus", "Pearson", "2014");
            book5 = new Book("Web Development", 
                    "Terry Felke-Morris", "Pearson", "2009");
            book6 = new Book("Ajax,JavScript and PHP", 
                    "Phil Ballard Michael Moncur", "SAMS", "2010");

            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);
            System.out.println(book4);
            System.out.println(book5);
            System.out.println(book6);
            System.out.println("Question three " 
            + "was called and ran sucessfully.");
        }
    }
}
