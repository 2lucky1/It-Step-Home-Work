package com.muntian.ht42_progress_bars;

import javax.swing.*;
import java.awt.*;

public class ProgressMain {
    private static final int DELTA = 1;
    public static final int WIDTH_OF_WINDOW = 500;
    public static final int HEIGHT_OF_WINDOW = 250;
    private JProgressBar jProgressBar1;
    private JProgressBar jProgressBar2;
    private JProgressBar jProgressBar3;
    private JProgressBar jProgressBar4;
    private JProgressBar jProgressBar5;


    private Thread thread1 = new Thread();
    private Thread thread2 = new Thread();
    private Thread thread3 = new Thread();
    private Thread thread4 = new Thread();
    private Thread thread5 = new Thread();


    public static void setThread(Thread thread, Thread newThread) {
        thread = newThread;
    }

    private ProgressMain() {
        //Creating of window
        JFrame jFrame = new JFrame("5 progress bars");
        jFrame.setSize(WIDTH_OF_WINDOW, HEIGHT_OF_WINDOW);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        //Initializing of progress bars
        jProgressBar1 = new JProgressBar();
        jProgressBar1.setForeground(Color.RED);
        jProgressBar2 = new JProgressBar();
        jProgressBar2.setForeground(Color.ORANGE);
        jProgressBar3 = new JProgressBar();
        jProgressBar3.setForeground(Color.YELLOW);
        jProgressBar4 = new JProgressBar();
        jProgressBar4.setForeground(Color.GREEN);
        jProgressBar5 = new JProgressBar();
        jProgressBar5.setForeground(Color.BLUE);

        //Creating panel for bars
        JPanel barPanel = new JPanel();
        barPanel.setLayout(new BoxLayout(barPanel, BoxLayout.Y_AXIS));
        barPanel.add(jProgressBar1);
        barPanel.add(jProgressBar2);
        barPanel.add(jProgressBar3);
        barPanel.add(jProgressBar4);
        barPanel.add(jProgressBar5);

        JButton button1 = new JButton("First Bar");
        button1.addActionListener(e -> doTheJob(thread1, jProgressBar1));
        JButton button2 = new JButton("Second Bar");
        button2.addActionListener(e -> doTheJob2());
        JButton button3 = new JButton("Third Bar");
        button3.addActionListener(e -> doTheJob3());
        JButton button4 = new JButton("Fourth Bar");
        button4.addActionListener(e -> doTheJob4());
        JButton button5 = new JButton("Fifth Bar");
        button5.addActionListener(e -> doTheJob5());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        jFrame.add(barPanel, BorderLayout.CENTER);
        jFrame.add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressMain::new);
    }

//    private void doTheJob(int numberOfThread) {
//        doTheJobUniversal();
//    }

    private void doTheJob(Thread thread, JProgressBar jProgressBar) {
        if (thread.isAlive()) {
            thread.interrupt();
        } else {
            thread = new Thread(() -> changingOfProgressBar(jProgressBar));
            thread.start();
        }
        System.out.println(thread);
    }

    private void changingOfProgressBar(JProgressBar jProgressBar) {
        while (true) {
            int currentPosition = jProgressBar.getValue();
            if (currentPosition >= jProgressBar.getMaximum()) {
                currentPosition = 0;
            }
            jProgressBar.setValue(currentPosition + DELTA);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                break;
            }
        }
    }

    private void doTheJob2() {
        if (thread2.isAlive()) {
            thread2.interrupt();
        } else {
            thread2 = new Thread(() -> {
                changingOfProgressBar(jProgressBar2);
            });
            thread2.start();
        }


    }

    private void doTheJob3() {
        if (thread3.isAlive()) {
            thread3.interrupt();
        } else {
            thread3 = new Thread(() -> {
                changingOfProgressBar(jProgressBar3);
            });
            thread3.start();
        }
    }

    private void doTheJob4() {
        if (thread4.isAlive()) {
            thread4.interrupt();
        } else {
            thread4 = new Thread(() -> {
                changingOfProgressBar(jProgressBar4);
            });
            thread4.start();
        }
    }

    private void doTheJob5() {
        if (thread5.isAlive()) {
            thread5.interrupt();
        } else {
            thread5 = new Thread(() -> {
                changingOfProgressBar(jProgressBar5);
            });
            thread5.start();
        }
    }
}