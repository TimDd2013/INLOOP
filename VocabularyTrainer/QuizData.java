import java.util.*;

/**
 * QuizData
 */
public class QuizData {
    private CardDrawing cardDrawing;
    private java.util.List<VocabCard> vocabCard;
    private int current;
    public QuizData(List<VocabCard> vocabCard,boolean useCycleRandom){
        if(vocabCard==null||vocabCard.contains(null)) throw new NullPointerException();
        if(vocabCard.equals(Collections.emptyList())) throw new IllegalArgumentException();
        this.vocabCard=vocabCard;
        if (useCycleRandom==true) cardDrawing=new CycleRandom();
        if (useCycleRandom==false) cardDrawing=new CompletelyRandom();
    }
    public int sizeVocab(){
        return vocabCard.size();
    }
    public void drawNext(){
        current=cardDrawing.getNextVocabCardPosition(this.sizeVocab());
    }
    public VocabCard getCurrentVocabCard(){
        return vocabCard.get(current);
    }
    
}