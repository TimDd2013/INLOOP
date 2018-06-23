/**
 * CompletelyRandom
 */
public class CompletelyRandom extends CardDrawing{
    @Override
    public int getNextVocabCardPosition(int sizeVocab) {
        if(sizeVocab<=0) throw new IllegalArgumentException();
        return super.random(sizeVocab);
    }
}