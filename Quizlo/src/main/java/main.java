import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame quizloMain = new JFrame("Categories");
        quizloMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizloMain.setContentPane(new QuizloMain().getMainForm());
        quizloMain.pack();
        quizloMain.setVisible(true);
        quizloMain.setResizable(false);
    }
}
