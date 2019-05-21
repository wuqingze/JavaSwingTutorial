package com.wqz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo
{
    public static int cardnum = 1;
//    public static CardLayout cl;
    public static void main(String[] agrs)
    {
        JFrame frame=new JFrame("Java第五个程序");    //创建Frame窗口
        JPanel p1=new JPanel();    //面板1
        JPanel p2=new JPanel();    //面板2
        final JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        JButton jj = new JButton("jjj");
        JButton kk = new JButton("kk");

        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(jj);
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(kk);
        cards.add(p1,"card1");    //向卡片式布局面板中添加面板1
        cards.add(p2,"card2");    //向卡片式布局面板中添加面板2
        final CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card"+cardnum);    //调用show()方法显示面板2

        jj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardnum == 1){
                    cl.show(cards,"card2");
                    cardnum = 2;
                }else {
                    cl.show(cards,"card1");
                    cardnum = 1;
                }
            }
        });
        kk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardnum == 1){
                    cl.show(cards,"card2");
                    cardnum = 2;
                }else {
                    cl.show(cards,"card1");
                    cardnum = 1;
                }
            }
        });
        frame.add(cards);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void test(){
        JFrame frame=new JFrame("Java第五个程序");    //创建Frame窗口
        JPanel p1=new JPanel();    //面板1
        JPanel p2=new JPanel();    //面板2
        final JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        JButton jj = new JButton("jjj");
        JButton kk = new JButton("kk");

        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(jj);
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(kk);
        cards.add(p1,"card1");    //向卡片式布局面板中添加面板1
        cards.add(p2,"card2");    //向卡片式布局面板中添加面板2
        final CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card"+cardnum);    //调用show()方法显示面板2

        jj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardnum == 1){
                    cl.show(cards,"card2");
                    cardnum = 2;
                }else {
                    cl.show(cards,"card1");
                    cardnum = 1;
                }
            }
        });
        kk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardnum == 1){
                    cl.show(cards,"card2");
                    cardnum = 2;
                }else {
                    cl.show(cards,"card1");
                    cardnum = 1;
                }
            }
        });
        frame.add(cards);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

