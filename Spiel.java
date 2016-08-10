/**
 * Created by spoppe on 04.08.2016.
 */

import javax.swing.*;
import java.util.ArrayList;


public class Spiel {
    public static final int SPIELVORBEI = 3;

    public static void Schiffeversenken() {
        System.out.println("Versenken sie das Schiff! Es liegt irgendwo im Raster zwischen A0 und G6 \n");


        ArrayList<Schiff> schiffListe = new ArrayList<>();
        Schiff weser = new Schiff("Weserkrone");
        Schiff black = new Schiff("Black Pearl");
        Schiff gorch = new Schiff("Gorch Fock");
        schiffListe.add(weser);
        schiffListe.add(black);
        schiffListe.add(gorch);
        Helfer helfer = new Helfer();

        int zähler = 0;

        boolean getroffen;

        while (!schiffListe.isEmpty()) {
            String spielerTipp = JOptionPane.showInputDialog("Auf welche Stelle wollen sie schießen?");
            spielerTipp = helfer.eingabenAuswerter(spielerTipp);
            int spielerTippInt = Integer.parseInt(spielerTipp);
            if (spielerTippInt < 0 || spielerTippInt > 49) {
                System.out.println("Bitte geben sie eine Kombination aus Buchstabe von A-G und Zahl von 0-6 ein! (z.B C6)");
                continue;
            }

            int trefferZähler = 0;
            for(int i =0;i<schiffListe.size();i++) {

                getroffen = schiffListe.get(i).prüfDich(spielerTipp);
                if(getroffen){trefferZähler++;}
                if (!schiffListe.get(i).isÜberWasser()){
                    schiffListe.remove(i);
                }
            }
            if(trefferZähler==0){System.out.println("Verfehlt!");}
            zähler++;
        }

        System.out.println("\nHerzlichen Glückwunsch! Sie haben die Schiffe in " + zähler + " Versuchen versenkt!");
    }
}

