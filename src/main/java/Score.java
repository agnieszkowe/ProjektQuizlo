import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Score extends JFrame{

  private JPanel jPanelScore;
  private JButton categoriesButton;
  private JLabel scoreFill;
  private JLabel percentFill;
  private JLabel correctOne;
  private JLabel correctTwo;
  private JLabel correctThree;
  private JLabel correctFour;

  public JPanel getJPanelScore() {
    return jPanelScore;
  }

  public Score(int allPoints, ArrayList<String> correctAnswers){
    scoreFill.setText(String.valueOf(allPoints));

    correctOne.setText(correctAnswers.get(0));
    correctTwo.setText(correctAnswers.get(1));
    correctThree.setText(correctAnswers.get(2));
    correctFour.setText(correctAnswers.get(3));

    //user percent
    if (allPoints == 4) {
      percentFill.setText("100%");
    } else if (allPoints == 3) {
      percentFill.setText("75%");
    } else if (allPoints == 2) {
      percentFill.setText("50%");
    } else if (allPoints == 1) {
      percentFill.setText("25%");
    } else if (allPoints == 0) {
      percentFill.setText("0%");
    }

    categoriesButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // open categories
        JFrame categories = new JFrame("Categories");
        categories.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        categories.setContentPane(new Categories().getJPanelCategories());
        categories.pack();
        categories.setVisible(true);
        categories.setResizable(false);
        setVisible(false);
      }
    });
  }
}