import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    String[] questions = {
        "What single did Elvis record after filing for divorce on January 8, 1973?",
        "Elvis memorized every line from what George C. Scott movie?",
        "How many encores did Elvis usually give?",
        "Why was Elvis' mansion called 'Graceland'?",
        "What Elvis hit single was based on an 1861 classical piece entitled 'Aura Lee'?",
        "Which of the following did Elvis earn in 1960?",
        "What did Elvis receive from Richard Nixon?",
        "What was the first National TV show that Elvis appeared on?",
        "What two U.S. Presidents was Elvis related to?",
        "What was the name of Elvis Presley's chimpanzee?",
        "How many drugs did Elvis have in his body at the time of his death?",
        "What was Elvis' shoe size?",
        "What book was Elvis reading at the time of his death?",
        "What actress did Elvis always send flowers to when she opened a show in Las Vegas?",
        "What Elvis Presley hit was originally recorded in 1950 by Ernest Tubb?",
        "How many competitive Grammy Awards did Elvis Presley win during his lifetime?",
        "What grade did Elvis get in his eighth grade music class?",
        "What was the first magazine that ever published an article about Elvis?",
        "Elvis sang 'Hound Dog' on The Steve Allen Show in 1956 accompanied by a real hound dog. What kind of a dog was it?",
        "What was Elvis' first commercially released single?",
        "How old was Elvis when he bought Graceland?",
        "What was Elvis Presley's age when he bought his first guitar?",
        "Which song closed The King's famous '68 Comeback television special?",
        "What was Elvis' army serial number?",
        "In which movie did Elvis sing 'A House That Has Everything'?",
        "How many studio albums did Elvis make?",
        "Which song contains the lyrics, 'The old train whistle makes me want to cry'",
        "From which clothing store in Memphis did Elvis buy much of his clothing?"
    };

    String[][] options = {
        {"Separate Ways", "Hound Dog", "Stuck on You", "Burning Love"},
        {"The Last Run", "StrangeLove", "Jane Eyre", "Patton"},
        {"3", "1", "5", "0"},
        {"His favourite song was 'Amazing Grace'", "It was originally a church", "His Favourite actress was Grace Kelly", "His dog was named Grace"},
        {"Love Me Tender", "Are You Lonesome Tonight?", "Can't Help Falling in Love", "Don't Be Cruel"},
        {"Masters Degree in Finance", "High School Diploma", "Black Belt in Karate", "Keys to the City"},
        {"Special Agent Badge", "Silver Star", "Statue of General Douglas McArthur", "Medal of Honour"},
        {"Ed Sullivan Show", "Stage Show", "Ted Mack's Original Amateur Hour", "Tonight Show"},
        {"Abraham Lincoln & Jimmy Carter", "Andrew Jackson & Woodrow Wilson", "George Washington & Bill Clinton","Benjamin Harrison & Barack Obama"},
        {"Bonnie", "George", "Scatter", "Bozo"},
        {"25", "3", "10", "8"},
        {"9D", "7D", "12D", "11D"},
        {"To Kill a Mockingbird", "Billy Graham Answers Your Questions", "The Bible", "The Scientific Search for the Face of Jesus"},
        {"Ann-Margret", "Ginger Alden", "Julie Parish", "Charo"},
        {"In the Ghetto", "Don't be Cruel", "All Shook Up", "Blue Christmas"},
        {"7", "3", "0", "10"},
        {"A", "F", "C", "B"},
        {"Double Dance", "Down Beat", "Rolling Stone", "Country Song Roundup"},
        {"Baskerville Hound", "Blood Hound", "Basset Hound", "Fox Hound"},
        {"Heartbreak Hotel", "Hound Dog", "That's All Right", "Blue Suede Shoes"},
        {"22", "26", "35", "27"},
        {"8", "18", "16", "11"},
        {"How Great Thou Art", "If I Can Dream", "Love Me Tender", "Suspicious Minds"},
        {"33554444", "51165544", "41289675", "53310761"},
        {"Follow That Dream", "Girl Happy", "A Change of Habbit", "Clambake"},
        {"12", "24", "33", "28"},
        {"One Track Heart", "Mystery Train", "Frankfort Special", "Gonna Get Back Home Somehow"},
        {"Gerber's", "Lansky Bro's", "Goldsmith's", "Lowenstein's"}
    };

    char[] answers = {
        'A',
        'D',
        'D',
        'B',
        'A',
        'C',
        'A',
        'B',
        'A',
        'C',
        'C',
        'D',
        'D',
        'A',
        'D',
        'B',
        'C',
        'D',
        'C',
        'C',
        'A',
        'D',
        'B',
        'D',
        'D',
        'B',
        'D',
        'B'
    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_qs = questions.length;
    int result;
    int secs = 15;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel secs_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percent = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secs--;
                secs_left.setText(String.valueOf(secs));
                if(secs <= 0) {
                    displayAnswer();
                }
            }
        });

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.getContentPane().setBackground(new Color(219,112,147));
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(0, 0, 800, 50);
        textfield.setBackground(new Color(255,182,193));
        textfield.setForeground(new Color(222, 49, 99));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(0, 50, 800, 80);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(255,182,193));
        textarea.setForeground(new Color(222, 49, 99));
        textarea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(0, 150, 100, 100);
        buttonA.setForeground(new Color(222, 49, 99));
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 250, 100, 100);
        buttonB.setForeground(new Color(222, 49, 99));
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setForeground(new Color(222, 49, 99));
        buttonC.setForeground(new Color(222, 49, 99));
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 450, 100, 100);
        buttonD.setForeground(new Color(222, 49, 99));
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 150, 500, 100);
        answer_labelA.setBackground(new Color(219,112,147));
        answer_labelA.setForeground(new Color(225, 225, 225));
        answer_labelA.setFont(new Font("MV Boli", Font.BOLD, 20));
        

        answer_labelB.setBounds(125, 250, 500, 100);
        answer_labelB.setBackground(new Color(219,112,147));
        answer_labelB.setForeground(new Color(225, 225, 225));
        answer_labelB.setFont(new Font("MV Boli", Font.BOLD, 20));
        

        answer_labelC.setBounds(125, 350, 500, 100);
        answer_labelC.setBackground(new Color(219,112,147));
        answer_labelC.setForeground(new Color(225, 225, 225));
        answer_labelC.setFont(new Font("MV Boli", Font.BOLD, 20));
        

        answer_labelD.setBounds(125, 450, 500, 100);
        answer_labelD.setBackground(new Color(219,112,147));
        answer_labelD.setForeground(new Color(225, 225, 225));
        answer_labelD.setFont(new Font("MV Boli", Font.BOLD, 20));
        
        secs_left.setBounds(650, 510, 100, 100);
        secs_left.setBackground(new Color(222, 49, 99));
        secs_left.setForeground(new Color(225,225,225));
        secs_left.setFont(new Font("Ink Free", Font.BOLD, 60));
        secs_left.setBorder(BorderFactory.createBevelBorder(1));
        secs_left.setOpaque(true);
        secs_left.setHorizontalAlignment(JTextField.CENTER);
        secs_left.setText(String.valueOf(secs));

        time_label.setBounds(650, 475, 100, 25);
        time_label.setBackground(new Color(255,182,193));
        time_label.setForeground(new Color(222, 49, 99));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("TIMER");

        number_right.setBounds(325, 225, 200, 100);
        number_right.setBackground(new Color(222, 49, 99));
        number_right.setForeground(new Color(225, 225, 225));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percent.setBounds(325, 325, 200, 100);
        percent.setBackground(new Color(222, 49, 99));
        percent.setForeground(new Color(225, 225, 225));
        percent.setFont(new Font("Ink Free", Font.BOLD, 50));
        percent.setBorder(BorderFactory.createBevelBorder(1));
        percent.setHorizontalAlignment(JTextField.CENTER);
        percent.setEditable(false);

        frame.add(time_label);
        frame.add(secs_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }
    
    public void nextQuestion() {
        if(index >= total_qs) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource() == buttonA) {
            answer = 'A';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource() == buttonB) {
            answer = 'B';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource() == buttonC) {
            answer = 'C';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource() == buttonD) {
            answer = 'D';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }

    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A') {
            answer_labelA.setForeground(new Color(255, 0, 0));
        }
        if(answers[index] != 'B') {
            answer_labelB.setForeground(new Color(255, 0, 0));
        }
        if(answers[index] != 'C') {
            answer_labelC.setForeground(new Color(255, 0, 0));
        }
        if(answers[index] != 'D') {
            answer_labelD.setForeground(new Color(255, 0, 0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(225, 225, 225));
                answer_labelB.setForeground(new Color(225, 225, 225));
                answer_labelC.setForeground(new Color(225, 225, 225));
                answer_labelD.setForeground(new Color(225, 225, 225));

                answer = ' ';
                secs = 15;
                secs_left.setText(String.valueOf(secs));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();

    }

    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses / (double)total_qs) * 100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_qs + ")");
        percent.setText(result + "%");

        frame.add(percent);
        frame.add(number_right);

    }

}
