import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SelectedCategory extends JFrame{
    private JPanel jPanelSearchedCategory;
    private JLabel patternLeft;
    private JLabel patternRight;
    private JButton returnToCategoriesButton;
    private JPanel Quiz2;
    private JPanel Quiz3;
    private JPanel Quiz4;
    private JPanel Quiz5;
    private JPanel Quiz1;
    private JButton buttonQuiz1;
    private JButton buttonQuiz2;
    private JButton buttonQuiz3;
    private JButton buttonQuiz4;
    private JButton buttonQuiz5;
    private JButton deleteQuiz1;
    private JButton deleteQuiz2;
    private JButton deleteQuiz3;
    private JButton deleteQuiz4;
    private JButton deleteQuiz5;
    private JButton refreshButton;
    private JLabel labelQuiz3;
    private JLabel categoryLabel;
    private JLabel labelQuiz1;
    private JLabel labelQuiz2;
    private JLabel labelQuiz4;
    private JLabel labelQuiz5;

    public JPanel getJPanelSearchedCategory() {
        return jPanelSearchedCategory;
    }

    public SelectedCategory() throws IOException {
        String categoryName = Categories.categoryName;
        categoryLabel.setText(categoryName);
        refresh();

        returnToCategoriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame categories = new JFrame("Categories");
                categories.setContentPane(new Categories().getJPanelCategories());
                categories.pack();
                categories.setVisible(true);
                categories.setResizable(false);
                categories.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(false); //closing SearchedCategory window when opening Categories
            }
        });

        buttonQuiz1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectedQuiz frame = null;
                try {
                    String quizName = buttonQuiz1.getText();
                    String quizName_ = quizName.replace(" ","-");
                    frame = new SelectedQuiz(quizName_);
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                frame.setContentPane(frame.getJPanelQuiz());
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(false);
            }
        });

        buttonQuiz2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectedQuiz frame = null;
                try {
                    String quizName = buttonQuiz2.getText();
                    String quizName_ = quizName.replace(" ","-");
                    frame = new SelectedQuiz(quizName_);
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                frame.setContentPane(frame.getJPanelQuiz());
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(false);
            }
        });

        buttonQuiz3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              SelectedQuiz frame = null;
              try {
                  String quizName = buttonQuiz3.getText();
                  String quizName_ = quizName.replace(" ","-");
                  frame = new SelectedQuiz(quizName_);
              } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
              }
              frame.setContentPane(frame.getJPanelQuiz());
              frame.pack();
              frame.setVisible(true);
              frame.setResizable(false);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setVisible(false);
            }
        });

        buttonQuiz4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectedQuiz frame = null;
                try {
                    String quizName = buttonQuiz4.getText();
                    String quizName_ = quizName.replace(" ","-");
                    frame = new SelectedQuiz(quizName_);
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                frame.setContentPane(frame.getJPanelQuiz());
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(false);
            }
        });

        buttonQuiz5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              SelectedQuiz frame = null;
              try {
                  String quizName = buttonQuiz5.getText();
                  String quizName_ = quizName.replace(" ","-");
                  frame = new SelectedQuiz(quizName_);
              } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
              }
              frame.setContentPane(frame.getJPanelQuiz());
              frame.pack();
              frame.setVisible(true);
              frame.setResizable(false);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setVisible(false);
            }
        });

        deleteQuiz1.addActionListener(new ActionListener() { //BLOCK THE BUTTON IF ONCE CLICKED ON
            @Override
            public void actionPerformed(ActionEvent e) {
                String quizname = buttonQuiz1.getText();
                //change " " to "-"
                String quizname_ = quizname.replace(" ","-");
                try {
                    AllQuizzesData.deleteQuiz(quizname_,categoryName);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        deleteQuiz2.addActionListener(new ActionListener() { //BLOCK THE BUTTON IF ONCE CLICKED ON
            @Override
            public void actionPerformed(ActionEvent e) {
                String quizname = buttonQuiz2.getText();
                String quizname_ = quizname.replace(" ","-");
                try {
                    AllQuizzesData.deleteQuiz(quizname_,categoryName);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        deleteQuiz3.addActionListener(new ActionListener() { //BLOCK THE BUTTON IF ONCE CLICKED ON
            @Override
            public void actionPerformed(ActionEvent e) {
                String quizname = buttonQuiz3.getText();
                String quizname_ = quizname.replace(" ","-");
                try {
                    AllQuizzesData.deleteQuiz(quizname_,categoryName);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        deleteQuiz4.addActionListener(new ActionListener() { //BLOCK THE BUTTON IF ONCE CLICKED ON
            @Override
            public void actionPerformed(ActionEvent e) {
                String quizname = buttonQuiz4.getText();
                String quizname_ = quizname.replace(" ","-");
                try {
                    AllQuizzesData.deleteQuiz(quizname_,categoryName);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        deleteQuiz5.addActionListener(new ActionListener() { //BLOCK THE BUTTON IF ONCE CLICKED ON
            @Override
            public void actionPerformed(ActionEvent e) {
                String quizname = buttonQuiz5.getText();
                String quizname_ = quizname.replace(" ","-");
                try {
                    AllQuizzesData.deleteQuiz(quizname_,categoryName);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    refresh();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        patternLeft = new JLabel(new ImageIcon("Images/wood_left.png"));
        patternRight = new JLabel(new ImageIcon("Images/wood.png"));
    }

    public static ArrayList<String> getAllQuizNamesFromCategory(String categoryName) throws FileNotFoundException { //read things
        AllQuizzesData.readNames();
        AllQuizzesData.minusesToSpace2();
        ArrayList<Integer> indexList = new ArrayList<>();
        ArrayList<String> quizNames = new ArrayList<>();
        for (int i = 0; i < AllQuizzesData.allQuizNamesData.size(); i++) {
            if (categoryName.equals(AllQuizzesData.allQuizNamesData.get(i))) {
                indexList.add(i);
                quizNames.add(AllQuizzesData.allQuizNamesData.get(i-1));
            }
        }
        return quizNames;
    }

    public void refresh() throws FileNotFoundException {
        ArrayList<String> quizNames = new ArrayList<>();
        AllQuizzesData.allQuizNamesData.clear();
        AllQuizzesData.allQuizData.clear();
        AllQuizzesData.read();
        AllQuizzesData.minusesToSpace2();
        String categoryName = Categories.categoryName;

        categoryLabel.setText(categoryName);
        quizNames = getAllQuizNamesFromCategory(categoryName);

        buttonQuiz1.setVisible(false);
        buttonQuiz2.setVisible(false);
        buttonQuiz3.setVisible(false);
        buttonQuiz4.setVisible(false);
        buttonQuiz5.setVisible(false);

        labelQuiz1.setVisible(false);
        labelQuiz2.setVisible(false);
        labelQuiz3.setVisible(false);
        labelQuiz4.setVisible(false);
        labelQuiz5.setVisible(false);

        deleteQuiz1.setVisible(false);
        deleteQuiz2.setVisible(false);
        deleteQuiz3.setVisible(false);
        deleteQuiz4.setVisible(false);
        deleteQuiz5.setVisible(false);


        //ZADANIE 1
        // W pliku SelectedCategory.java spraw aby przyciski oraz etykiety pojawiały się i znikały
        // w zależności od ilości pytań w danej kategorii.

    }
}
