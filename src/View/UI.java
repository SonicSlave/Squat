package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Stack;


public class UI
{
    JFrame mJF;
    public JPanel cP1, cP2;
    public JPanel mP;
    public static Font BIG = new Font("BIG",Font.BOLD,25);


    public void T_createUI(currentUser mCU)
    {
        mJF = new JFrame("Benjamin's Squat Program");
        mJF.setResizable(false);
        mJF.setSize(600,600);
        mJF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mJF.setLocationRelativeTo(null);
        mJF.setLayout(null);

        JPanel pWOP  = new JPanel();
        pWOP.setLayout(null);
        pWOP.setBounds(0,0,600,600);

        JButton confirm4 = new JButton("Go!");
        confirm4.setBounds(300, 420, 250, 100);
        confirm4.setBackground(Color.green);
        pWOP.add(confirm4);

        JButton exit = new JButton("Back out");
        exit.setBounds(300, 320, 250, 100);
        exit.setBackground(Color.red);
        pWOP.add(exit);

        JPanel information = new JPanel();
        information.setBounds(50,50,210,470);
        information.setBackground(Color.black);
        information.setLayout(null);
        pWOP.add(information);

        JPanel time = new JPanel();
        time.setBounds(300, 50, 250, 240);
        time.setBackground(Color.black);
        time.setLayout(null);
        pWOP.add(time);


        mJF.add(pWOP);


        mJF.setVisible(true);
    }

    public void createUI(currentUser mCU)
    {
        mJF = new JFrame("Benjamin's Squat Program");
        mJF.setResizable(false);
        mJF.setSize(600,600);
        mJF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mJF.setLocationRelativeTo(null);
        mJF.setLayout(null);

        JPanel cP1 = new JPanel();
        cP1.setBounds(0,0,600,600);
        cP1.setBackground(Color.red);
        cP1.setLayout(null);
        JLabel welcome = new JLabel("Welcome to my squat program!",SwingConstants.CENTER);
        welcome.setFont(BIG);
        welcome.setBounds(50,5,500,100);
        JLabel queryName = new JLabel("What is your name?",SwingConstants.CENTER);
        queryName.setBounds(50,110,500,100);
        cP1.add(welcome); cP1.add(queryName);
        JButton confirm3 = new JButton("Confirm");
        JTextField enterNameHere = new JTextField("Enter name here:");
        enterNameHere.setBounds(50,200,500,100);
        cP1.add(enterNameHere);
        confirm3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = enterNameHere.getText();
                int valid = 1;
                for(int i = 0;i<name.length();i++)
                {
                    char test = name.charAt(i);
                    if (!Character.isLetter(test) && !Character.isWhitespace(test))
                    {
                        valid = 0;
                        JOptionPane.showMessageDialog(cP1,"Please, no special characters","Attention",JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if (name.length() > 100)
                {
                    valid = 0;
                    JOptionPane.showMessageDialog(cP1,"Name must not be more than 100 characters","Attention",JOptionPane.ERROR_MESSAGE);
                }
                if(name.length() < 1)
                {
                    valid = 0;
                    JOptionPane.showMessageDialog(cP1,"Name must be at least one character","Attention",JOptionPane.ERROR_MESSAGE);
                }

                if(valid == 1)
                {
                    mCU.setName(name);
                    String[] options = { "Yes", "No, I messed up"};
                    var selection = JOptionPane.showOptionDialog(null, "Your name is "+mCU.getName()+"?", "Confirm",
                            0, 3, null, options, options[0]);
                    if (selection == 0)
                    {
                        JOptionPane.showMessageDialog(cP1,"Nice to meet you " + mCU.getName(),"Welcome!",JOptionPane.PLAIN_MESSAGE);
                        cP1.setVisible(false);

                    }
                }
            }
        });
        confirm3.setBounds(50, 420, 500, 100);
        cP1.add(confirm3);
        mJF.add(cP1);

        JPanel cP2 = new JPanel();
        cP2.setBounds(0,0,600,600);
        cP2.setBackground(Color.GREEN);
        cP2.setLayout(null);
        JLabel queryGoals = new JLabel("What are your goals?",SwingConstants.CENTER);
        queryGoals.setBounds(50,5,500,100);
        cP2.add(queryGoals);
        JLabel title = new JLabel("Description of selection:");
        title.setBounds(340,65,200,80);
        cP2.add(title);
        JTextArea description = new JTextArea(" <--- Click on the options <---");
        description.setBounds(270,125,280,80);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        cP2.add(description);
        JLabel visualDiscription = new JLabel();
        visualDiscription.setBounds(50,220,500,180);
        cP2.add(visualDiscription);
        ImageIcon hypi = new ImageIcon(getClass().getClassLoader().getResource("programdescription/hypertrophy.jpg"));
        ImageIcon si = new ImageIcon(getClass().getClassLoader().getResource("programdescription/strength.jpg"));
        ImageIcon sanhi = new ImageIcon(getClass().getClassLoader().getResource("programdescription/sandh.jpg"));
        ImageIcon endi = new ImageIcon(getClass().getClassLoader().getResource("programdescription/endurance.jpg"));
        ImageIcon qm = new ImageIcon(getClass().getClassLoader().getResource("programdescription/qm.jpg"));
        visualDiscription.setIcon(qm);
        JButton confirm2 = new JButton("Confirm");
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Hypertrophy");
        listModel.addElement("Strength");
        listModel.addElement("Strength and hypertrophy");
        listModel.addElement("Endurance");
        listModel.addElement("Random");
        JList goals = new JList(listModel);
        goals.setBounds(50,110,200,95);
        goals.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String selectedVal = (String)goals.getSelectedValue();
                if(selectedVal.equals("Hypertrophy"))
                {
                    description.setText("Lets get pumped up dude. Get fluffed up, jacked, cut, clean, bulked up, yolked. High volume, moderate intensity, moderate rest times.");
                    visualDiscription.setIcon(hypi);
                }
                else if(selectedVal.equals("Strength"))
                {
                    description.setText("We're gonna work on power and recruiting muscle fibers. Low intensity exercises to focus on mind muscle connection, followed by high intensity, low rep exercises to challenge the muscles. Lots of rest.");
                    visualDiscription.setIcon(si);
                }
                else if(selectedVal.equals("Strength and hypertrophy"))
                {
                    description.setText("Best of both worlds, get stronger and build muscle. After all, you cant have strength without muscle, and whats the point of having muscle if you cant use it?");
                    visualDiscription.setIcon(sanhi);
                }
                else if(selectedVal.equals("Endurance"))
                {
                    description.setText("Build muscular endurance. Good if you want to go into the army or something. High volume split across less sets, low rest time.");
                    visualDiscription.setIcon(endi);
                }
                else if(selectedVal.equals("Random"))
                {
                    description.setText("Drawing inspiration from the fartlek style of training, this program will randomly generate your workouts in order to truly confuse the muscles.");
                    visualDiscription.setIcon(qm);
                }
                confirm2.setEnabled(true);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        cP2.add(goals);
        confirm2.setBounds(50, 420, 500, 100);
        confirm2.setEnabled(false);
        confirm2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] options = { "I has", "No, no has"};
                var selection = JOptionPane.showOptionDialog(null, "Do you have weights?", "Quick question!",
                        0, 3, null, options, options[0]);
                if (selection == 0)
                {
                    JOptionPane.showMessageDialog(null, "Excellent! You will find more exercise variations to help you progress!");
                    mCU.setHasWeights(true);
                }
                if (selection == 1)
                {
                    JOptionPane.showMessageDialog(null, "That's okay, the program will still work!");
                    mCU.setHasWeights(false);
                }

                cP2.setVisible(false);
                int index = goals.getSelectedIndex();
                Program p = Program.RANDOM;
                switch(index)
                {
                    case 0: p = Program.HYPERTROPHY; break;
                    case 1: p = Program.STRENGTH; break;
                    case 2: p = Program.STANDHY; break;
                    case 3: p = Program.ENDURANCE; break;
                    case 4: p = Program.RANDOM; break;
                }
                mCU.setProgram(p);
            }
        });
        cP2.add(confirm2);
        mJF.add(cP2);

        JPanel mP = new JPanel();
        mP.setBounds(0,0,600,600);
        mP.setBackground(Color.blue);
        mP.setLayout(null);
        JButton confirm4 = new JButton("Go!");
        confirm4.setBounds(300, 420, 250, 100);
        confirm4.setBackground(Color.green);
        mP.add(confirm4);
        JPanel information = new JPanel();
        information.setBounds(50,50,210,235);
        information.setBackground(Color.black);
        information.setLayout(null);
        mP.add(information);
        JPanel achievments = new JPanel();
        achievments.setBounds(50,285,210,235);
        achievments.setBackground(Color.black);
        achievments.setLayout(null);
        mP.add(achievments);
        JLabel date,highestLevelSquat, motivationalQuote, greetings,objective,weekvolume,pvweekvolume;
        greetings = new JLabel("Greetings!",SwingConstants.CENTER);
        greetings.setForeground(Color.white);
        greetings.setFont(BIG);
        greetings.setBounds(300, 0,250,100);
        mP.add(greetings);
        date = new JLabel("Days since last workout: ");
        date.setForeground(Color.white);
        date.setBounds(10, 0,210,50);
        information.add(date);
        highestLevelSquat = new JLabel("Squat LVL: ");
        highestLevelSquat.setForeground(Color.white);
        highestLevelSquat.setBounds(10, 50,210,50);
        information.add(highestLevelSquat);
        weekvolume = new JLabel("This week's volume: ");
        weekvolume.setForeground(Color.white);
        weekvolume.setBounds(10, 150,210,50);
        information.add(weekvolume);
        pvweekvolume = new JLabel("Previous week's volume: ");
        pvweekvolume.setForeground(Color.white);
        pvweekvolume.setBounds(10, 180,210,50);
        information.add(pvweekvolume);
        objective = new JLabel("Objective: ");
        objective.setForeground(Color.white);
        objective.setBounds(10, 100,210,50);
        information.add(objective);
        motivationalQuote = new JLabel("Motivational image of the day: ",SwingConstants.CENTER);
        motivationalQuote.setForeground(Color.white);
        motivationalQuote.setBounds(300, 70,250,100);
        mP.add(motivationalQuote);
        JLabel visualDiscription1 = new JLabel();
        visualDiscription1.setBounds(300, 150,250,250);
        Random r = new Random(mCU.getDay() * mCU.getYear() * mCU.getMonth());
        String path = "motivationalimages/m"+(r.nextInt(8))+".jpg";
        System.out.println(path);
        mP.add(visualDiscription1);
        visualDiscription1.setIcon(new ImageIcon(getClass().getClassLoader().getResource(path)));
        JLabel al  = new JLabel("Achievements",SwingConstants.CENTER);
        al.setForeground(Color.white);
        al.setBounds(0,0,210,50);
        achievments.add(al);
        Stack achSlots = new Stack();
        for(int i =0;i<24;i++)
        {
            achSlots.push(new JPanel());
            JPanel working = (JPanel) achSlots.peek();
            if(i%2 == 0)
            {
                working.setBackground(Color.black);
            }
            else
            {
                working.setBackground(Color.red);
            }
        }
        for(int x =0;x<8;x++)
        {
            for(int y =0;y<3;y++)
            {
                JPanel working = (JPanel) achSlots.pop();
                working.setBounds(70*y,(23*x)+50,70,23);
                achievments.add(working);
            }
        }
        mJF.add(mP);


        mJF.setVisible(true);
    }

}
