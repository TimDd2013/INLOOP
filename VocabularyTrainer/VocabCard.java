/**
 * VocabCard
 */
public class VocabCard extends Object{
    private String vocable;
    private String translation;
    public VocabCard(String vocable,String translation){
        if(vocable==null||translation==null) throw new NullPointerException();
        if(vocable==""||translation=="") throw new IllegalArgumentException();
        this.vocable=vocable;
        this.translation=translation;
    }
    /**
     * @return the vocable
     */
    public String getVocable() {
        return vocable;
    }
    /**
     * @return the translation
     */
    public String getTranslation() {
        return translation;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof VocabCard){
            VocabCard v=(VocabCard)obj;
            if (v.getTranslation().equals(this.getTranslation())&&v.getVocable().equals(this.vocable)){
                return true;
            }
        }
        return false;
    }
}