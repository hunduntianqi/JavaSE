package com.$13_jigsaw_puzzle.ui;

import javax.swing.*;
// 注册界面
public class RegisterJFrame extends JFrame {
    public RegisterJFrame () {}
    
    public RegisterJFrame (int width, int height, boolean flag) {
        // 设置界面宽高和是否显示
        this.setSize(width, height);
        // 设置界面标题
        this.setTitle("拼图注册界面");
        // 设置界面置顶 ==> 让窗口一直显示在其他应用上层
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式, 关闭界面后结束程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 显示窗口设置建议写在最后
        this.setVisible(flag);
    }
}
