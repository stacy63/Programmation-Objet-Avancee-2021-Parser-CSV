package main;

import parser.Parser;
import service.MetroServiceImpl;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv) throws Exception {

        Parser parser = new Parser();
        MetroServiceImpl metroService = new MetroServiceImpl();

        parser.parse(new File("src/ressources/ratp_arret.csv"));

        Scanner sc = new Scanner(System.in);
        boolean fin = false;

        while (!fin) {
            System.out.println("Veuillez choisir le numéro correspondant a votre requête parmi: ");
            System.out.println("1] Afficher les arrêts de métro par id");
            System.out.println("2] Afficher les arrêts de métro par arrondissement");
            System.out.println("3] Afficher les arrêts de métro par nom");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    metroService.triID(parser.liste_arrets_metro);
                    break;
                case 2:
                    metroService.triArrondissement(parser.liste_arrets_metro);
                    break;
                case 3:
                    metroService.triNomStation(parser.liste_arrets_metro);
                    break;
                default:
                    System.out.println("UNEXPECTED OPTION");
                    break;
            }
            metroService.afficher(parser.liste_arrets_metro);
            System.out.println("Avez-vous termine : oui/non");
            sc.nextLine();
            String end = sc.nextLine();
            if (end.equals("oui")) {
                fin = true;
            }
        }
    }
}
