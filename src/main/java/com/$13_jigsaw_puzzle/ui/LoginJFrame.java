package com.$13_jigsaw_puzzle.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

// 登录界面
public class LoginJFrame extends JFrame implements MouseListener {
    // 定义登录按钮
    JButton loginButton = new JButton("登录");
    // 定义注册按钮
    JButton registerButton = new JButton("注册");
//     // 定义显示密码按钮
//    JButton showPassWordButton = new JButton("显示密码");
//     // 定义变量, 接收验证码
    static String verificationCode;
    // 定义变量, 存储用户名
    static String userName;
    // 定义变量, 存储密码
    static String passWord;
    // 使用静态代码块, 初始化用户名和密码, 验证码等信息
    static {
        userName = "17320101759";
        passWord = "2251789949gpt";
        verificationCode = verificationCode();
    }
    // 创建用户文本输入框
    JTextField userText = new JTextField();
    // 创建密码输入框
    JPasswordField passWordText = new JPasswordField();
    // 创建验证码输入框
    JTextField verificationText = new JTextField();
    
    public LoginJFrame() {}
    
    public LoginJFrame (int width, int height, boolean flag) {
        initLoginJFrame(width, height, flag);
    }
    public void initLoginJFrame (int width, int height, boolean flag) {
        // 设置界面宽高和是否显示
        this.setSize(width, height);
        // 设置界面标题
        this.setTitle("拼图登录界面");
        // 设置界面置顶 ==> 让窗口一直显示在其他应用上层
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式, 关闭界面后结束程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消系统默认的居中放置设置, 只有取消该设置, 才会按照自己设置的方式放置图片
        this.setLayout(null);
        // 为登录按钮绑定鼠标监听事件
        this.loginButton.addMouseListener(this);
        // 为注册按钮绑定鼠标监听事件
        this.registerButton.addMouseListener(this);
        // 为显示密码按钮绑定鼠标监听事件
//        this.showPassWordButton.addMouseListener(this);
        // 初始化输入框数据
        initData();
        // 初始化背景图片
        initImage();
        // 显示窗口设置建议写在最后
        this.setVisible(flag);
    }
    
    // 初始化输入框数据, 避免null异常
    public void initData () {
        this.userText.setText("");
        this.passWordText.setText("");
//        this.passWordText.setEchoChar((char)0); // 设置密码明文显示
        this.verificationText.setText("");
    }
    // 初始化背景图片
    public void initImage () {
        this.getContentPane().removeAll();
        // 添加用户名图片
        JLabel userJLabel = new JLabel(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/用户名.png"));
        userJLabel.setBounds(150, 200, 47, 17);
        this.getContentPane().add(userJLabel);
        JLabel userJLabelChar = new JLabel(":");
        userJLabelChar.setBounds(200, 200, 10, 17);
        this.getContentPane().add(userJLabelChar);
        // 设置用户名文本框大小与位置
        this.userText.setBounds(210, 200, 150, 17);
        this.getContentPane().add(this.userText);
        // 添加密码图片
        JLabel passWordJLabel = new JLabel(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/密码.png"));
        passWordJLabel.setBounds(158, 230, 32, 16);
        this.getContentPane().add(passWordJLabel);
        JLabel passWordJLabelChar = new JLabel(":");
        passWordJLabelChar.setBounds(200, 230, 10, 16);
        this.getContentPane().add(passWordJLabelChar);
        // 设置密码文本框大小与位置
        this.passWordText.setBounds(210, 230, 150, 16);
        this.getContentPane().add(this.passWordText);
        // 添加显示密码图片
//        this.showPassWordButton.setIcon(new ImageIcon("src/src/com/$13_jigsaw_puzzle/image/login/显示密码.png"));
////        JLabel showPassWordJLabel = new JLabel();
////        this.showPassWordButton.setSize(18, 19);
//        this.showPassWordButton.setBounds(370, 225, 20, 29);
//        this.getContentPane().add(this.showPassWordButton);
        // 添加验证码图片
        JLabel verificationJLabel = new JLabel(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/验证码.png"));
        verificationJLabel.setBounds(145, 260, 56, 21);
        this.getContentPane().add(verificationJLabel);
        JLabel verificationJLabelChar = new JLabel(":");
        verificationJLabelChar.setBounds(200, 260, 10, 21);
        this.getContentPane().add(verificationJLabelChar);
        // 设置验证码输入框大小与位置
        verificationText.setBounds(210, 260, 150, 21);
        this.getContentPane().add(verificationText);
        // 添加验证码显示区域
        JLabel verificationShow = new JLabel(LoginJFrame.verificationCode);
        verificationShow.setBounds(370, 260, 70, 21);
        this.getContentPane().add(verificationShow);
        // 添加登录按钮
//        JLabel loginButtonJLabel = new JLabel(new ImageIcon("src/main/java/$13_jigsaw_puzzle/image/login/登录按钮.png"));
        this.loginButton.setIcon(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/登录按钮.png"));
        this.loginButton.setBounds(135, 290, 128, 47);
        this.loginButton.setBorderPainted(false); // 去除按钮的默认边框
        this.loginButton.setContentAreaFilled(false); // 去除按钮默认背景
        this.getContentPane().add(this.loginButton);
        // 添加注册按钮
//        JLabel registerJLabel = new JLabel(new ImageIcon("src/src/com/$13_jigsaw_puzzle/image/login/注册按钮.png"));
        this.registerButton.setIcon(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/注册按钮.png"));
        this.registerButton.setBounds(283, 290, 128, 47);
        this.registerButton.setBorderPainted(false); // 取消按钮的默认边框
        this.registerButton.setContentAreaFilled(false); // 取消按钮的默认背景
        this.getContentPane().add(this.registerButton);
        // 添加背景图片
        JLabel jLabel = new JLabel(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/background.png"));
        jLabel.setBounds(40, 35, 470, 390);
        this.getContentPane().add(jLabel);
        this.getContentPane().repaint();
    }
    
    // 定义方法, 生成验证码
    public static String verificationCode() {
        // 创建Random对象
        Random random = new Random();
        char[] ch = new char[5];
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                ch[i] = (char) (random.nextInt(10) + 48);
            } else {
                int type = random.nextInt(2);
                switch (type) {
                    case 0:
                        ch[i] = (char) (random.nextInt(26) + 65);
                        break;
                    case 1:
                        ch[i] = (char) (random.nextInt(26) + 97);
                        break;
                }
            }
        }
        // 打乱数组
        for (int i = 0; i < ch.length; i++) {
            int temp = random.nextInt(ch.length);
            char flag = ch[temp];
            ch[temp] = ch[i];
            ch[i] = flag;
        }
        // 根据字符数组创建字符串
        String verificationCode = new String(ch);
        return verificationCode;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(this.loginButton)) {
            this.loginButton.setIcon(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/登录按下.png"));
        } else if (e.getSource().equals(this.registerButton)) {
            this.registerButton.setIcon(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/注册按下.png"));
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource().equals(this.loginButton)) {
            this.loginButton.setIcon(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/登录按钮.png"));
            if (this.userText.getText().equals(LoginJFrame.userName)) {
                if (this.passWordText.getText().equals(LoginJFrame.passWord)) {
                    if (this.verificationText.getText().equalsIgnoreCase(LoginJFrame.verificationCode)) {
                        System.out.println("验证通过, 进入游戏！！");
                        this.setVisible(false);
                        new GameJFrame(630, 680, true);
                    } else {
                        this.showJDialog("验证码错误！！");
                    }
                } else {
                    this.showJDialog("密码错误！！");
                }
            } else {
                this.showJDialog("用户名错误！！");
            }
        } else if (e.getSource().equals(this.registerButton)) {
            this.registerButton.setIcon(new ImageIcon("src/com/$13_jigsaw_puzzle/image/login/注册按钮.png"));
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    
    }
    
    // 定义方法, 设置提示弹窗
    public void showJDialog (String str) {
        JDialog userJDialog = new JDialog();
        userJDialog.setTitle("提示:");
        userJDialog.setSize(100, 60);
        userJDialog.setLocationRelativeTo(null);
        userJDialog.setAlwaysOnTop(true);
        userJDialog.setLayout(null);
        JLabel userFalse = new JLabel(str);
        userFalse.setBounds(0, 0, 100, 20);
        userJDialog.getContentPane().add(userFalse);
        userJDialog.setModal(true);
        userJDialog.setVisible(true);
        LoginJFrame.verificationCode = LoginJFrame.verificationCode();
        this.userText.setText("");
        this.passWordText.setText("");
        this.verificationText.setText("");
        this.initImage();
    }
}
