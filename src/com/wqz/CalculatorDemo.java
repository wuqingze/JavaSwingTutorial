package com.wqz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
public class CalculatorDemo extends JFrame
{
    private JPanel contentPane;    //内容面板
    private JTextField textField;    //文本框
    private JTextField expressionFiles;
    private String expression;
    public CalculatorDemo()
    {
        expression = new String();

        setTitle("计算器");    //设置窗体的标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗体退出时操作
        setBounds(100, 100, 250, 200);    //设置窗体位置和大小
        contentPane=new JPanel();    //创建内容面板
        contentPane.setBorder(new EmptyBorder(5,5,5,5));    //设置面板的边框
        contentPane.setLayout(new BorderLayout(0,0));    //设置内容面板为边界布局
        setContentPane(contentPane);    //应用内容面板
        JPanel panel1=new JPanel();    //新建面板用于保存文本框
        contentPane.add(panel1,BorderLayout.NORTH);    //将面板放置在边界布局的北部
        textField=new JTextField();    //新建文本框
        textField.setHorizontalAlignment(SwingConstants.RIGHT);    //文本框中的文本使用右对齐

        expressionFiles=new JTextField();    //新建文本框
        panel1.add(textField);    //将文本框增加到面板中
        textField.setColumns(18);    //设置文本框的列数是18
        textField.setText(expression);
        textField.setEditable(false);
        addcomponent();
    }

    public void addcomponent(){
        JPanel panel2=new JPanel();    //新建面板用于保存按钮
        contentPane.add(panel2, BorderLayout.CENTER);    //将面板放置在边界布局的中央
        panel2.setLayout(new GridLayout(5,4,5,5));    //面板使用网格4X4布局
        JButton button01=new NumButton("7");    //新建按钮
        panel2.add(button01);    //应用按钮
        JButton button02=new NumButton("8");    //新建按钮
        panel2.add(button02);    //应用按钮
        JButton button03=new NumButton("9");    //新建按钮
        panel2.add(button03);    //应用按钮
        JButton button04=new OperatorButton("+");    //新建按钮
        panel2.add(button04);    //应用按钮
        JButton button05=new NumButton("4");    //新建按钮
        panel2.add(button05);    //应用按钮
        JButton button06=new NumButton("5");    //新建按钮
        panel2.add(button06);    //应用按钮
        JButton button07=new NumButton("6");    //新建按钮
        panel2.add(button07);    //应用按钮
        JButton button08=new OperatorButton("-");    //新建按钮
        panel2.add(button08);    //应用按钮
        JButton button09=new NumButton("3");    //新建按钮
        panel2.add(button09);    //应用按钮
        JButton button10=new NumButton("2");    //新建按钮
        panel2.add(button10);    //应用按钮
        JButton button11=new NumButton("1");    //新建按钮
        panel2.add(button11);    //应用按钮
        JButton button12=new OperatorButton("*");    //新建按钮
        panel2.add(button12);    //应用按钮
        JButton button13=new NumButton("0");    //新建按钮
        panel2.add(button13);    //应用按钮
        JButton button14=new DotButton(".");    //新建按钮
        panel2.add(button14);    //应用按钮
        JButton button15=new EqualButton("=");    //新建按钮
        panel2.add(button15);    //应用按钮
        JButton button16=new OperatorButton("/");    //新建按钮
        panel2.add(button16);    //应用按钮

        JButton button17=new ClearButton("C");    //新建按钮
        panel2.add(button17);

        JButton button18=new RemoveLastButton("CE");    //新建按钮
        panel2.add(button18);


}
    public static void main(String[] args)
    {
        CalculatorDemo frame=new CalculatorDemo();
        frame.setVisible(true);
    }

    class NumButton extends JButton{
        String title;
        public NumButton(){
        }
        public NumButton(final String title){
            super(title);
            this.title = title;
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String temp = textField.getText();
                    expression = temp+title;
                    textField.setText(expression);
                }
            });
        }


    }

    class OperatorButton extends  JButton{
        private String title;

        public OperatorButton(){}

        public OperatorButton(final String title){
            super(title);
            this.title = title;
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(expression == null || "".equals(expression)){
                    }else{
                        char ch =expression.charAt(expression.length()-1);
                        if('+' == ch || '-' == ch || '*' == ch || '/' == ch){
                        }else{
                            expression = expression + title;
                            textField.setText(expression);
                        }

                    }
                }
            });
        }
    }

    class DotButton extends  JButton{
        private String title;

        public DotButton(){}

        public DotButton(final String title){
            super(title);
            this.title = title;
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(expression == null || "".equals(expression)){
                    }else{
                        char ch =expression.charAt(expression.length()-1);
                        if('.' == ch || '+' == ch || '-' == ch || '*' == ch || '/' == ch){
                        }else{
                            expression = expression + title;
                            textField.setText(expression);
                        }

                    }
                }
            });
        }
    }

    class EqualButton extends  JButton{
        private String title;

        public EqualButton(){}

        public EqualButton(final String title){
            super(title);
            this.title = title;
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(expression == null || "".equals(expression)){
                    }else{
                        expression = ""+caculate(expression);
                        textField.setText(expression);
                    }
                }
            });
        }
    }

    class ClearButton extends  JButton{
        private String title;

        public ClearButton(){}

        public ClearButton(final String title){
            super(title);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(expression == null || "".equals(expression)){
                    }else{
                        expression = "";
                        textField.setText(expression);
                    }
                }
            });
        }
    }

    class RemoveLastButton extends  JButton{
        private String title;

        public RemoveLastButton(){}

        public RemoveLastButton(final String title){
            super(title);
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(expression == null || "".equals(expression)){
                    }else{
                        expression = expression.substring(0,expression.length()-1);
                        textField.setText(expression);
                    }
                }
            });
        }
    }
    float caculate(String ex){
        ArrayList<String> l = new ArrayList<String>();
        int len = ex.length();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (i<len){
            if(ex.charAt(i) == '+' || ex.charAt(i)=='-' || ex.charAt(i)=='*' || ex.charAt(i) =='/'){
                if(!"".equals(sb.toString())){
                    l.add(sb.toString());
                    sb.delete(0,sb.toString().length());
                }
                l.add(ex.charAt(i)+"");
            }else{
                sb.append(ex.charAt(i));
            }
            i += 1;
            if(i == len){
                l.add(sb.toString());
            }
        }

        float result = 0;
        for(i=0;i<l.size();i++){
            if((i>0 && i<l.size()-1) && ("+".equals(l.get(i)) || "-".equals(l.get(i)) || "*".equals(l.get(i)) || "/".equals(l.get(i)))){
                if("+".equals(l.get(i))){
                    result += (Float.parseFloat(l.get(i-1)) + Float.parseFloat(l.get(i+1)));
                }else if("-".equals(l.get(i))){
                    result += (Float.parseFloat(l.get(i-1)) - Float.parseFloat(l.get(i+1)));
                }else if("*".equals(l.get(i))){
                    result += (Float.parseFloat(l.get(i-1)) * Float.parseFloat(l.get(i+1)));
                }else {
                    result += (Float.parseFloat(l.get(i-1)) / Float.parseFloat(l.get(i+1)));
                }

            }
        }
        return result;
    }
}