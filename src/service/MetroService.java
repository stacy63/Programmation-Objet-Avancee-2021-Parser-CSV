package service;

import model.MetroStop;

import java.util.List;

public interface MetroService {

    public void triID(List<MetroStop> arrets);

    public void triArrondissement(List<MetroStop> arrets);

    public void triNomStation(List<MetroStop> arrets);
}
