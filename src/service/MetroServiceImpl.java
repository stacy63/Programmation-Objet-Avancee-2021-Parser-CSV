package service;

import model.MetroStop;

import java.util.List;

public class MetroServiceImpl implements MetroService{

    public void afficher(List<MetroStop> arrets){
        for(MetroStop metro : arrets){
            System.out.println("ID: " + metro.getId() + ", latitude: " + metro.getLatitude() +
                            ", longitude: " + metro.getLongitude() + ", arrêt: " + metro.getNomArret() +
                    ", arrondissement: " + metro.getArrondissement());
        }
    }

    public void triID(List<MetroStop> arrets){
        arrets.sort((arret1,arret2) -> arret1.getId()-arret2.getId());
    }

    public void triArrondissement(List<MetroStop> arrets){
        arrets.sort((arret1,arret2) -> arret1.getArrondissement().compareTo(arret2.getArrondissement()));
    }

    public void triNomStation(List<MetroStop> arrets){
        arrets.sort((arret1,arret2) -> arret1.getNomArret().compareTo(arret2.getNomArret()));
    }
}
