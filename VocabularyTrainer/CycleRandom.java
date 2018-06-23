import java.util.ArrayList;
import java.util.List;

/**
 * CycleRandom
 */
public class CycleRandom extends CardDrawing{
    List<Integer> cycleList;
    @Override
    public int getNextVocabCardPosition(int sizeVocab) {
        if(sizeVocab<=0) throw new IllegalArgumentException();
        if(cycleList==null){
            initializeCycleList(sizeVocab);
        }
        int result=removeRandomFromCycleList();
        if(cycleList.size()==0){
            initializeCycleList(sizeVocab);
        }
        return result;
    }
    private void initializeCycleList(int sizeVocab){
        cycleList=new ArrayList<Integer>();
        for(int i=0;i<sizeVocab;i++){
            cycleList.add(i);
        }
        for(int i=0;i<(sizeVocab*10);i++){
            int a=super.random(sizeVocab);
            int b=super.random(sizeVocab);
            int c=cycleList.get(a);
            cycleList.set(a, cycleList.get(b));
            cycleList.set(b, c);
        }
    }
    private int removeRandomFromCycleList(){
        int result=cycleList.get(0);
        cycleList.remove(0);
        return result;
    }
}