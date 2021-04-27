import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Categories extends JFrame { //extends JFrame used to be able to close the window when opening new one
    private JButton animalsButton;
    private JButton plantsButton;
    private JButton peopleButton;
    private JButton scienceButton;
    private JButton musicButton;
    private JButton otherButton;
    private JButton mainSiteButton;
    private JLabel animalsPicture;
    private JPanel jPanelCategories;
    private JLabel plantsPicture;
    private JLabel peoplePicture;
    private JLabel sciencePicture;
    private JLabel musicPicture;
    private JLabel otherPicture;
    private JLabel patternLeft;
    private JLabel patternRight;
    static String categoryName;

    public JPanel getJPanelCategories() {
        return jPanelCategories;
    }

    public Categories() {
        animalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryName = "Animals";
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

        plantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryName = "Plants";
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

        peopleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryName = "People";
                JFrame searchedCategory = new JFrame("Categories");
                searchedCategory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                try {
                    searchedCategory.setContentPane(new SelectedCategory().getJPanelSearchedCategory());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                searchedCategory.pack();
                searchedCategory.setVisible(true);
                searchedCategory.setResizable(false);
                setVisible(false);
            }
        });

        scienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryName = "Science";
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

        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryName = "Music";
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

        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categoryName = "Other";
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

        mainSiteButton.addActionListener(new ActionListener() {
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
        animalsPicture = new JLabel(new ImageIcon("Images/animals.png"));
        plantsPicture = new JLabel(new ImageIcon("Images/plants.png"));
        peoplePicture = new JLabel(new ImageIcon("Images/people.png"));
        musicPicture = new JLabel(new ImageIcon("Images/music.png"));
        sciencePicture = new JLabel(new ImageIcon("Images/science.png"));
        otherPicture = new JLabel(new ImageIcon("Images/other.png"));
        patternLeft = new JLabel(new ImageIcon("Images/pattern2__.png"));
        patternRight = new JLabel(new ImageIcon("Images/pattern2__.png"));
    }

    public static String giveCategory(String quizName){
        String category = "";
        for (int i = 0; i < AllQuizzesData.allQuizNamesData.size()-1; i++) {
            if (quizName.equals(AllQuizzesData.allQuizNamesData.get(i))) {
                category = AllQuizzesData.allQuizNamesData.get(i + 1);
            }
        }
        categoryName = category;
        return category;
    }

    public static String giveTime(String quizName){
        String time = "";
        String quizName_ = quizName.replace('-', ' ');
        // Zadanie 3
        // Uzupełnij funkcję giveTime() w pliku Categories.java tak aby zwracała ona czas przeznaczony na rozwiązanie
        // danego quizu. Wykorzystaj do tego arrayList allQuizData, który znajduje się w klasie AllQuizzesData.
        return time;
    }
}
