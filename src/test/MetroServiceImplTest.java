import junit.framework.TestCase;
import model.MetroStop;
import org.junit.Test;
import org.junit.Assert;
import service.MetroServiceImpl;
import java.util.ArrayList;
import java.util.List;


public class MetroServiceImplTest extends TestCase {

    private MetroServiceImpl metroService;

    List<MetroStop> list = new ArrayList<>();

    MetroStop ms1, ms2, ms3, ms4, msv1, msv2, msv3;

    @Test
    public void minimal(){
        //assertEquals(true, true);
        Assert.assertTrue(true);
    }

    protected void setUp() throws Exception {
        super.setUp();
        metroService = new MetroServiceImpl();

        /** Mock de MetroStop **/
        ms1 = new MetroStop(1999, 2.34973719426844,48.8836207315381,
                "Barbès-Rochechouart","pARIS-09EME", "metro");
        list.add(ms1);
        ms2 = new MetroStop(50622, 2.35941471750625, 48.9366033097107,
                "Basilique  de Saint-Denis","SAINT-DENIS", "metro");
        list.add(ms2);
        ms3 = new MetroStop(1915, 2.32282484061213, 48.8787098768874,
                "Europe","PARIS-08EME", "metro");
        list.add(ms3);
        ms4 = new MetroStop(1672,  2.27762632988678, 48.8641004131629,
                "Rue de la Pompe (Avenue Georges Mandel)","PARIS-16EME", "metro");
        list.add(ms4);

        /** Mock de MetroStop avec valeurs vides**/
        msv1 = new MetroStop();
        list.add(msv1);

        msv2 = new MetroStop(1907, 2.29276958714394,48.8508056365633,
                "Dupleix","", "metro");
        list.add(msv2);

        msv3 = new MetroStop(1908, 2.31672285703746, 48.8467835319339, "",
                "PARIS-07EME","metro");
        list.add(msv3);

    }

    protected void tearDown() throws Exception {
        super.tearDown();
        metroService = null;
        ms1 = null;
        ms2 = null;
        ms3 = null;
        ms4 = null;
    }

    @Test
    public void testTriID(){

        metroService.triID(list);

        Assert.assertTrue(list.get(0).equals(msv1));
        Assert.assertTrue(list.get(1).equals(ms4));
        Assert.assertTrue(list.get(2).equals(msv2));
        Assert.assertTrue(list.get(3).equals(msv3));

        Assert.assertTrue(list.get(4).equals(ms3));
        Assert.assertTrue(list.get(5).equals(ms1));
        Assert.assertTrue(list.get(6).equals(ms2));

    }

    @Test
    public void testTriArrondissement(){

        metroService.triArrondissement(list);

        Assert.assertTrue(list.get(0).equals(msv1));
        Assert.assertTrue(list.get(1).equals(msv2));
        Assert.assertTrue(list.get(2).equals(msv3));
        Assert.assertTrue(list.get(3).equals(ms3));
        Assert.assertTrue(list.get(4).equals(ms4));
        Assert.assertTrue(list.get(5).equals(ms2));
        Assert.assertTrue(list.get(6).equals(ms1));

    }

    @Test
    public void testTriNomStation(){

        metroService.triNomStation(list);

        Assert.assertTrue(list.get(0).equals(msv1));
        Assert.assertTrue(list.get(1).equals(msv3));
        Assert.assertTrue(list.get(2).equals(ms1));
        Assert.assertTrue(list.get(3).equals(ms2));
        Assert.assertTrue(list.get(4).equals(msv2));
        Assert.assertTrue(list.get(5).equals(ms3));
        Assert.assertTrue(list.get(6).equals(ms4));
    }
}
