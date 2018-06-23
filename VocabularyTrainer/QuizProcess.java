import java.io.*;
import java.util.Scanner;

/**
 * QuizProcess
 */
public class QuizProcess{
    private State currentState;
    private QuizData data;
    private Scanner in;
    private PrintStream out;
    public QuizProcess(InputStream inStream,OutputStream outStream){
        if (inStream==null||outStream==null) throw new NullPointerException();
        in=new Scanner(inStream);
        out=new PrintStream(outStream);
    }
    public abstract class State {
        public void updateUI(){};
        public void update(){};
        public void input(){};
        public void setSolution(String solution){};
    }
    public class StartState extends State {
        @Override
        public void updateUI() {
            super.updateUI();
        }
        @Override
        public void update() {
            if (currentState instanceof StartState) setState(new AskingState());
            out.print("what's the translation from "+getCurrentVocabCard().getVocable()+"?");
        }
        @Override
        public void input() {
            throw new IllegalStateException();
        }   
    }
    public class AskingState extends State{
        @Override
        public void updateUI() {
            //super.updateUI();
        }
        @Override
        public void input() {
            setState(new SolutionState());
            if(in.next().equals(getCurrentVocabCard().getTranslation())){
                out.print("Correct!");
                return;
            }
            out.print("Wrong!");
        }
        @Override
        public void update() {
            throw new IllegalStateException();
        }
    }
    public class SolutionState extends State{
        private String solution;
        @Override
        public void updateUI() {
            super.updateUI();
        }
        @Override
        public void update() {
            setState(new AskingState());
            drawNext();
            out.print("what's the translation from"+getCurrentVocabCard().getVocable()+"?");
        }
        @Override
        public void setSolution(String solution) {
            if(solution==null) throw new NullPointerException();
            if(solution=="") throw new IllegalArgumentException();
            this.solution=solution;
        }
        @Override
        public void input() {
            throw new IllegalStateException();
        }
    }
    private void setState(State newState){
        if(newState==null) throw new NullPointerException();
        this.currentState=newState;
    }
    public void initialize(QuizData data){
        if(data==null) throw new NullPointerException();
        if(currentState!=null) throw new IllegalStateException();
        setState(new StartState());
        out.print("welcome");
        this.data=data;
    }
    private void updateUI(){
        this.currentState.updateUI();
    }
    public void update(){
        if(currentState==null) throw new IllegalStateException();
        this.currentState.update();
        //drawNext();
        //updateUI();
    }
    public void input(){
        if(currentState==null) throw new IllegalStateException();
        this.currentState.input();
    }
    private void setSolution(String solution){
        if(currentState==null) throw new IllegalStateException();
        this.currentState.setSolution(solution);
    }
    private void drawNext(){
        this.data.drawNext();
    }
    private VocabCard getCurrentVocabCard(){
        return this.data.getCurrentVocabCard();
    }
    
}