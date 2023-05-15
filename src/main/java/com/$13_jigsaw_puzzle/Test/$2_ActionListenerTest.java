package com.$13_jigsaw_puzzle.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class $2_ActionListenerTest {
    public static void main(String[] args) {
        // 创建一个界面对象
        JFrame jFrame = new JFrame();
        // 设置界面宽高
        jFrame.setSize(603, 680);
        // 设置界面标题
        jFrame.setTitle("ActionListener动作事件演示");
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
        // 给按钮添加动作监听 ==> 鼠标左键点击和空格键监听
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("这是一个匿名内部类, 按钮被电击了~~~");
            }
        });
        // 将按钮对象添加到界面中
        jFrame.getContentPane().add(button);
        // 设置显示窗口
        jFrame.setVisible(true);
    }
}
