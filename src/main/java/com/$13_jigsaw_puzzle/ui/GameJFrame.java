package com.$13_jigsaw_puzzle.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

// 游戏主界面
public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // JFrame: 表示界面, 窗体
    // JFrame子类也表示界面和窗体
    // 规定: GameJFrame: 表示游戏的主界面, 与游戏相关逻辑写在此类中
    // 创建一个随机数对象, 用于随机图片
    Random random = new Random();
    // 定义二维数组, 用来随机图片位置
    int[][] arrayTwo = new int[4][4];
    // 定义变量, 记录空白方块对象的x, y 索引
    int x;
    int y;
    // 定义变量, 记录图片文件夹路径
    // D:\Users\Administrator\IdeaProjects\JavaStudy\$5_JavaSeNewStudy
    String path = "src/com/$13_jigsaw_puzzle/image/%s/%s%d/";
    String[] array = {"animal", "girl", "sport"};
    // 定义一个正确的二维数组, 用于判断是否胜利
    int[][] win = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}};
    // 定义变量, 统计步数
    int step = 0;
    // 创建"功能"选项下的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    // 创建"关于我们"选项下的条目对象
    JMenuItem accountItem = new JMenuItem("公众号");
    // 创建更换图片下的条目对象
    JMenuItem girlImage = new JMenuItem("美女图片");
    JMenuItem animalImage = new JMenuItem("动物图片");
    JMenuItem sportImage = new JMenuItem("运动员图片");
    public GameJFrame(int width, int height, boolean flag) {
        initJFrame(width, height, flag);
    }
    
    // 初始化界面
    public void initJFrame(int width, int height, boolean flag) {
        // 设置界面宽高和是否显示
        this.setSize(width, height);
        // 设置界面标题
        this.setTitle("拼图单机版 v1.0");
        // 设置界面置顶 ==> 让窗口一直显示在其他应用上层
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式, 关闭界面后结束程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消系统默认的居中放置设置, 只有取消该设置, 才会按照自己设置的方式放置图片
        this.setLayout(null);
        // 给界面添加键盘监听事件
        this.addKeyListener(this);
        // 菜单初始化方法
        initJMenuBar();
        // 二维数组数据初始化
        initData();
        // 定义图片类型
        picType();
        // 添加图片方法
        initImage();
        // 显示窗口设置建议写在最后
        this.setVisible(flag);
    }
    
    // 初始化菜单
    public void initJMenuBar() {
        // 初始化菜单
        // 创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单选项对象(功能, 关于我们, 更换图片)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeImage = new JMenu("更换图片");
        // 将条目对象添加到选项对象中
        functionJMenu.add(changeImage); // 菜单选项对象中可以继续添加菜单选项
        functionJMenu.add(this.replayItem);
        functionJMenu.add(this.reLoginItem);
        functionJMenu.add(this.closeItem);
        aboutJMenu.add(this.accountItem);
        changeImage.add(this.girlImage);
        changeImage.add(this.animalImage);
        changeImage.add(this.sportImage);
        // 给菜单条目绑定事件
        this.replayItem.addActionListener(this);
        this.reLoginItem.addActionListener(this);
        this.closeItem.addActionListener(this);
        this.accountItem.addActionListener(this);
        this.girlImage.addActionListener(this);
        this.animalImage.addActionListener(this);
        this.sportImage.addActionListener(this);
        // 将选项对象添加到菜单对象中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        // 为整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    
    // 初始化图片
    public void initImage() {
        // 清空界面中原来的图片
        this.getContentPane().removeAll();
        if (victory()) {
            // 添加胜利图片
            JLabel winJLabel = new JLabel(new ImageIcon("src/com/$13_jigsaw_puzzle/image/win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }
        // 添加显示步数的容器
        JLabel stepJLabel = new JLabel("Step:%d".formatted(this.step));
        stepJLabel.setBounds(20, 10, 100, 20);
        stepJLabel.setBorder(new BevelBorder(0));
        this.getContentPane().add(stepJLabel);
        // 初始化图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrayTwo[i][j] == 0) {
                    x = i;
                    y = j;
                }
                // 1. 创建一个图片ImageIcon的对象
                ImageIcon icon = new ImageIcon(("%s%d.jpg").formatted(this.path, this.arrayTwo[i][j]));
                // 2. 创建一个JLabel对象(管理容器)
                JLabel jLabel = new JLabel(icon);
                // 指定图片位置
                jLabel.setBounds(j * 105 + 100, i * 105 + 110, 105, 105);
                // 给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                // 3. 把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
        // 添加背景图片
        ImageIcon iconBackGround = new ImageIcon("src/com/$13_jigsaw_puzzle/image/background.png");
        JLabel jLabelBackGround = new JLabel(iconBackGround);
        jLabelBackGround.setBounds(56, 15, 508, 560);
        this.getContentPane().add(jLabelBackGround);
        // 图片添加完毕后, 刷新界面
        this.getContentPane().repaint();
    }
    
    // 二维数组数据初始化
    public void initData() {
        // 定义一维数组, 存储0-15
        int[] array = new int[16];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        // 打乱数组顺序
        for (int i = 0; i < array.length; i++) {
            int ranNum = this.random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[ranNum];
            array[ranNum] = temp;
        }
        // 为二维数组赋值
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.arrayTwo[i][j] = array[i * 4 + j];
            }
        }
        System.out.println(Arrays.toString(array));
    }
    
    // 重写KeyListener接口方法
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        // 判断游戏是否胜利, 如果胜利, 直接结束方法, 不能再移动图片
        if (victory()) {
            System.out.println("游戏结束");
            return;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.step++;
            // 空白方块向上移动
            if (x == 0) {
                x = x;
            } else {
                arrayTwo[x][y] = arrayTwo[x - 1][y];
                arrayTwo[x - 1][y] = 0;
                x--;
                initImage();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.step++;
            // 空白方块向下移动
            if (x == 3) {
                x = x;
            } else {
                arrayTwo[x][y] = arrayTwo[x + 1][y];
                arrayTwo[x + 1][y] = 0;
                x++;
                initImage();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.step++;
            // 空白方块向左移动
            if (y == 0) {
                y = y;
            } else {
                arrayTwo[x][y] = arrayTwo[x][y - 1];
                arrayTwo[x][y - 1] = 0;
                y--;
                initImage();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.step++;
            // 空白方块向右移动
            if (y == 3) {
                y = y;
            } else {
                arrayTwo[x][y] = arrayTwo[x][y + 1];
                arrayTwo[x][y + 1] = 0;
                y++;
                initImage();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            // 显示完整图片
            // 清空界面图片
            this.getContentPane().removeAll();
            // 按下A键, 显示拼图完整图片
            ImageIcon icon = new ImageIcon("%sall.jpg".formatted(this.path));
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(100, 110, 420, 420);
            jLabel.setBorder(new BevelBorder(0));
            this.getContentPane().add(jLabel);
            // 添加背景图片
            ImageIcon iconBackGround = new ImageIcon("src/com/$13_jigsaw_puzzle/image/background.png");
            JLabel jLabelBackGround = new JLabel(iconBackGround);
            jLabelBackGround.setBounds(56, 15, 508, 560);
            this.getContentPane().add(jLabelBackGround);
            // 刷新界面
            this.getContentPane().repaint();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // 判断游戏是否胜利, 如果胜利, 直接结束方法, 不能再移动图片
        if (victory()) {
            System.out.println("游戏结束");
            return;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_A) {
            initImage();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            // 作弊码, 按下'W'键松开后, 直接完成拼图
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 3 && j == 3) {
                        arrayTwo[i][j] = 0;
                    } else {
                        this.arrayTwo[i][j] = i * 4 + j + 1;
                    }
                }
            }
            initImage();
        }
    }
    
    // 定义方法, 设置初始图片类型
    public void picType() {
        int num = this.random.nextInt(3);
        if (array[num].equals("animal")) {
            this.path = this.path.formatted(this.array[0], this.array[0], this.random.nextInt(1, 9));
        } else if (array[num].equals("girl")) {
            this.path = this.path.formatted(this.array[1], this.array[1], this.random.nextInt(1, 14));
        } else if (array[num].equals("sport")) {
            this.path = this.path.formatted(this.array[2], this.array[2], this.random.nextInt(1, 11));
        }
    }
    
    // 定义方法, 判断是否已经胜利
    public boolean victory () {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arrayTwo[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断条目对象, 执行对应操作
        if (e.getSource() == this.replayItem) {
            // 重新游戏
            System.out.println("重新游戏");
            // 打乱二维数组顺序
            initData();
            // 计步器清零
            this.step = 0;
            // 图片初始化
            initImage();
        } else if (e.getSource() == this.closeItem) {
            // 关闭游戏, 退出虚拟机
            System.out.println("退出游戏...");
            System.exit(0);
        } else if (e.getSource() == this.reLoginItem) {
            // 重新登录
            // 关闭当前界面
            this.setVisible(false);
            // 打开登录界面, 重置验证码
           LoginJFrame.verificationCode = LoginJFrame.verificationCode();
            new LoginJFrame(567, 500, true);
        } else if (e.getSource() == this.accountItem) {
            // 关于我们, 展示黑马公众号图片
            // 创建JDialog对象
            JDialog jDialog = new JDialog();
            // 设置JDialog窗体尺寸
            jDialog.setSize(280, 300);
            // 设置标题
            jDialog.setTitle("黑马公众号");
            // 设置界面居中
            jDialog.setLocationRelativeTo(null);
            // 设置界面置顶
            jDialog.setAlwaysOnTop(true);
            jDialog.setLayout(null);
            JLabel jLabel = new JLabel(new ImageIcon("src/com/$13_jigsaw_puzzle/image/about.png"));
            jLabel.setBounds(0, 0, 258, 258);
            jDialog.getContentPane().add(jLabel);
            // 设置弹框不关闭无法操作其他界面
            jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if (e.getSource() == this.girlImage) {
            this.path = "src/com/$13_jigsaw_puzzle/image/girl/girl%d/".formatted(this.random.nextInt(13) + 1);
            initData();
            this.step = 0;
            initImage();
        } else if (e.getSource() == this.animalImage) {
            this.path = "src/com/$13_jigsaw_puzzle/image/animal/animal%d/".formatted(this.random.nextInt(8) + 1);
            this.step = 0;
            initImage();
        } else if (e.getSource() == this.sportImage) {
            this.path = "src/com/$13_jigsaw_puzzle/image/sport/sport%d/".formatted(this.random.nextInt(10) + 1);
            this.step = 0;
            initImage();
        }
    }
}
