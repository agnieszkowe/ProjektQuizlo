import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Creation extends JFrame{
    private JPanel jPanelQuizCreation;
    private JLabel patternLeft;
    private JLabel patternRight;
    private JPanel Quiz1;
    private JPanel Quiz2;
    private JPanel Quiz3;
    private JPanel Quiz4;
    private JButton returnToMainSiteButton;
    private JRadioButton categoryAnimals;
    private JRadioButton categoryPlants;
    private JRadioButton categoryPeople;
    private JRadioButton categoryScience;
    private JRadioButton categoryMusic;
    private JRadioButton categoryOther;
    private JTextField quiz1TextFieldQuestion1;
    private JTextField quiz1TextFieldA1;
    private JTextField quiz1TextFieldB1;
    private JTextField quiz1TextFieldC1;
    private JTextField quiz1TextFieldD1;
    private JRadioButton quiz1RadioButtonA1;
    private JRadioButton quiz1RadioButtonB1;
    private JRadioButton quiz1RadioButtonC1;
    private JRadioButton quiz1RadioButtonD1;
    private JTextField quiz1TextFieldQuestion2;
    private JTextField quiz1TextFieldA2;
    private JTextField quiz1TextFieldB2;
    private JTextField quiz1TextFieldC2;
    private JTextField quiz1TextFieldD2;
    private JRadioButton quiz1RadioButtonA2;
    private JRadioButton quiz1RadioButtonB2;
    private JRadioButton quiz1RadioButtonC2;
    private JRadioButton quiz1RadioButtonD2;
    private JTextField quiz1TextFieldQuestion3;
    private JTextField quiz1TextFieldA3;
    private JTextField quiz1TextFieldB3;
    private JTextField quiz1TextFieldC3;
    private JTextField quiz1TextFieldD3;
    private JRadioButton quiz1RadioButtonA3;
    private JRadioButton quiz1RadioButtonB3;
    private JRadioButton quiz1RadioButtonC3;
    private JRadioButton quiz1RadioButtonD3;
    private JTextField quiz1TextFieldQuestion4;
    private JTextField quiz1TextFieldA4;
    private JTextField quiz1TextFieldB4;
    private JTextField quiz1TextFieldC4;
    private JTextField quiz1TextFieldD4;
    private JRadioButton quizRadioButtonA4;
    private JRadioButton quizRadioButtonB4;
    private JRadioButton quizRadioButtonC4;
    private JRadioButton quizRadioButtonD4;
    private JLabel quizName;
    private JTextField quizNameJField;
    private JPanel JPanel;
    private JButton addButton;
    private JButton clearFieldsButton;
    private JTextField timeTextField;

    //creating them kinda "globally" so i can read them from if statement (add private -- will it work??)
    static String dataQuiz1[];
    static String dataQuiz2[];
    static String dataQuiz3[];
    static String dataQuiz4[];
    static String category;
    static String name;
    static String time;

    public JPanel getJPanelQuizCreation() {
    return jPanelQuizCreation;
  }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        patternLeft = new JLabel(new ImageIcon("Images/patternSearchedCategory2.png")); //TO CHANGE
        patternRight = new JLabel(new ImageIcon("Images/patternSearchedCategory2.png")); //TO CHANGE
    }

    public Creation () {
        final ButtonGroup question1 = new ButtonGroup();
        final ButtonGroup question2 = new ButtonGroup();
        final ButtonGroup question3 = new ButtonGroup();
        final ButtonGroup question4 = new ButtonGroup();
        final ButtonGroup categories = new ButtonGroup();

        question1.add(quiz1RadioButtonA1);
        question1.add(quiz1RadioButtonB1);
        question1.add(quiz1RadioButtonC1);
        question1.add(quiz1RadioButtonD1);

        question2.add(quiz1RadioButtonA2);
        question2.add(quiz1RadioButtonB2);
        question2.add(quiz1RadioButtonC2);
        question2.add(quiz1RadioButtonD2);

        question3.add(quiz1RadioButtonA3);
        question3.add(quiz1RadioButtonB3);
        question3.add(quiz1RadioButtonC3);
        question3.add(quiz1RadioButtonD3);

        question4.add(quizRadioButtonA4);
        question4.add(quizRadioButtonB4);
        question4.add(quizRadioButtonC4);
        question4.add(quizRadioButtonD4);

        categories.add(categoryAnimals);
        categories.add(categoryPlants);
        categories.add(categoryPeople);
        categories.add(categoryScience);
        categories.add(categoryMusic);
        categories.add(categoryOther);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fetch data from text fields
                //fetching quizzes names so its not the same

                //Question 1
                if(quiz1TextFieldQuestion1.getText().equals("") || quiz1TextFieldA1.getText().equals("") || quiz1TextFieldB1.getText().equals("") || quiz1TextFieldC1.getText().equals("") || quiz1TextFieldD1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,  "Fill in all text fields in question 1!", "Question 1 error", JOptionPane.ERROR_MESSAGE);
                } else if(quizNameJField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,  "Enter a quiz name!", "Quiz name error", JOptionPane.ERROR_MESSAGE);
                } else if (question1.getSelection() == null){
                    JOptionPane.showMessageDialog(null,  "Choose the correct answer to Question 1!", "Question 1 error", JOptionPane.ERROR_MESSAGE);
                } else if (categories.getSelection() == null ){ // i think one statement like this will be enough since it will be checked here anyways -- need to check this tho
                    JOptionPane.showMessageDialog(null,  "Select category!", "Category error", JOptionPane.ERROR_MESSAGE);
                } else if (timeTextField.getText().equals("")) { //this doesnt check if the data is correct tho...
                  JOptionPane.showMessageDialog(null, "Enter the time for the quiz!", "Time error", JOptionPane.ERROR_MESSAGE);
                } else {
                    name = quizNameJField.getText();
                    time = timeTextField.getText();

                    String question1quiz1 = quiz1TextFieldQuestion1.getText();
                    String anwserAquiz1 = quiz1TextFieldA1.getText();
                    String anwserBquiz1 = quiz1TextFieldB1.getText();
                    String anwserCquiz1 = quiz1TextFieldC1.getText();
                    String anwserDquiz1 = quiz1TextFieldD1.getText();
                    String correctAnwserQuiz1 = "";
                    if(quiz1RadioButtonA1.isSelected()){
                        correctAnwserQuiz1 = "A";
                    } else if (quiz1RadioButtonB1.isSelected()){
                        correctAnwserQuiz1 = "B";
                    } else if(quiz1RadioButtonC1.isSelected()) {
                        correctAnwserQuiz1 = "C";
                    } else if(quiz1RadioButtonD1.isSelected()) {
                        correctAnwserQuiz1 = "D";
                    }
                    //did only once bcs i will use this "globally"
                    if(categoryAnimals.isSelected()){
                        category = "Animals";
                    } else if (categoryPlants.isSelected()){
                        category = "Plants";
                    } else if(categoryPeople.isSelected()) {
                        category = "People";
                    } else if(categoryScience.isSelected()) {
                        category = "Science";
                    } else if(categoryMusic.isSelected()) {
                        category = "Music";
                    } else if(categoryOther.isSelected()) {
                        category = "Other";
                    }
                    dataQuiz1 = new String[]{question1quiz1, anwserAquiz1, anwserBquiz1, anwserCquiz1, anwserDquiz1, correctAnwserQuiz1};
                }

                //Question 2
                if(quiz1TextFieldQuestion2.getText().equals("") || quiz1TextFieldA2.getText().equals("") || quiz1TextFieldB2.getText().equals("") || quiz1TextFieldC2.getText().equals("") || quiz1TextFieldD2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,  "Fill in all text fields in question 2!", "Question 2 error", JOptionPane.ERROR_MESSAGE);
                } else if (question2.getSelection() == null) {
                    JOptionPane.showMessageDialog(null,  "Choose the correct answer to Question 2!", "Question 2 error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String question1quiz2 = quiz1TextFieldQuestion2.getText();
                    String anwserAquiz2 = quiz1TextFieldA2.getText();
                    String anwserBquiz2 = quiz1TextFieldB2.getText();
                    String anwserCquiz2 = quiz1TextFieldC2.getText();
                    String anwserDquiz2 = quiz1TextFieldD2.getText();
                    String correctAnwserQuiz2 = "";
                    if(quiz1RadioButtonA2.isSelected()){
                        correctAnwserQuiz2 = "A";
                    } else if (quiz1RadioButtonB2.isSelected()){
                        correctAnwserQuiz2 = "B";
                    } else if(quiz1RadioButtonC2.isSelected()) {
                        correctAnwserQuiz2 = "C";
                    } else if(quiz1RadioButtonD2.isSelected()) {
                        correctAnwserQuiz2 = "D";
                    }
                    dataQuiz2 = new String[]{question1quiz2, anwserAquiz2, anwserBquiz2, anwserCquiz2, anwserDquiz2, correctAnwserQuiz2};
                }

                //Question 3
                if(quiz1TextFieldQuestion3.getText().equals("") || quiz1TextFieldA3.getText().equals("") || quiz1TextFieldB3.getText().equals("") || quiz1TextFieldC3.getText().equals("") || quiz1TextFieldD3.getText().equals("")){
                    JOptionPane.showMessageDialog(null,  "Fill in all text fields in question 3!", "Question 3 error", JOptionPane.ERROR_MESSAGE);
                } else if (question3.getSelection() == null) {
                    JOptionPane.showMessageDialog(null,  "Choose the correct answer to Question 3!", "Question 3 error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String question1quiz3 = quiz1TextFieldQuestion3.getText();
                    String anwserAquiz3 = quiz1TextFieldA3.getText();
                    String anwserBquiz3 = quiz1TextFieldB3.getText();
                    String anwserCquiz3 = quiz1TextFieldC3.getText();
                    String anwserDquiz3 = quiz1TextFieldD3.getText();
                    String correctAnwserQuiz3 = "";
                    if(quiz1RadioButtonA3.isSelected()){
                        correctAnwserQuiz3 = "A";
                    } else if (quiz1RadioButtonB3.isSelected()){
                        correctAnwserQuiz3 = "B";
                    } else if(quiz1RadioButtonC3.isSelected()) {
                        correctAnwserQuiz3 = "C";
                    } else if(quiz1RadioButtonD3.isSelected()) {
                        correctAnwserQuiz3 = "D";
                    }
                    dataQuiz3 = new String[]{question1quiz3, anwserAquiz3, anwserBquiz3, anwserCquiz3, anwserDquiz3, correctAnwserQuiz3};
                }

                //Question 4
                if(quiz1TextFieldQuestion4.getText().equals("") || quiz1TextFieldA4.getText().equals("") || quiz1TextFieldB4.getText().equals("") || quiz1TextFieldC4.getText().equals("") || quiz1TextFieldD4.getText().equals("")){
                    JOptionPane.showMessageDialog(null,  "Fill in all text fields in question 4!", "Question 4 error", JOptionPane.ERROR_MESSAGE);
                } else if (question4.getSelection() == null) {
                    JOptionPane.showMessageDialog(null,  "Choose the correct answer to Question 4!", "Question 4 error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String question1quiz4 = quiz1TextFieldQuestion4.getText();
                    String anwserAquiz4 = quiz1TextFieldA4.getText();
                    String anwserBquiz4 = quiz1TextFieldB4.getText();
                    String anwserCquiz4 = quiz1TextFieldC4.getText();
                    String anwserDquiz4 = quiz1TextFieldD4.getText();
                    String correctAnwserQuiz4 = "";
                    if(quizRadioButtonA4.isSelected()){
                        correctAnwserQuiz4 = "A";
                    } else if (quizRadioButtonB4.isSelected()){
                        correctAnwserQuiz4 = "B";
                    } else if(quizRadioButtonC4.isSelected()) {
                        correctAnwserQuiz4 = "C";
                    } else if(quizRadioButtonD4.isSelected()) {
                        correctAnwserQuiz4 = "D";
                    }
                    dataQuiz4 = new String[]{question1quiz4, anwserAquiz4, anwserBquiz4, anwserCquiz4, anwserDquiz4, correctAnwserQuiz4};
                }

                //send the data to allquizesdata to save it into array
                try {
                    boolean decision = AllQuizzesData.checkQuizNames(name, category);
                    boolean lessThanFive = AllQuizzesData.checkHowManyQuizzes(category);
                    boolean checkIfTimeCorrect = checkTime();

                    if (decision) { //if true, user will need to change name of the quiz
                        JOptionPane.showMessageDialog(null,  "There is already a quiz in this category with the same name!", "Name error", JOptionPane.ERROR_MESSAGE);
                    } else if(!lessThanFive){
                        JOptionPane.showMessageDialog(null,  "There is too many quizzes in this category (max 5)!", "Name error", JOptionPane.ERROR_MESSAGE);
                    } else if (!checkIfTimeCorrect) {
                        JOptionPane.showMessageDialog(null, "Enter correct time for the quiz!", "Time error", JOptionPane.ERROR_MESSAGE);
                    } else if (!decision && lessThanFive && checkIfTimeCorrect){ //if not, the data can be written to a file
                        AllQuizzesData.insertQuizDataIntoArray(name, category, time, dataQuiz1, dataQuiz2, dataQuiz3, dataQuiz4);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

      //clear fields
      clearFieldsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          quizNameJField.setText("");
          timeTextField.setText("");

          quiz1TextFieldQuestion1.setText("");
          quiz1TextFieldA1.setText("");
          quiz1TextFieldB1.setText("");
          quiz1TextFieldC1.setText("");
          quiz1TextFieldD1.setText("");

          quiz1TextFieldQuestion2.setText("");
          quiz1TextFieldA2.setText("");
          quiz1TextFieldB2.setText("");
          quiz1TextFieldC2.setText("");
          quiz1TextFieldD2.setText("");

          quiz1TextFieldQuestion3.setText("");
          quiz1TextFieldA3.setText("");
          quiz1TextFieldB3.setText("");
          quiz1TextFieldC3.setText("");
          quiz1TextFieldD3.setText("");

          quiz1TextFieldQuestion4.setText("");
          quiz1TextFieldA4.setText("");
          quiz1TextFieldB4.setText("");
          quiz1TextFieldC4.setText("");
          quiz1TextFieldD4.setText("");
        }
      });

      returnToMainSiteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JFrame main = new JFrame("Welcome to Quizlo");
          main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          main.setContentPane(new QuizloMain().getMainForm());
          main.pack();
          main.setVisible(true);
          main.setResizable(false);
          setVisible(false);
        }
      });
    }

    public boolean checkTime(){
        if (timeTextField.getText().equals("")){
          return false;
        } else {
          time = timeTextField.getText();
          try {
            int correctTime = Integer.parseInt(time);
          } catch (NumberFormatException numberFormatException) {
            return false;
          }
        }
        return true;
    }
}
