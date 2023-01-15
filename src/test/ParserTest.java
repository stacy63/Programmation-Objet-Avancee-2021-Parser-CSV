import junit.framework.TestCase;
import model.MetroStop;
import org.junit.Assert;
import org.junit.Test;
import parser.Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ParserTest extends TestCase {

    private Parser parser;
    public File file;
    public File file1;

    protected void setUp() throws Exception {
        super.setUp();
        parser = new Parser();
        file = new File("test.csv");
        file1 = new File("empty_file.csv");

        /** Mock d'un fichier csv **/
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("1975#2.33871281165883#48.8844176451841#Abbesses#PARIS-18EME#metro\n" +
                "1981#2.32674567371924#48.828398514348#Alésia#PARIS-14EME#metro\n" +
                "1978#2.3949898158233#48.8561744489676##PARIS-11EME#metro\n" +
                "1978#2.3949898158233#48.8561744489676#Alexandre-Dumas#PARIS-11EME#bus");
        bw.close();

        /** Mock d'un fichier vide **/
        file1.createNewFile();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        parser = null;
        file.delete();
        file1.delete();
    }

    @Test
    public void testParse() throws Exception{

        /** Fichier vide **/
         parser.parse(file1);

         Assert.assertTrue(parser.liste_arrets_metro.isEmpty());

        /** Fichier avec plusieurs cas à tester **/
        parser.parse(file);

            /** premiere ligne **/
        Assert.assertEquals(1975, parser.liste_arrets_metro.get(0).getId());
        Assert.assertEquals(48.8844176451841, parser.liste_arrets_metro.get(0).getLongitude(), 0.00001);
        Assert.assertEquals("Abbesses", parser.liste_arrets_metro.get(0).getNomArret());
        Assert.assertEquals("metro", parser.liste_arrets_metro.get(0).getMoyen_transport());

            /**deuxieme ligne **/
        Assert.assertEquals(2.32674567371924, parser.liste_arrets_metro.get(1).getLatitude(), 0.00001);
        Assert.assertEquals("Alésia", parser.liste_arrets_metro.get(1).getNomArret());
        Assert.assertEquals("PARIS-14EME", parser.liste_arrets_metro.get(1).getArrondissement());

            /**troisieme ligne **/
        Assert.assertEquals(1978, parser.liste_arrets_metro.get(2).getId());
        Assert.assertEquals("", parser.liste_arrets_metro.get(2).getNomArret());
        Assert.assertEquals("metro", parser.liste_arrets_metro.get(2).getMoyen_transport());

            /**verif 4eme ligne absente dans la liste**/
        Assert.assertTrue(!parser.liste_arrets_metro.contains(new MetroStop(1978,(float) 2.3949898158233,(float) 48.8561744489676,
                "Alexandre-Dumas","PARIS-11EME","bus")));
    }
}
