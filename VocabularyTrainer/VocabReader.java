import java.io.*;
import java.util.*;
/**
 * VocabReader
 */
public class VocabReader {
    private InputStream vocabFileStream;
    public VocabReader(InputStream vocabFileStream){
        if(vocabFileStream==null) throw new NullPointerException();
        this.vocabFileStream=vocabFileStream;
    }
    public void setVocabFileStream(InputStream vocabFileStream){
        if(vocabFileStream==null) throw new NullPointerException();
        this.vocabFileStream=vocabFileStream;
    }
    public List<VocabCard> read(){
        List<VocabCard> vo=new ArrayList<VocabCard>();;
        Scanner sc=new Scanner(vocabFileStream);
        while(sc.hasNextLine()){
            String line=sc.nextLine();
            if(!line.startsWith("#")){
                vo.add(createVocabCard(line));
            }
        }
        return vo;
    }
    private VocabCard createVocabCard(String line){
        String[] result=line.split(":");
        return new VocabCard(result[0], result[1]);
    }
    
}