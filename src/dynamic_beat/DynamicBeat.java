package dynamic_beat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private  ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
    private  ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
    private  ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
    private  ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
    private  ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
    private  ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));

    private  ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
    private  ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
    private  ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
    private  ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));

    private  ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
    private  ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
    private  ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
    private  ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
    private  ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
    private  ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));

    private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);

    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);

    private JButton easyButton = new JButton(easyButtonBasicImage);
    private JButton hardButton = new JButton(hardButtonBasicImage);
    private JButton backButton = new JButton(backButtonBasicImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    ArrayList<Track> trackList = new ArrayList<Track>();
    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic;
    private Music introMusic = new Music("introMusic.mp3", true);
    private int nowSelected = 0;

    public static Game game;

    public DynamicBeat() {
        trackList.add(new Track("Music1 Title Image.png", "Music1 Start Image.png",
                "Music1 Game Image.png", "music1.mp3", "music1.mp3","music1"));
        trackList.add(new Track("Music2 Title Image.png", "Music2 Start Image.png",
                "Music2 Game Image.png", "music2.mp3", "music2.mp3", "music2"));
        trackList.add(new Track("Music3 Title Image.png", "Music3 Start Image.png",
                "Music3 Game Image.png", "music3.mp3", "music3.mp3", "music3"));

        setUndecorated(true);
        setTitle("Dynamic Beat"); // ?????? ?????? ??????
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // ???????????? ?????? ????????? ??????
        setLocationRelativeTo(null); // ???????????? ????????? ????????????
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ????????? ????????? ??????????????? ?????? ??????
        setVisible(true); // ???????????? ????????? ??????????????? ??????
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);
        introMusic.start();

        addKeyListener(new KeyListener());

        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(exitButton);

        startButton.setBounds(40, 200, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor((new Cursor(Cursor.HAND_CURSOR)));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                enterMain();
            }
        });
        add(startButton);

        quitButton.setBounds(40, 330, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(quitButton);

        leftButton.setVisible(false);
        leftButton.setBounds(140, 310, 60, 60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                selectRight();
            }
        });
        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1080, 310, 60, 60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                selectRight();
            }
        });
        add(rightButton);

        easyButton.setVisible(false);
        easyButton.setBounds(375, 580, 250, 67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easyButton.setIcon(easyButtonEnteredImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyButtonBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                gameStart(nowSelected, "Easy");
            }
        });
        add(easyButton);

        hardButton.setVisible(false);
        hardButton.setBounds(655, 580, 250, 67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hardButton.setIcon(hardButtonEnteredImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardButtonBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                gameStart(nowSelected, "Hard");
            }
        });
        add(hardButton);

        backButton.setVisible(false);
        backButton.setBounds(20, 50, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonBasicImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
                buttonEnteredMusic.start();
                backMain();
            }
        });
        add(backButton);



        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseY, y - mouseY);
            }
        });
        add(menuBar);
    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics2D g) {
        g.drawImage(background, 0, 0, null);
        if(isMainScreen)
        {
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 340, 70, null);
        }
        if(isGameScreen)
        {
            game.screenDraw(g);
        }
        paintComponents(g);
        try {
            Thread.sleep(5);
        } catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();
    }

    public void selectTrack(int nowSelected) {
        if(selectedMusic != null)
            selectedMusic.close();
        titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft() {
        if(nowSelected == 0) //?????? ?????? 0?????????
            nowSelected = trackList.size() - 1; // ????????? ????????? ?????? ????????? ??? ??????
        else
            nowSelected--; // 0??? ????????? ?????? ?????????????????? ????????? -1
        selectTrack(nowSelected);
    }
    public void selectRight() {
        if(nowSelected == trackList.size() - 1) // ?????? ???????????? ?????? ?????? ?????? ????????? ????????????
            nowSelected = 0; // ??? ?????? ????????? ?????????
        else
            nowSelected++; // ?????? ???????????? ????????? +1
        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty) {
        if(selectedMusic != null) // ???????????? ????????? ????????? ????????????, ?????? ????????? ??????????????????
            selectedMusic.close(); // ?????? ???????????? ?????? ????????? ?????????
        isMainScreen =false; // ?????? ????????? ???????????? ?????? ????????? ?????????, ????????? ???????????? ???????????? ????????? ????????????
        leftButton.setVisible(false); // ?????? ????????? ????????? ????????? ?????? ???????????? ????????? ????????????
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
        // ??????????????? ???????????? ??? ?????? ?????? ???????????? ?????????, ?????? ???????????? ?????? ?????????
        backButton.setVisible(true);
        isGameScreen = true;
        game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void backMain() { // ?????? ????????? ???????????? ???
        isMainScreen = true; // ?????? ????????? ???????????? ????????? true
        leftButton.setVisible(true); // ?????? ????????? ?????? ?????? ?????????????????? ????????? ??????
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // ????????? ??????
        backButton.setVisible(false);
        selectTrack(nowSelected); // ?????? ????????? ??? ?????? ?????????
        isGameScreen = false;
        game.close();
    }

    public void enterMain() {
        startButton.setVisible(false);
        quitButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
        isMainScreen = true;
        leftButton.setVisible(true); // ?????? ????????? ?????? ?????? ?????????????????? ????????? ??????
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        introMusic.close();
        selectTrack(0);
    }
}