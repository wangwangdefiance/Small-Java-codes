import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by defiance on 2017/7/9.
 */
public class GUI {
    JFrame frame=new JFrame("word quiz game");
    JPanel panel=new JPanel();
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<wordCard> cardList;


    public void launch()
    {
        JLabel qLabel=new JLabel("question:");
        question=new JTextArea(6,30);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);

        JLabel aLabel=new JLabel("answer:");
        answer=new JTextArea(6,30);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);

        JScrollPane qScroller=new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane aScroller=new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton=new JButton("next word.");

        panel.add(qLabel);
        panel.add(qScroller);
        panel.add(aLabel);
        panel.add(aScroller);
        panel.add(nextButton);

        nextButton.addActionListener(new nextCardButtonListener());

        JMenuBar menuBar=new JMenuBar();
        JMenu fileManu=new JMenu("file");
        JMenuItem newItem=new JMenuItem("new");
        JMenuItem saveMenu=new JMenuItem("save");
        saveMenu.addActionListener(new saveListener());
        newItem.addActionListener(new newItemListener());

        fileManu.add(newItem);
        fileManu.add(saveMenu);
        menuBar.add(fileManu);
        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    class saveListener implements  ActionListener
    {
        public void actionPerformed(ActionEvent clicked)
        {
            wordCard card=new wordCard(question.getText(),answer.getText());
            cardList.add(card);

            JFileChooser saveFile=new JFileChooser();
            saveFile.showSaveDialog(frame);
            saver(saveFile.getSelectedFile());
        }
    }

    class newItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent clicked)
        {
            cardList.clear();
            clearCard();
        }
    }

    class nextCardButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent clicked)
        {
            wordCard card=new wordCard();
            cardList.add(card);
            clearCard();
        }
    }

    public void clearCard()
    {
        question.setText(" ");
        answer.setText(" ");
        question.requestFocus();
    }

    private void saver(File in_file)
    {
        try
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter(in_file));
            for (wordCard card:cardList)
            {
                writer.write(card.question+"/");
                writer.write(card.answer+"\n");
            }
            writer.close();
        }catch (Exception e)
        {
            System.out.println("cannot write.Some error happened.");
            e.printStackTrace();
        }
    }
}

