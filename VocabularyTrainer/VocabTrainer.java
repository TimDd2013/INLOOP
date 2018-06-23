import java.util.*;

public class VocabTrainer {
    public static void main(String[] args) {
        QuizProcess process = new QuizProcess(System.in, System.out);
        List<VocabCard> vocabCards = new ArrayList<>();
        vocabCards.add(new VocabCard("go", "gehen"));
        vocabCards.add(new VocabCard("lift", "heben"));
        vocabCards.add(new VocabCard("fall", "fallen"));
        vocabCards.add(new VocabCard("time", "Zeit"));
        vocabCards.add(new VocabCard("house", "Haus"));
        QuizData data = new QuizData(vocabCards, true);

        process.initialize(data);
        while (true) {
            process.update();
            process.input();
        }
    }
}