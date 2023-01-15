package model;

public class MetroStop {

    public int id;

    public double latitude;

    public double longitude;

    public String nom_arret;

    public String arrondissement;

    public String moyen_transport;

    /** CONSTRUCTEUR **/

    public MetroStop(){
        nom_arret = "";
        arrondissement = "";
        moyen_transport = "";
    }

    public MetroStop(int id, double latitude, double longitude, String nom_arret, String arrondissement, String moyen_transport){
        this.id=id;
        this.latitude=latitude;
        this.longitude=longitude;
        this.nom_arret=nom_arret;
        this.arrondissement=arrondissement;
        this.moyen_transport=moyen_transport;
    }

    /** GETTER **/

    public int getId(){ return id; }

    public double getLatitude(){ return latitude; }

    public double getLongitude(){ return longitude; }

    public String getNomArret(){ return nom_arret; }

    public String getArrondissement(){ return arrondissement; }

    public String getMoyen_transport(){ return moyen_transport; }

    /** SETTER **/

    public void setId(int id){ this.id=id; }

    public void setLatitude(double latitude){ this.latitude=latitude; }

    public void setLongitude(double longitude){ this.longitude=longitude; }

    public void setNomArret(String nom_arret){ this.nom_arret=nom_arret; }

    public void setArrondissement(String arrondissement){ this.arrondissement=arrondissement; }

    public void setMoyen_transport(String moyen_transport){ this.moyen_transport=moyen_transport; }
}
