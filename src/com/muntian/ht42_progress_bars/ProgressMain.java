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

    public ProgressMain() {
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

        Thread thread1 = new Thread(() -> {
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
        Thread thread2 = new Thread(() -> {
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
        Thread thread3 = new Thread(() -> {
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
        Thread thread4 = new Thread(() -> {
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
        Thread thread5 = new Thread(() -> {
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
        button2.addActionListener(e -> doTheJob(thread2, jProgressBar2));
        JButton button3 = new JButton("Third Bar");
        button3.addActionListener(e -> doTheJob(thread3, jProgressBar3));
        JButton button4 = new JButton("Fourth Bar");
        button4.addActionListener(e -> doTheJob(thread4, jProgressBar4));
        JButton button5 = new JButton("Fifth Bar");
        button5.addActionListener(e -> doTheJob(thread5, jProgressBar5));

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

    private void doTheJob(Thread thread, JProgressBar jProgressBar) {
        if (thread.isAlive()) {
            thread.interrupt();
        } else {
            thread.start();
        }
    }
}

class MyRunnable implements Runnable {
    private int count;
    private static final int DELTA = 1;
    private JProgressBar jProgressBar;


    public MyRunnable(JProgressBar jProgressBar) {
        this.count = 0;
        this.jProgressBar = jProgressBar;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int currentPosition = jProgressBar.getValue();
            if (currentPosition >= jProgressBar.getMaximum()) {
                currentPosition = 0;
            }
            jProgressBar.setValue(currentPosition + DELTA);
        }
    }
}

class MyThread extends Thread {
    private int count;

    public MyThread() {
        this.count = 0;
    }
}