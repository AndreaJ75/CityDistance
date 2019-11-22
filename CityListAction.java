package JAVAProj;

public class CityListAction implements MenuItem {

        private final static String LABEL= "Distance between one location (lat/long) point and a city";
        private final BooksLibrary library;

        public ListBooksAction (BooksLibrary library){
            this.library = library;
        }
        public String getLabel(){
            return LABEL;
        }
        public void doIt(){
            for(Book book : library.getBooks()){
                System.out.println(book.getFilename());
            }
        }
}
