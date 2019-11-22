package JAVAProj;

import java.util.List;
import java.util.InputMismatchException;

public class Menu {
    private final static String PROMPT= "Saisissez le numéro de votre choix (entier entre 1 et %d):";
    private final static String ENTRY_MESSAGE = "%d. %s";
    private final static String ERROR_MESSAGE= "Saisie invalide";

    private String title;
    private final List<MenuItem> entries;

    public Menu(String title, List<MenuItem> entries){
        this.title = title;
        this.entries = entries;
    }
    /*retourn l'indice commençant à 0 et non la saisie (à partir de 1)
     */
    private int getChoice(){
        int res = -1;
        do{
            try {
                System.out.println(String.format(PROMPT, entries.size()));
                res = Main.sc.nextInt();
                Main.sc.nextLine();
            }catch(InputMismatchException e){
                System.err.println(ERROR_MESSAGE);
                Main.sc.nextLine();
            }
        }while((res < 1) || (res > entries.size()));
        return res - 1;
    }

    public void doIt(){
        System.out.println(title);
        for(int i= 0; i != entries.size(); ++i){
            System.out.println(String.format(ENTRY_MESSAGE, i+1, entries.get(i).getLabel()));
        }
        entries.get(getChoice()).doIt();
    }
}