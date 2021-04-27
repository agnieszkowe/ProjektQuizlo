import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizloMain extends JFrame{
    private JButton openCategoriesButton;
    private JButton openCreationButton;
    private JPanel mainForm;
    private JButton quitButton;
    private JPanel right;
    private JPanel left;
    private JLabel pictureLeft;
    private JLabel pictureRight;

    public JPanel getMainForm() {
        return mainForm;
    }

    public QuizloMain() {
        openCategoriesButton.addActionListener(new ActionListener() {
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

        openCreationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // open creation
              JFrame creation = new JFrame("Create Quiz");
              creation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              creation.setContentPane(new Creation().getJPanelQuizCreation());
              creation.pack();
              creation.setVisible(true);
              setVisible(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //closes the program entirely
                setVisible(false);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        QuizloMain frame = new QuizloMain();
        frame.setContentPane(frame.mainForm);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        pictureLeft = new JLabel(new ImageIcon("Images/wave.png"));
        pictureRight = new JLabel(new ImageIcon("Images/wave.png"));
    }
}
