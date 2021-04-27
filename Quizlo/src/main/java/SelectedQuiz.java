import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SelectedQuiz extends JFrame{
    private JPanel jPanelQuiz;
    private JButton question1Button;
    private JButton question2Button;
    private JButton question3Button;
    private JButton question4Button;
    private JRadioButton answerA;
    private JRadioButton answerB;
    private JRadioButton answerC;
    private JRadioButton answerD;
    private JButton confirmButton;
    private JButton returnToCategoryButton;
    private JLabel labelName;
    private JLabel questionLabel;
    private JLabel timerLabel;
    static String quizName;

    NumberFormat format;
    public Timer timer;
    public long initial;
    public long timeStoper2;
    public String timeStoper;
    public long remaining;

    static boolean timeEnded = false;
    static boolean testCompleted = false;

    static ArrayList<Integer> listLastAnswerQuestion =  new ArrayList<>();
    static ArrayList<String> listUserAnswers =  new ArrayList<>(); //keep users answers
    static ArrayList<String> correctAnwsers = new ArrayList<>();

    public JPanel getJPanelQuiz() {
        return jPanelQuiz;
    }

    public int getLastQuestion(){
        return listLastAnswerQuestion.get(listLastAnswerQuestion.size()-1);
    }

    public void selectedAnswer(int lastChosenQuestion) {
        if (answerA.isSelected()) {
           listUserAnswers.set(lastChosenQuestion-1, "A");
        } else if (answerB.isSelected()) {
            listUserAnswers.set(lastChosenQuestion-1, "B");
        } else if (answerC.isSelected()) {
            listUserAnswers.set(lastChosenQuestion-1, "C");
        } else if (answerD.isSelected()) {
            listUserAnswers.set(lastChosenQuestion-1, "D");
        }
    }

    public int points() throws IOException {
        int correctAnswers = 0;
        String quizName_ = quizName.replace('-', ' ');
        int index = AllQuizzesData.indexByNameOfQuiz(quizName_, Categories.giveCategory(quizName));
        String correctOne = AllQuizzesData.allQuizData.get(index+8);
        String correctTwo = AllQuizzesData.allQuizData.get(index+14);
        String correctThree = AllQuizzesData.allQuizData.get(index+20);
        String correctFour = AllQuizzesData.allQuizData.get(index+26);
        correctAnswersLong(correctOne, correctTwo, correctThree, correctFour); //get all of the correct anwsers in order to display them
        if (correctOne.equals(listUserAnswers.get(0))){
            correctAnswers += 1;
        } if (correctTwo.equals(listUserAnswers.get(1))){
            correctAnswers += 1;
        } if (correctThree.equals(listUserAnswers.get(2))) {
            correctAnswers += 1;
        } if (correctFour.equals(listUserAnswers.get(3))){
            correctAnswers += 1;
        }
        return correctAnswers;
    }

    public void correctAnswersLong(String questionOne, String questionTwo, String questionThree, String questionFour) throws IOException {
        String quizName_ = quizName.replace('-', ' ');
        int index = AllQuizzesData.indexByNameOfQuiz(quizName_, Categories.giveCategory(quizName));
        switch (questionOne) {
            case "A":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 4));
                break;
            case "B":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 5));
                break;
            case "C":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 6));
                break;
            case "D":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 7));
                break;
        }
        switch (questionTwo) {
            case "A":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 10));
                break;
            case "B":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 11));
                break;
            case "C":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 12));
                break;
            case "D":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 13));
                break;
        }
        switch (questionThree) {
            case "A":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 16));
                break;
            case "B":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 17));
                break;
            case "C":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 18));
                break;
            case "D":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 19));
                break;
        }
        switch (questionFour) {
            case "A":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 22));
                break;
            case "B":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 23));
                break;
            case "C":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 24));
                break;
            case "D":
                correctAnwsers.add(AllQuizzesData.allQuizData.get(index + 25));
                break;
        }
    }
    public static void reset(){
        listLastAnswerQuestion.clear();
        listUserAnswers.clear();
        correctAnwsers.clear();
        timeEnded = false;
        testCompleted = false;
    }

    public SelectedQuiz(String QuizName) throws IOException { //QuizName zmienić żeby było czytelne no i nie z duzej
        //reset();
        if (!timeEnded && !testCompleted){
            final ButtonGroup questions = new ButtonGroup();

            questions.add(answerA);
            questions.add(answerB);
            questions.add(answerC);
            questions.add(answerD);

            listLastAnswerQuestion.add(1);
            listUserAnswers.add("answ1");
            listUserAnswers.add("answ2");
            listUserAnswers.add("answ3");
            listUserAnswers.add("answ4");

            timeStoper = Categories.giveTime(QuizName);
            updateDisplay(); //odpalenie timera
            //write quiz name
            String quizName_ = QuizName.replace('-', ' ');
            labelName.setText(quizName_);
            quizName = QuizName.replace('-', ' ');
            String category = Categories.giveCategory(QuizName);
            String returnButton = "Return to " + category.toLowerCase() + " category";
            returnToCategoryButton.setText(returnButton);
            fillQuestionOne();

            returnToCategoryButton.addActionListener(new ActionListener() { //problem z tym
                @Override
                public void actionPerformed(ActionEvent e) {
                    Categories.giveCategory(quizName);
                    JFrame searchedCategory = new JFrame("Categories");
                    searchedCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    try {
                        searchedCategory.setContentPane(new SelectedCategory().getJPanelSearchedCategory());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    searchedCategory.pack();
                    searchedCategory.setVisible(true);
                    searchedCategory.setResizable(false);
                    setVisible(false);
                }
            });

            question1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getLastQuestion();
                    selectedAnswer(getLastQuestion());
                    listLastAnswerQuestion.add(1);
                    try {
                        fillQuestionOne();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            });

            question2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getLastQuestion();
                    selectedAnswer(getLastQuestion());
                    listLastAnswerQuestion.add(2);
                    try {
                        fillQuestionTwo();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            });

            question3Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getLastQuestion();
                    selectedAnswer(getLastQuestion());
                    listLastAnswerQuestion.add(3);
                    try {
                        fillQuestionThree();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            });

            question4Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getLastQuestion();
                    selectedAnswer(getLastQuestion());
                    listLastAnswerQuestion.add(4);
                    try {
                        fillQuestionFour();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            });

            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // run to score
                    testCompleted = true;
                    if(timeEnded){
                    } else {
                        try {
                            listLastAnswerQuestion.add(getLastQuestion());
                            selectedAnswer(getLastQuestion());

                            new SelectedQuiz(quizName);
                            setVisible(false);
                        } catch (IOException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    }
                }
            });
        } else if (timeEnded || testCompleted) {

            int allPoints = points();
            JFrame score = new JFrame("Your Score");
            score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            score.setContentPane(new Score(allPoints, correctAnwsers).getJPanelScore());
            score.pack();
            score.setVisible(true);
            score.setResizable(false);
            setVisible(false);
            setLocationByPlatform(true);
        }
    }

    public static String minusestospace3(String txt){
        String txt_ = txt.replace("-"," ");
        return txt_;
    }

    public void fillQuestionOne() throws IOException {
        String quizName2 = quizName.replace(' ', '-');
        int index = AllQuizzesData.indexByNameOfQuiz(quizName2, Categories.giveCategory(quizName));
        questionLabel.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+3)));
        answerA.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+4)));
        answerB.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+5)));
        answerC.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+6)));
        answerD.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+7)));
    }

    public void fillQuestionTwo() throws IOException {
        String quizName2 = quizName.replace(' ', '-');
        int index = AllQuizzesData.indexByNameOfQuiz(quizName2, Categories.giveCategory(quizName));
        questionLabel.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+9)));
        answerA.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+10)));
        answerB.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+11)));
        answerC.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+12)));
        answerD.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+13)));
    }

    public void fillQuestionThree() throws IOException {
        String quizName2 = quizName.replace(' ', '-');
        int index = AllQuizzesData.indexByNameOfQuiz(quizName2, Categories.giveCategory(quizName));
        questionLabel.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+15)));
        answerA.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+16)));
        answerB.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+17)));
        answerC.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+18)));
        answerD.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+19)));
    }

    public void fillQuestionFour() throws IOException {
        String quizName2 = quizName.replace(' ', '-');
        int index = AllQuizzesData.indexByNameOfQuiz(quizName2, Categories.giveCategory(quizName));
        questionLabel.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+21)));
        answerA.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+22)));
        answerB.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+23)));
        answerC.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+24)));
        answerD.setText(minusestospace3(AllQuizzesData.allQuizData.get(index+25)));
    }

    //timer
    //this method will run when user presses the start button
    void updateDisplay() throws FileNotFoundException {
        Timeclass tc = new Timeclass();
        timer = new Timer(1000, tc);
        initial = System.currentTimeMillis();
        timer.start();
    }

    //code that is invoked by swing timer for every second passed
    public class Timeclass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            remaining = convertTime();
            long current = System.currentTimeMillis();
            long elapsed = current - initial;
            remaining -= elapsed;

            format = NumberFormat.getNumberInstance();
            format.setMinimumIntegerDigits(2);

            if (remaining < 0)
                remaining = (long) 0;
            int minutes = (int) (remaining / 60000);
            int seconds = (int) ((remaining % 60000) / 1000);

            timerLabel.setText(format.format(minutes) + ":"
                    + format.format(seconds));

            if (remaining == 0) { //when time is ending
                timerLabel.setText("00:00");
                timeEnded = true;

                if(testCompleted){
                    //nothing happens, because the test ended anyways
                } else {
                    selectedAnswer(getLastQuestion());
                    try {
                        new SelectedQuiz(quizName);
                        setVisible(false);
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
                timer.stop();
            }
        }
    }

    // first need to convert no. of minutes from string to long.
    // then need to convert that to milliseconds.
    public long convertTime() {
        timeStoper2 = Long.parseLong(timeStoper); //minutes -> s *60 *1000 ms
        long converted = (timeStoper2 * 1000) + 1000;
        return converted;
    }
}
