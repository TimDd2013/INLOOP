import java.util.*;
/**
 * TextFileIterator
 */
public class TextFileIterator implements Iterator<String>{
    private String text;
    private String nextWord;
    public TextFileIterator(Resource res){
        if (res==null) throw new NullPointerException();
        text=this.getAsString(res);
        text = text.replaceAll("-\n(?=[a-z])","");
        nextWord=this.extractNextWord();
        //nextWord=this.nextNextWord();
    };
    @Override
    public boolean hasNext() {
        return nextWord !=null;
    }
    @Override
    public String next() {
        if (this.hasNext()==false) throw new NoSuchElementException();
        String a=nextWord;
        nextWord=this.extractNextWord();
        return a;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    public String getAsString(Resource res){
        return "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    };    
    private String extractNextWord(){
        int beginIdx=0;
        while (beginIdx<text.length()&&!Character.isLetter(text.charAt(beginIdx))&&!Character.isDigit(text.charAt(beginIdx))){
            beginIdx++;
        }
        int idx=beginIdx;
        while (idx<text.length()&&(Character.isLetter(text.charAt(idx))||Character.isDigit(text.charAt(idx)))){
            idx++;
        }
        if(beginIdx==idx){
            return null;
        }
        String word=text.substring(beginIdx,idx);
        text=text.substring(idx);
        return word;
    }
}