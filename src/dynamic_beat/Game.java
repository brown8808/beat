package dynamic_beat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// 프로그램 안의 작은 프로그램
public class Game extends Thread{

    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../image/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../image/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../image/gameInfo.png")).getImage();
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();

    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
    private Image blueFlareImage;
    private Image judgeImage;
    private Image keyPadSImage = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadDImage = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadFImage = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadJImage = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadKImage = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();
    private Image keyPadLImage = new ImageIcon(Main.class.getResource("../image/keyPadBasic.png")).getImage();



    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<Note>();


    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);

    }


    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 437, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);
        for (int i = 0; i < noteList.size(); i++)
        {
            Note note = noteList.get(i);
            if (note.getY() > 620) {
                judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
            }
            if (!note.isProceeded()) {
                noteList.remove(i);
                i--;
            }
            else {
                note.screenDraw(g);
            }
        }
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("Space Bar", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 997, 609);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 702);
        g.drawImage(blueFlareImage, 490, 300, null);
        g.drawImage(judgeImage, 460, 420, null);
        g.drawImage(keyPadSImage, 228, 580, null);
        g.drawImage(keyPadDImage, 332, 580, null);
        g.drawImage(keyPadFImage, 436, 580, null);
        g.drawImage(keyPadSpace1Image, 540, 580, null);
        g.drawImage(keyPadSpace2Image, 640, 580, null);
        g.drawImage(keyPadJImage, 744, 580, null);
        g.drawImage(keyPadKImage, 848, 580, null);
        g.drawImage(keyPadLImage, 952, 580, null);

    }

    public void pressS() {
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }
    public void pressD() {
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();
    }
    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

    }
    public void pressF() {
        judge("F");
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumSmall3.mp3", false).start();
    }
    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }
    public void pressSpace() {
        judge("Space");
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }
    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }
    public void pressJ() {
        judge("J");
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
    }
    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }
    public void pressK() {
        judge("K");
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumBig3.mp3", false).start();
    }
    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }
    public void pressL() {
        judge("L");
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("drumBig3.mp3", false).start();
    }
    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    @Override
    public void run() {
        dropNotes(this.titleName);
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName) {
        Beat[] beats = null;
        if (titleName.equals("music1")) {
            int startTime = 4460 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime, "S"),
                    new Beat(startTime + gap * 2, "S"),
                    new Beat(startTime + gap * 4, "D"),
                    new Beat(startTime + gap * 6, "S"),
                    new Beat(startTime + gap * 8, "D"),
                    new Beat(startTime + gap * 10, "S"),
                    new Beat(startTime + gap * 11, "D"),
                    new Beat(startTime + gap * 12, "S"),
                    new Beat(startTime + gap * 13, "D"),
                    new Beat(startTime + gap * 15, "Space"),
                    new Beat(startTime + gap * 16, "Space"),
                    new Beat(startTime + gap * 18, "Space"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "K"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 25, "L"),
                    new Beat(startTime + gap * 26, "L"),
                    new Beat(startTime + gap * 28, "J"),
                    new Beat(startTime + gap * 30, "L"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "S"),
                    new Beat(startTime + gap * 38, "F"),
                    new Beat(startTime + gap * 40, "S"),
                    new Beat(startTime + gap * 42, "F"),
                    new Beat(startTime + gap * 44, "S"),
                    new Beat(startTime + gap * 46, "D"),
                    new Beat(startTime + gap * 48, "K"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 51, "L"),
                    new Beat(startTime + gap * 52, "D"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "Space"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "S"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 63, "D"),
                    new Beat(startTime + gap * 64, "D"),
                    new Beat(startTime + gap * 65, "S"),
                    new Beat(startTime + gap * 66, "S"),
                    new Beat(startTime + gap * 67, "S"),
                    new Beat(startTime + gap * 68, "S"),
                    new Beat(startTime + gap * 70, "S"),
                    new Beat(startTime + gap * 72, "F"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "F"),
                    new Beat(startTime + gap * 78, "F"),
                    new Beat(startTime + gap * 80, "S"),
            };
        } else if (titleName.equals("music2")) {
            int startTime = 4460 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime, "S"),
                    new Beat(startTime + gap * 2, "S"),
                    new Beat(startTime + gap * 4, "D"),
                    new Beat(startTime + gap * 6, "S"),
                    new Beat(startTime + gap * 8, "D"),
                    new Beat(startTime + gap * 10, "S"),
                    new Beat(startTime + gap * 11, "D"),
                    new Beat(startTime + gap * 12, "S"),
                    new Beat(startTime + gap * 13, "D"),
                    new Beat(startTime + gap * 15, "Space"),
                    new Beat(startTime + gap * 16, "Space"),
                    new Beat(startTime + gap * 18, "Space"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "K"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 25, "L"),
                    new Beat(startTime + gap * 26, "L"),
                    new Beat(startTime + gap * 28, "J"),
                    new Beat(startTime + gap * 30, "L"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "S"),
                    new Beat(startTime + gap * 38, "F"),
                    new Beat(startTime + gap * 40, "S"),
                    new Beat(startTime + gap * 42, "F"),
                    new Beat(startTime + gap * 44, "S"),
                    new Beat(startTime + gap * 46, "D"),
                    new Beat(startTime + gap * 48, "K"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 51, "L"),
                    new Beat(startTime + gap * 52, "D"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "Space"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "S"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 63, "D"),
                    new Beat(startTime + gap * 64, "D"),
                    new Beat(startTime + gap * 65, "S"),
                    new Beat(startTime + gap * 66, "S"),
                    new Beat(startTime + gap * 67, "S"),
                    new Beat(startTime + gap * 68, "S"),
                    new Beat(startTime + gap * 70, "S"),
                    new Beat(startTime + gap * 72, "F"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "F"),
                    new Beat(startTime + gap * 78, "F"),
                    new Beat(startTime + gap * 80, "S"),
            };
        } else if (titleName.equals("music3")) {
            int startTime = 4460 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime, "S"),
                    new Beat(startTime + gap * 2, "S"),
                    new Beat(startTime + gap * 4, "D"),
                    new Beat(startTime + gap * 6, "S"),
                    new Beat(startTime + gap * 8, "D"),
                    new Beat(startTime + gap * 10, "S"),
                    new Beat(startTime + gap * 11, "D"),
                    new Beat(startTime + gap * 12, "S"),
                    new Beat(startTime + gap * 13, "D"),
                    new Beat(startTime + gap * 15, "Space"),
                    new Beat(startTime + gap * 16, "Space"),
                    new Beat(startTime + gap * 18, "Space"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "K"),
                    new Beat(startTime + gap * 23, "J"),
                    new Beat(startTime + gap * 24, "K"),
                    new Beat(startTime + gap * 25, "L"),
                    new Beat(startTime + gap * 26, "L"),
                    new Beat(startTime + gap * 28, "J"),
                    new Beat(startTime + gap * 30, "L"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "S"),
                    new Beat(startTime + gap * 38, "F"),
                    new Beat(startTime + gap * 40, "S"),
                    new Beat(startTime + gap * 42, "F"),
                    new Beat(startTime + gap * 44, "S"),
                    new Beat(startTime + gap * 46, "D"),
                    new Beat(startTime + gap * 48, "K"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 51, "L"),
                    new Beat(startTime + gap * 52, "D"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "Space"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "S"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 63, "D"),
                    new Beat(startTime + gap * 64, "D"),
                    new Beat(startTime + gap * 65, "S"),
                    new Beat(startTime + gap * 66, "S"),
                    new Beat(startTime + gap * 67, "S"),
                    new Beat(startTime + gap * 68, "S"),
                    new Beat(startTime + gap * 70, "S"),
                    new Beat(startTime + gap * 72, "F"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "F"),
                    new Beat(startTime + gap * 78, "F"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 80, "D"),
                    new Beat(startTime + gap * 80, "F"),
                    new Beat(startTime + gap * 80, "Space"),
                    new Beat(startTime + gap * 80, "L"),
                    new Beat(startTime + gap * 85, "L"),
                    new Beat(startTime + gap * 86, "L"),
            };
        }
        int i = 0;
        gameMusic.start();
        while (i < beats.length && !isInterrupted()) {
            boolean dropped = false;
            if (beats[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if (!dropped) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void judge(String input) {
        for (int i = 0; i <noteList.size(); i++) {
            Note note = noteList.get(i);
            if (input.equals(note.getNoteType())) {
                judgeEvent(note.judge());
                break;
            }
        }
    }
    public void judgeEvent(String judge) {
        if (!judge.equals("None")) {
            blueFlareImage = new ImageIcon(Main.class.getResource("../imgaes/blueFlare.png")).getImage();
        }
        else if (judge.equals("Miss")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
        }
        else if (judge.equals("Late")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
        }
        else if (judge.equals("Good")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
        }
        else if (judge.equals("Great")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
        }
        else if (judge.equals("Perfect")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
        }
        else if (judge.equals("Early")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
        }
        else if (judge.equals("Miss")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
        }
    }
}
