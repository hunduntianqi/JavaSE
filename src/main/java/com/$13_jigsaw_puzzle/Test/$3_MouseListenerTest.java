package com.$13_jigsaw_puzzle.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class $3_MouseListenerTest {
    public static void main(String[] args) {
        // 创建一个界面对象
        JFrame jFrame = new JFrame();
        // 设置界面宽高
        jFrame.setSize(603, 680);
        // 设置界面标题
        jFrame.setTitle("MouseListener鼠标事件演示");
        // 设置界面置顶显示
        jFrame.setAlwaysOnTop(true);
        // 设置界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消组件居中显示
        jFrame.setLayout(null);
        // 创建按钮对象
        JButton button = new JButton("点我啊~~");
        // 设置按钮位置和宽高
        button.setBounds(0, 0, 100, 50);
        // 给按钮添加鼠标监听 ==> MouseListener
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 鼠标按下并释放
                System.out.println("单击");
            }
    
            @Override
            public void mousePressed(MouseEvent e) {
                // 鼠标按下不松
                System.out.println("按下不松");
            }
    
            @Override
            public void mouseReleased(MouseEvent e) {
                // 鼠标按下后松开
                System.out.println("松开");
            }
    
            @Override
            public void mouseEntered(MouseEvent e) {
                // 鼠标划入监听区域
                System.out.println("鼠标划入");
            }
    
            @Override
            public void mouseExited(MouseEvent e) {
                // 鼠标划出监听区域
                System.out.println("鼠标划出");
            }
        });
        // 将按钮对象添加到界面中
        jFrame.getContentPane().add(button);
        // 设置显示窗口
        jFrame.setVisible(true);
    }
}
