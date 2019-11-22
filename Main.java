package JAVAProj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;


public class Main {

    private final static String TITLE = "Gestion de collection de textes :";
    private final static String LOADING_START = "Chargement de %s ...";
    private final static String LOADING_END = " effectué";
    public static final Scanner sc= new Scanner(System.in);


    public static void main(String[] args) {

        // Fournir le Menu aux users :

            BooksLibrary library = new BooksLibrary();
            for(String filename : args){
                try{
                    System.out.print(String.format(LOADING_START, filename));
                    library.add(new Book(filename));
                    System.out.println(LOADING_END);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            boolean [] quitting= new boolean[1];
            List<MenuItem> entries = new ArrayList<MenuItem>();

            entries.add(new ListBooksAction(library));
            entries.add(new AddBookAction(library));
            entries.add(new RemoveBookAction(library));
            entries.add(new BookSelectionAction(library));
            entries.add(new QuitAction(quitting));
            for(Menu menu= new Menu(TITLE, entries); !quitting[0]; menu.doIt()){
            }
        }




        // Lecture du fichier des communes
        ArrayList<City> cityCollection = new ArrayList<>();
        cityCollection = cityTools.readCityCollection();
        for (int i = 0; i < cityCollection.size(); i++) {

            // Case 1 : distance between 1 location point
            // (with a considered longitude/latitude) and a provided city

            double longit = 45.12;
            double latit = 35.35;
            cityCollection.get(i).getDistanceFrom(longit,latit);
            System.out.println("distance 1 : " + cityCollection.get(i).getDistanceFrom(longit,latit));

            // Case 2 : distance between 2 considered city (having long/lati)
            City c2 = new City("Roanne", 46.04,4.07);
            cityCollection.get(i).getDistanceFrom(c2);
            System.out.println("distance 2 : " + cityCollection.get(i).getDistanceFrom(c2));

            // Case 3 : Nearest city between a given city and a set of cities (having long/lati)
            City c3 = new City("La Meauffe",49.183333,-1.116667);
            City c4 = new City("Sacey",48.5,-1.45);
            City c5 = new City("Montainville",48.883333,1.866667);

            ArrayList<City> cityCollectionAround = new ArrayList<City>();
            cityCollectionAround.add(c2);
            cityCollectionAround.add(c3);
            cityCollectionAround.add(c4);
            cityCollectionAround.add(c5);
            Set<City> s= new HashSet<>();
            City.inRadius(10, 10,11,s);
            System.out.println("distance 3 : " +
                    cityCollection.get(i).getNearestCity(cityCollectionAround).getCityName() + " " +
                    cityCollection.get(i).getNearestCity(cityCollectionAround).getCityLatitude() + " " +
                    cityCollection.get(i).getNearestCity(cityCollectionAround).getLongitude());

            // Case 4 : List of cities from a set of cities which are included
            // within a radius around a point.

            // Point de départ Lat/long :
            double lati = 48.8;
            double longi = 5.15;
            // Rayon considéré en km :
            double radius = 50.0;
            ArrayList<City> cityCollectAround = new ArrayList<City>();
            // pour chaque ville du fichier déterminer si celle-ci est dans
            // le rayon autour du point fourni

            if (cityCollection.get(i).isIncludedInArea(longi,lati,radius) == true) {
                cityCollectAround.add(cityCollection.get(i));
                System.out.println(" Ville x : " + cityCollectAround.get(0));
            } else{
                System.out.println(" Ville hors zone");
            }

            // Case 5 : List of cities from a set of cities which are included
            // within 1 radius around y points (here y =3).

            // Point GPS1 Lat/long :
            double lati1 = 53.8;
            double longi1 = 94.95;

            // Point GPS2 Lat/long :
            double lati2 = 50.1;
            double longi2 = 101.20;

            // Point GPS3 Lat/long :
            double lati3 = 56.2;
            double longi3 = 54.70;

            // Rayon considéré en km :
            double radius2 = 80.0;
            ArrayList<City> cityCollectAround2 = new ArrayList<City>();

            // Rajouter la lecture de la liste des villes du fichier (boucle)
            // A chaque lecture passer dans la condition ci-dessous

            if ((cityCollection.get(i).isIncludedInArea(longi1,lati1,radius2) == true)
                    && (cityCollection.get(i).isIncludedInArea(longi2,lati2,radius2) == true)
                    && (cityCollection.get(i).isIncludedInArea(longi3,lati3,radius2) == true)){
                cityCollectAround2.add(cityCollection.get(i));
                System.out.println(" Ville y : " + cityCollectAround.get(0));
            } else{
                System.out.println(" Ville2 hors zone");
            }
        }

    }
}
