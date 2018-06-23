public class Leibeigener extends Bauer{
    @Override
    public int zuVersteuerndesEinkommen() {
        if (einkommen<12){
            return 0;
        }
        return super.zuVersteuerndesEinkommen()-12;
    }
}