/**
 * EinwohnerText extends TestCase
 */
public class EinwohnerText extends TestCase {
    protected Einwohner einwohner;
    /**
     * @param einwohner the einwohner to set
     */
    public void setUp(){
        einwohner=new Einwohner();
    }
    public void testE1(){
        try{
            einwohner.setEinkommen(-1);
            fail("keine Exe");
        }catch(IllegalArgumentException e){
            assertEquals("einkommen<0",e.getMessage());
        }catch(Exception e){
            fail("nicht erwartete Exception");
        }
    }
    public void testE4(){
            einwohner.setEinkommen(25);
    assertEquals(2,einwohner.steuer());
    }

}