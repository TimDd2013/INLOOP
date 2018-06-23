import java.util.*;

/**
 * JIdea
 */
public class JIdea extends JContent{
    private List<JAttachment> attachments;
    private JState state;
    public JIdea(String title,String description){
        super(title, description);
        attachments=new ArrayList<JAttachment>();
        state=new Draft();
    }
    public void discuss(String text){
        state.discuss(text);
    };
    public void hold(){
        state.hold();
    };
    public void release(){
        state.release();
    };
    public void decline(){
        state.decline();
    };
    public void evaluate(JValuation valuation){
        state.evaluate(valuation);
    }
    public boolean isDeclined(){
        return state instanceof DeclinedIdea;
    }
    public boolean isReleased(){
        return state instanceof ReleasedIdea;
    }
    public String getCurrentDiscussion(){
        return state.getCurrentDiscussion();
    }
    public JValuation getValuation(){
        return state.getValuation();
    }
    /**
     * @return the attachments
     */
    public List<JAttachment> getAttachments() {
        return attachments;
    }
    public void addAttachment(JAttachment attachment) {
        if (attachment==null) throw new NullPointerException();
        attachments.add(attachment);
    }
    public boolean removeAttachment(JAttachment attachment){
        if (attachment==null) throw new NullPointerException();
        if (!attachments.contains(attachment)) return false;
        attachments.remove(attachment);
        return true;
    }
    @Override
    public String toString() {
        return "Idea: "+this.getTitle()+"\n"+this.getDescription();
    }
    public abstract class JState {
        private String currentDiscussion;
        private JValuation valuation;
        public abstract void discuss(String text);
        public abstract void evaluate(JValuation valuation);
        public abstract void hold();
        public abstract void release();
        public abstract void decline();
        /**
         * @return the currentDiscussion
         */
        public String getCurrentDiscussion() {
            return currentDiscussion;
        }
        /**
         * @param currentDiscussion the currentDiscussion to set
         */
        public void setCurrentDiscussion(String currentDiscussion) {
            this.currentDiscussion = currentDiscussion;
        }
        /**
         * @return the valuation
         */
        public JValuation getValuation() {
            return valuation;
        }
        /**
         * @param valuation the valuation to set
         */
        public void setValuation(JValuation valuation) {
            this.valuation = valuation;
        }
    }
    public class Draft extends JState{
        @Override
        public void hold() {
            state=new OpenDraft();
        }
        @Override
        public void decline() {
            state=new DeclinedIdea();
        }
        @Override
        public void release() {
            throw new IllegalStateException();
        }
        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException();
        }
        @Override
        public void discuss(String text) {
            throw new IllegalStateException();
        }
    }
    public class OpenDraft extends JState{
        @Override
        public void hold() {
            state=new ApprovedIdea();
        }
        @Override
        public void decline() {
            state=new DeclinedIdea();
        }
        @Override
        public void release() {
            throw new IllegalStateException();
        }
        @Override
        public void evaluate(JValuation valuation) {
            if (valuation==null) throw new NullPointerException();
            this.setValuation(valuation);
        }
        @Override
        public void discuss(String text) {
            if (text==null) throw new NullPointerException();
            if (text=="") throw new IllegalArgumentException();
            if(getCurrentDiscussion()==null) this.setCurrentDiscussion(text+"\n");
            else if(getCurrentDiscussion()!=null) this.setCurrentDiscussion(getCurrentDiscussion()+text+"\n");
        }
    }
    public class ApprovedIdea extends JState{
        @Override
        public void hold() {
            throw new IllegalStateException();
        }
        @Override
        public void decline() {
            throw new IllegalStateException();
        }
        @Override
        public void release() {
            state=new ReleasedIdea();
        }
        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException();
        }
        @Override
        public void discuss(String text) {
            throw new IllegalStateException();
        }
    }
    public class ReleasedIdea extends JState{
        @Override
        public void hold() {
            throw new IllegalStateException();
        }
        @Override
        public void decline() {
            throw new IllegalStateException();
        }
        @Override
        public void release() {
            throw new IllegalStateException();
        }
        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException();
        }
        @Override
        public void discuss(String text) {
            throw new IllegalStateException();
        }
    }
    public class DeclinedIdea extends JState{
        @Override
        public void hold() {
            throw new IllegalStateException();
        }
        @Override
        public void decline() {
            throw new IllegalStateException();
        }
        @Override
        public void release() {
            throw new IllegalStateException();
        }
        @Override
        public void evaluate(JValuation valuation) {
            throw new IllegalStateException();
        }
        @Override
        public void discuss(String text) {
            throw new IllegalStateException();
        }
    }
}