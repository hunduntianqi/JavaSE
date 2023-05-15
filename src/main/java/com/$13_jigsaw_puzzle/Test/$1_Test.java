package com.$13_jigsaw_puzzle.Test;

import javax.swing.*;

public class $1_Test {
    public static void main(String[] args) {
        // 创建一个游戏的主界面
        JFrame gameJFrame = new JFrame();
        gameJFrame.setSize(630, 680); // 调用方法设置窗口大小
        gameJFrame.setVisible(true); // 界面默认为隐藏, 调用方法更改默认参数, 使其显示出来
        
        // 创建登录界面
        JFrame loginJFrame = new JFrame();
        loginJFrame.setSize(567, 500);
        loginJFrame.setVisible(true);
        
        // 创建注册界面
        JFrame registerJFrame = new JFrame();
        registerJFrame.setSize(567, 500);
        registerJFrame.setVisible(true);
    }
}
