public class Einwohner{
    protected int einkommen;
    public int zuVersteuerndesEinkommen(){
        return einkommen;
    }
    public int steuer(){
        if (zuVersteuerndesEinkommen()<10)
        {return 1;}
        return zuVersteuerndesEinkommen()/10;
    }
    /**
     * @param einkommen the einkommen to set
     */
    public void setEinkommen(int einkommen) {
        if (einkommen<0){
         
        }
        this.einkommen = einkommen;
    }
    /**
     * @return the einkommen
     */
    public int getEinkommen() {
        return einkommen;
    }
}