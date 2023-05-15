package com.$13_jigsaw_puzzle.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class $4_KeyListenerTest {
    public static void main(String[] args) {
        // 创建一个界面对象
        JFrame jFrame = new JFrame();
        // 设置界面宽高
        jFrame.setSize(603, 680);
        // 设置界面标题
        jFrame.setTitle("KeyListener键盘事件演示");
        // 设置界面置顶显示
        jFrame.setAlwaysOnTop(true);
        // 设置界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消组件居中显示
        jFrame.setLayout(null);
        // 给窗体添加键盘监听 ==> KeyListener
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // 键入时调用
//                System.out.println("按下按键！！");
            }
    
            @Override
            public void keyPressed(KeyEvent e) {
                // 按下按键时调用, 如果按下不松, 会重复调用该方法
                if (e.getExtendedKeyCode() == KeyEvent.VK_A) {
                    System.out.println("按下按键'A'");
                }
            }
    
            @Override
            public void keyReleased(KeyEvent e) {
                // 松开按键时调用
                System.out.println("松开按键");
            }
        });
        // 设置显示窗口
        jFrame.setVisible(true);
    }
}
