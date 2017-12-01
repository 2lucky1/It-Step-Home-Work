package com.muntian.ht42_progress_bars;

import javax.swing.*;
import java.awt.*;

public class ProgressMain {
    private static final int DELTA = 1;
    private static final int WIDTH_OF_WINDOW = 500;
    private static final int HEIGHT_OF_WINDOW = 250;
    private static final int SLEEP_TIME_OF_PROGRESS_BAR = 100;

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

    private ProgressMain() {
        //Creating of UI window
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

        //Creating of buttons to start/stop bars
        JButton button1 = new JButton("First Bar");
        button1.addActionListener(e -> thread1 = doTheJob(thread1, jProgressBar1));
        JButton button2 = new JButton("Second Bar");
        button2.addActionListener(e -> thread2 = doTheJob(thread2, jProgressBar2));
        JButton button3 = new JButton("Third Bar");
        button3.addActionListener(e -> thread3 = doTheJob(thread3, jProgressBar3));
        JButton button4 = new JButton("Fourth Bar");
        button4.addActionListener(e -> thread4 = doTheJob(thread4, jProgressBar4));
        JButton button5 = new JButton("Fifth Bar");
        button5.addActionListener(e -> thread5 = doTheJob(thread5, jProgressBar5));

        //Add buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        //Add panels of bars and buttons to the UI window
        jFrame.add(barPanel, BorderLayout.CENTER);
        jFrame.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgressMain::new);
    }

    /**
     * Runs the progress bar if it is off, and stops progress bar if it is on.
     * Each time progress bar starts in new thread. That`s why in this case method
     * returns new thread. This make be able to reassign this new thread to thread
     * which passed in parameters. It was implemented to make method reusable.
     *
     * @param thread in this parameter is passed thread which works with progress bar
     * @param jProgressBar progress bar from appropriate thread which is passed into parameters
     * @return  thread which was passed in parameters if thread is alive or new thread
     * if thread in parameters is not alive
     */
    private Thread doTheJob(Thread thread, JProgressBar jProgressBar) {
        if (thread.isAlive()) {
            thread.interrupt();
        } else {
            thread = new Thread(() -> {
                while (true) {
                    int currentPosition = jProgressBar.getValue();
                    if (currentPosition >= jProgressBar.getMaximum()) {
                        currentPosition = 0;
                    }
                    jProgressBar.setValue(currentPosition + DELTA);
                    try {
                        Thread.sleep(SLEEP_TIME_OF_PROGRESS_BAR);
                    } catch (InterruptedException ignored) {
                        break;
                    }
                }
            });
            thread.start();
            return thread;
        }
        return thread;
    }
}