package com.wqz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
public class BorderLayoutDemo
{
    public static void main(String[] agrs)
    {
        test();
        test1();
    }

    public static void test(){
        JFrame frame=new JFrame("Java第三个GUI程序 frame");    //创建Frame窗口
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
        JButton button1=new JButton ("上");
        JButton button2=new JButton("左");
        JButton button3=new JButton("中");
        JButton button4=new JButton("右");
        JButton button5=new JButton("下");
        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.WEST);
        frame.add(button3,BorderLayout.CENTER);
        frame.add(button4,BorderLayout.EAST);
        frame.add(button5,BorderLayout.SOUTH);
        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void test1(){
        JFrame frame=new JFrame("Java第三个GUI程序 panel");    //创建Frame窗口
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
        JPanel jpapel = new JPanel();
        jpapel.setLayout(new BorderLayout());
        JButton button1=new JButton ("上");
        JButton button2=new JButton("左");
        JButton button3=new JButton("中");
        JButton button4=new JButton("右");
        JButton button5=new JButton("下");

        jpapel.add(button1,BorderLayout.NORTH);
        jpapel.add(button2,BorderLayout.WEST);
        jpapel.add(button3,BorderLayout.CENTER);
        jpapel.add(button4,BorderLayout.EAST);
        jpapel.add(button5,BorderLayout.SOUTH);
        frame.add(jpapel);
        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}