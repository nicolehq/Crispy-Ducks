
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.*;
public class Sound{

  public static void playSound(String label) {
    File soundfile;
    if (label.equals("finalwin")){
      soundfile = new File("glorious.wav");
    } else if (label.equals("nohair")){
      soundfile = new File("nohair.wav");
    } else if (label.equals("notpass")){
      soundfile = new File("notpass.wav");
    } else if (label.equals("winmoney")){
      soundfile = new File("winmoney.wav");
    } else {
      soundfile = new File("morning.wav");
    }


      try {
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundfile.getAbsoluteFile());
          Clip clip = AudioSystem.getClip();
          clip.open(audioInputStream);
          clip.loop(0);
      } catch(Exception ex) {
          System.out.println("Error with playing sound.");
          ex.printStackTrace();
      }
  	}

}
