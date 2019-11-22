package JAVAProj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class cityTools {

    public static ArrayList readCityCollection() {

        final String path = "/home/bnp-renault-005/Bureau/ANDY/SESSIONS/corp-bnp-renault/session1/ressource/Communes.csv";
        ArrayList<City> cityCollection = new ArrayList<>();

        File infile = new File(path);
        try (BufferedReader bufferR = new BufferedReader(new FileReader(infile))) {
            String lineRead ; // = bufferR.readLine();
           // boolean topFirstRead = false;
            while ((lineRead = bufferR.readLine()) != null) { //SI ON VEUT SAUTER LA LIGNE 1, METTRE LA LECTURE DANS LA CONDITION WHILE
                String[] tabCity = lineRead.split(";");

                try {
                    City newCity = new City(tabCity[0], Double.parseDouble(tabCity[1]), Double.parseDouble(tabCity[2]));
                    cityCollection.add(newCity);
                } catch (Exception e){
                    System.out.println("Données non conforme");
                }
            // System.out.println("city added: " + newCity);
            }
        }
        catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
            System.out.println("libellé erreur : " + e.getMessage());
            System.out.println("Veuillez corriger l\'origine du pb avant de relancer l'application");
        }
        return cityCollection;
    }

//    private static void initMenus(HashMap mainMenuChoices String choice) {
//
//        switch (choice) {
//
//            case "1" :
//                mainMenuChoices.put("1", "Lister les fichiers");
//                mainMenuChoices.put("2", "Ajouter un fichier");
//                mainMenuChoices.put("3", "Supprimer un fichier");
//                mainMenuChoices.put("4", "Afficher des informations sur un livre");
//                mainMenuChoices.put("5", "Quitter le programme");
//                break;
//            case "2" :
//
//
//        }
//
//    }
//    private static String showMenu(Map<String, String> menuPossibleChoiceMap) {
//        ArrayList<String> menuPossibleChoiceList = new ArrayList<>();
//        System.out.println("----------- Statistiques sur les livres ----------");
//        for (Map.Entry<String, String> menuChoice : menuPossibleChoiceMap.entrySet()) {
//            System.out.print(menuChoice.getKey());
//            System.out.print(". --> ");
//            System.out.println(menuChoice.getValue());
//
//            menuPossibleChoiceList.add(menuChoice.getKey());
//        }
//        System.out.println("----------- ########################### ----------");
//
//        return getUserChoice(menuPossibleChoiceList);
//    }

}
