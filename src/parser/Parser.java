package parser;

import model.MetroStop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<MetroStop> liste_arrets_metro;

    public Parser(){}

    public void parse(File file) throws Exception {
        liste_arrets_metro = new ArrayList<>();
        Reader reader = new FileReader(file);
        BufferedReader bf = new BufferedReader(reader);
        String line;
        while((line = bf.readLine())!= null){
            String[] particule = line.split("#");
            MetroStop arret = new MetroStop();
            arret.setId(Integer.parseInt(particule[0]));
            arret.setLatitude(Float.parseFloat(particule[1]));
            arret.setLongitude(Float.parseFloat(particule[2]));
            arret.setNomArret(particule[3]);
            arret.setArrondissement(particule[4]);
            arret.setMoyen_transport(particule[5]);
            //On ne veut que les arrêts de metro donc les bus et autres ne sont pas à parser
            if (arret.getMoyen_transport().equals("metro")){
                liste_arrets_metro.add(arret);
            }

        }
        bf.close();
    }
}
