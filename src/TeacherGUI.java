import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherGUI {
    JFrame mainFrame;

    public void m1() {
        // Main frame
        mainFrame = new JFrame("Teacher GUI");
        mainFrame.setSize(1250, 1250);



        //panel
        JPanel panel = new JPanel();
        Color reddishColor = new Color(124, 16, 52);
        panel.setBackground(reddishColor);
        panel.setLayout(null);


        //heading for the home page
        JLabel Heading1 = new JLabel ("Welcome. Choose any one of the following.");
        Heading1.setBounds(350, 50, 700, 100);
        Heading1.setForeground(Color.WHITE); //foreground is used to change the color of the font
        Heading1.setFont(new Font("Arial", Font.BOLD, 30)); // size and font change garkeo
        panel. add(Heading1); //panel ma add gareko


        // Box to contain buttons
        JPanel buttonBox = new JPanel();
        buttonBox.setBounds(350, 150, 600, 400);
        buttonBox.setLayout(null);
        buttonBox.setBackground(Color.WHITE); // Set color for box


        // Button for Lecturer
        JButton lecturerButton = new JButton("Lecturer");
        lecturerButton.setBounds(150, 50, 300, 100); //xaxis, yaxis


        lecturerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lecturerButton.setBackground(Color.PINK);
                JFrame LecturerFrame = new JFrame("Lecturer");
//                LecturerFrame.setVisible(true);
//                LecturerFrame.setLayout(null);
//                LecturerFrame.setSize (1250,1250);
                m2();
            }
        });

        // Button for Tutor
        JButton tutorButton = new JButton("Tutor");
        tutorButton.setBounds(150, 250, 300, 100);
        tutorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tutorButton.setBackground(Color.PINK);
                JFrame TutorFrame = new JFrame("Tutor");
                TutorFrame.setVisible(true);
                TutorFrame.setLayout(null);
                TutorFrame.setSize (1250,1250);


            }
        });

        // Add buttons to the button box
        buttonBox.add(lecturerButton);
        buttonBox.add(tutorButton);

        // Add button box to the panel
        panel.add(buttonBox);
        // Add panel to the main frame
        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

    public void m2() {
        JFrame LecturerFrame = new JFrame("Lecturer");
        LecturerFrame.setVisible(true);
        LecturerFrame.setLayout(null);
        LecturerFrame.setSize (1250,1250);

        JLabel l1 = new JLabel("Teacher ID:");
        l1.setBounds(40, 30, 100, 30);
        LecturerFrame.add(l1);

        JTextField T1 = new JTextField();
        T1.setBounds(150, 30, 200, 30);
        LecturerFrame.add(T1);

        JLabel l2 = new JLabel("Teacher Name:");
        l2.setBounds(40, 80, 100, 30);
        LecturerFrame.add(l2);

        JTextField T2 = new JTextField();
        T2.setBounds(150, 80, 200, 30);
        LecturerFrame.add(T2);

        JLabel l3 = new JLabel("Address:");
        l3.setBounds(40, 130, 100, 30);
        LecturerFrame.add(l3);

        JTextField T3 = new JTextField();
        T3.setBounds(150, 130, 200, 30);
        LecturerFrame.add(T3);

        JLabel l4 = new JLabel("Working Type");
        l3.setBounds(40,210,200,40);//x-axis,y-axis,length,width
        LecturerFrame.add(l3);

        JTextField T4 = new JTextField("");
        T4.setBounds(170,220,150,30);
        LecturerFrame.add(T4);

        JLabel l5 = new JLabel("Employment Status");
        l5.setBounds(40,250,200,40);//x-axis,y-axis,length,width
        LecturerFrame.add(l5);

        JTextField T5 = new JTextField("");
        T5.setBounds(170,260,150,30);
        LecturerFrame.add(T5);

    }



    public static void main(String[] args) {
        TeacherGUI teacherGUI = new TeacherGUI();
        teacherGUI.m1();

    }

}