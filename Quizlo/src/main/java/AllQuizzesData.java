import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AllQuizzesData {

    static ArrayList<String> allQuizNamesData =  new ArrayList<>();
    static ArrayList<String> allQuizData = new ArrayList<>(); //all data

    public static void write() throws IOException{
        FileWriter writer = new FileWriter("Data/data.txt");
        for(String str: allQuizData) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public static void read() throws FileNotFoundException {
        Scanner s = new Scanner(new File("Data/data.txt"));
        while (s.hasNext()){
            allQuizData.add(s.next());
        }
        s.close();
    }

    public static void writeNames() throws IOException{
        FileWriter writer = new FileWriter("Data/dataNames.txt");
        for(String str: allQuizNamesData) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public static void readNames() throws FileNotFoundException {
        Scanner s = new Scanner(new File("Data/dataNames.txt"));
        while (s.hasNext()){
            allQuizNamesData.add(s.next());
        }
        s.close();
    }

    public static void spacesToMinuses2(){
        char ch = '-';
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();
        if (allQuizData.size() != 0) {
            for (int i = 0; i < allQuizData.size(); i++) {
                String x = allQuizData.get(i).replace(' ', ch);
                temp.add(x);
            }
            allQuizData.subList(0, allQuizData.size()).clear();
            allQuizData.addAll(temp);
        }
        if (allQuizNamesData.size() != 0) {
            for (int i = 0; i < allQuizNamesData.size(); i++) {
                String x = allQuizNamesData.get(i).replace(' ', ch);
                temp2.add(x);
            }
            allQuizNamesData.subList(0, allQuizNamesData.size()).clear();
            allQuizNamesData.addAll(temp2);
        }
    }

    public static void minusesToSpace(){
        char ch = ' ';
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();
        if (allQuizData.size() != 0) {
            for (int i = allQuizData.size() - 27; i < allQuizData.size(); i++) {
                String x = allQuizData.get(i).replace('-', ch);
                temp.add(x);
            }
            allQuizData.subList(allQuizData.size()-27, allQuizData.size()).clear();
            allQuizData.addAll(temp);
        }
        if (allQuizNamesData.size() != 0) {
            for (int i = allQuizNamesData.size() - 2; i < allQuizNamesData.size(); i++) {
                String x = allQuizNamesData.get(i).replace('-', ch);
                temp2.add(x);
            }
            allQuizNamesData.subList(allQuizNamesData.size()-2, allQuizNamesData.size()).clear();
            allQuizNamesData.addAll(temp2);
        }
    }

    public static void minusesToSpace2(){
        char ch = ' ';
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();
        if (allQuizData.size() != 0) {
            for (int i = 0; i < allQuizData.size(); i++) {
                String x = allQuizData.get(i).replace('-', ch);
                temp.add(x);
            }
            allQuizData.subList(0, allQuizData.size()).clear();
            allQuizData.addAll(temp);
        }
        if (allQuizNamesData.size() != 0) {
            for (int i = 0; i < allQuizNamesData.size(); i++) {
                String x = allQuizNamesData.get(i).replace('-', ch);
                temp2.add(x);
            }
            allQuizNamesData.subList(0, allQuizNamesData.size()).clear();
            allQuizNamesData.addAll(temp2);
        }
    }

    public static void insertQuizDataIntoArray(String quizName, String category, String time, String[] dataQuiz1, String[] dataQuiz2, String[] dataQuiz3, String[] dataQuiz4) throws IOException, ClassNotFoundException {
        // accessing each element of array
        allQuizNamesData.clear();
        allQuizData.clear();

        read();
        readNames();
        minusesToSpace();

        allQuizNamesData.add(quizName); //adding this not to search the allQuizData just for names
        allQuizNamesData.add(category); //name will be linked with quizName - we cannot have the same name of quiz in specific category
        allQuizData.add(quizName);
        allQuizData.add(category);
        allQuizData.add(time);

        allQuizData.addAll(Arrays.asList(dataQuiz1));
        allQuizData.addAll(Arrays.asList(dataQuiz2));
        allQuizData.addAll(Arrays.asList(dataQuiz3));
        allQuizData.addAll(Arrays.asList(dataQuiz4));

        spacesToMinuses2();
        write();
        writeNames();
    }

    public static boolean checkQuizNames(String quizName, String category) throws IOException {

        boolean decision = false; //to możecie zmienić :)
        allQuizNamesData.clear();
        char ch = '-';
        quizName = quizName.replace(' ', ch);
        minusesToSpace();
        readNames();

        // Zadanie 2
        // W pliku AllQuizzesData.java dopisz brakujący kod do funkcji checkQuizNames - otrzymuje ona dwie dane:
        // nazwę quizu oraz jego kategorię. Sprawdź czy quiz o takiej samej nazwie i kategorii już nie istnieje wiedząc,
        // że arrayList allQuizNamesData przechowuje obie te wartości odczytując je z pliku tekstowego dataNames.txt.
        // Podpowiedź: wykorzystaj allQuizNamesData aby porównać dane

        return decision; // if decision is true, user will need to change name of the quiz
    }

    public static boolean checkHowManyQuizzes(String category) throws FileNotFoundException { //checking if the number of quizzes in category is less than 5, if it is then we can proceed
        boolean lessThanFive = false;
        int howManyQuizzes = 0;
        allQuizNamesData.clear();
        readNames();
        for (int i = 0 ; i < allQuizNamesData.size(); i++){
            if(category.equals(allQuizNamesData.get(i))) {
                howManyQuizzes += 1;
            }
        }
        if (howManyQuizzes < 5){
            lessThanFive = true;
        }
        return lessThanFive;
    }

    public static void deleteQuiz(String quizName, String category) throws IOException {
        allQuizNamesData.clear();
        allQuizData.clear();
        readNames();
        read();

        ArrayList<Integer> toBeRemoved = new ArrayList<>();
        ArrayList<Integer> toBeRemoved2 = new ArrayList<>();

        for (int i = 0; i < AllQuizzesData.allQuizNamesData.size()-1; i++) {
            if (quizName.equals(AllQuizzesData.allQuizNamesData.get(i))) {
                if (category.equals(AllQuizzesData.allQuizNamesData.get(i + 1))) {
                    toBeRemoved2.add((i+1));
                    toBeRemoved2.add((i));
                }
            }
        }
        for (int i = 0; i < AllQuizzesData.allQuizData.size()-1; i++) { //27
            if (quizName.equals(AllQuizzesData.allQuizData.get(i))) {
                if (category.equals(AllQuizzesData.allQuizData.get(i + 1))) {
                    for (int j = i+26; j >= i; j--){ //we had to do this this way because there were problems xd
                        toBeRemoved.add(j);
                    }
                }
            }
        }
        for (int ss: toBeRemoved2){
            allQuizNamesData.remove(ss);
       }
        for (int s: toBeRemoved){
            allQuizData.remove(s);
        }
        writeNames();
        write();
    }

    public static int indexByNameOfQuiz(String quizName, String category) throws IOException {
        allQuizData.clear();
        read();
        int index = 0;
        for (int i = 0; i < AllQuizzesData.allQuizData.size()-1; i++) { //27
            if (quizName.equals(AllQuizzesData.allQuizData.get(i))) {
                if (category.equals(AllQuizzesData.allQuizData.get(i + 1))) {
                    index = i;
                }
            }
        }
        return index;
    }
}
