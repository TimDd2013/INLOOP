/**
 * CardDrawing
 */
public abstract class CardDrawing {
    public abstract int getNextVocabCardPosition(int sizeVocab);
    public int random(int max){
        if(max<=0) throw new IllegalArgumentException();
        return (int)(Math.random()*max);
    };
}