package com.wqz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.*;

public class JMenuDemo1 extends JMenuBar {
    public JMenuDemo1() {
        add(createFileMenu());    //添加“文件”菜单
        add(createEditMenu());    //添加“编辑”菜单
        setVisible(true);
    }

    public static void main(String[] agrs) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("菜单栏");
        frame.setSize(300, 200);
        frame.setJMenuBar(new JMenuDemo1());
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ToolBarDemo1 newContentPane= new ToolBarDemo1();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        //显示窗体
        frame.pack();
        frame.setVisible(true);

    }

    //定义“文件”菜单
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("文件(F)");
        menu.setMnemonic(KeyEvent.VK_F);    //设置快速访问符
        JMenuItem item = new JMenuItem("新建(N)", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menu.add(item);
        item = new JMenuItem("打开(O)", KeyEvent.VK_O);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menu.add(item);
        item = new JMenuItem("保存(S)", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("退出(E)", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menu.add(item);
        return menu;
    }

    //定义“编辑”菜单
    private JMenu createEditMenu() {
        JMenu menu = new JMenu("编辑(E)");
        menu.setMnemonic(KeyEvent.VK_E);
        JMenuItem item = new JMenuItem("撤销(U)", KeyEvent.VK_U);
        item.setEnabled(false);
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("剪贴(T)", KeyEvent.VK_T);
        menu.add(item);
        item = new JMenuItem("复制(C)", KeyEvent.VK_C);
        menu.add(item);
        menu.addSeparator();
        JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("自动换行");
        menu.add(cbMenuItem);
        return menu;
    }

}
class ToolBarDemo1 extends JPanel implements ActionListener
{
    protected JTextArea textArea;
    protected String newline="\n";
    static final private String OPEN="OPEN";
    static final private String SAVE="SAVE";
    static final private String NEW="NEW";

    public ToolBarDemo1()
    {
        super(new BorderLayout());
        //创建工具栏
        JToolBar toolBar=new JToolBar();
        addButtons(toolBar);
        //创建一个文本域，用来输出一些信息
        textArea=new JTextArea(15, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(textArea);
        //把组件添加到面板中
        setPreferredSize(new Dimension(450, 110));
        add(toolBar,BorderLayout.PAGE_START);
        add(scrollPane,BorderLayout.CENTER);
    }

    protected void addButtons(JToolBar toolBar)
    {
        JButton button=null;
        button=makeNavigationButton("new1",NEW,"新建一个文件","新建");
        toolBar.add(button);
        button=makeNavigationButton("open1",OPEN,"打开一个文件","打开");
        toolBar.add(button);
        button=makeNavigationButton("save1",SAVE,"保存当前文件","保存");
        toolBar.add(button);
    }
    protected JButton makeNavigationButton(String imageName,String actionCommand,String toolTipText,String altText)
    {
        //搜索图片
        String imgLocation=imageName+".png";
        URL imageURL= com.wqz.ToolBarDemo.class.getClassLoader().getResource(imgLocation);
        //初始化工具按钮
        JButton button=new JButton();
        //设置按钮的命令
        button.setActionCommand(actionCommand);
        //设置提示信息
        button.setToolTipText(toolTipText);
        button.addActionListener(this);
        if(imageURL!=null)
        {
            //找到图像
            button.setIcon(new ImageIcon(imageURL));
        }
        else
        {
            //没有图像
            button.setText(altText);
            System.err.println("Resource not found: "+imgLocation);
        }
        return button;
    }

    //事件监听器部分的代码省略，请查阅源文件
    protected void displayResult(String actionDescription)
    {
        textArea.append(actionDescription+newline);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}