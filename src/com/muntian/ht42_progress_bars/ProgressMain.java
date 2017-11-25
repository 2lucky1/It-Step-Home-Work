package com.muntian.ht42_progress_bars;

import javax.swing.*;
import java.awt.*;

public class ProgressMain {
    private static final int DELTA = 1;
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

    public Thread getThread1() {
        return thread1;
    }

    public void setThread1(Thread thread1) {
        this.thread1 = thread1;
    }

    private ProgressMain() {
        //Creating of window
        JFrame jFrame = new JFrame("5 progress bars");
        jFrame.setSize(500, 250);
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
        button1.addActionListener(e -> doTheJob1());
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

    private void doTheJob1() {
        if (thread1.isAlive()) {
            thread1.interrupt();
        } else {
            thread1 = new Thread(() -> {
                while (true) {
                    int currentPosition = jProgressBar1.getValue();
                    if (currentPosition >= jProgressBar1.getMaximum()) {
                        currentPosition = 0;
                    }
                    jProgressBar1.setValue(currentPosition + DELTA);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                        break;
                    }
                }
            });
            thread1.start();
        }
    }

    private void doTheJob2() {
        if (thread2.isAlive()) {
            thread2.interrupt();
        } else {
            thread2 = new Thread(() -> {
                while (true) {
                    int currentPosition = jProgressBar2.getValue();
                    if (currentPosition >= jProgressBar2.getMaximum()) {
                        currentPosition = 0;
                    }
                    jProgressBar2.setValue(currentPosition + DELTA);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                        break;
                    }
                }
            });
            thread2.start();
        }


    }

    private void doTheJob3() {
        if (thread3.isAlive()) {
            thread3.interrupt();
        } else {
            thread3 = new Thread(() -> {
                while (true) {
                    int currentPosition = jProgressBar3.getValue();
                    if (currentPosition >= jProgressBar3.getMaximum()) {
                        currentPosition = 0;
                    }
                    jProgressBar3.setValue(currentPosition + DELTA);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                        break;
                    }
                }
            });
            thread3.start();
        }
    }

    private void doTheJob4() {
        if (thread4.isAlive()) {
            thread4.interrupt();
        } else {
            thread4 = new Thread(() -> {
                while (true) {
                    int currentPosition = jProgressBar4.getValue();
                    if (currentPosition >= jProgressBar4.getMaximum()) {
                        currentPosition = 0;
                    }
                    jProgressBar4.setValue(currentPosition + DELTA);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                        break;
                    }
                }
            });
            thread4.start();
        }
    }

    private void doTheJob5() {
        if (thread5.isAlive()) {
            thread5.interrupt();
        } else {
            thread5 = new Thread(() -> {
                while (true) {
                    int currentPosition = jProgressBar5.getValue();
                    if (currentPosition >= jProgressBar5.getMaximum()) {
                        currentPosition = 0;
                    }
                    jProgressBar5.setValue(currentPosition + DELTA);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                        break;
                    }
                }
            });
            thread5.start();
        }
    }
}