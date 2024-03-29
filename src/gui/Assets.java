package gui;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

/**
 * Assets
 */
public class Assets {

 public static BufferedImage ui_close;
 public static BufferedImage ui_min;
 public static BufferedImage gmail;
 public static BufferedImage wsp;
 public static BufferedImage repeat;

 public static Font notoFont;
 public static Font oswaldFont;
 public static Font oswaldFont_Underlined;
 public static Font notoFont_Task;
 public static Font notoFont_Bold;

 public static ImageIcon app_icon;
 public static ImageIcon app_icon16;

 public static void init() {

  ui_close = Loader.loadPng("/gui/cerrar.png");
  ui_min = Loader.loadPng("/gui/min.png");
  gmail = Loader.loadPng("/gui/gmail16.png");
  wsp = Loader.loadPng("/gui/whatsapp.png");
  repeat = Loader.loadPng("/gui/repeat.png");

  notoFont = Loader.loadFont("/fonts/NotoSans-Regular.ttf", Font.PLAIN, 13);
  oswaldFont = Loader.loadFont("/fonts/Oswald-Regular.ttf", Font.PLAIN, 22);
  notoFont_Task = Loader.loadFont("/fonts/NotoSans-Regular.ttf", Font.BOLD, 12);
  
  Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
  fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
  oswaldFont_Underlined = oswaldFont.deriveFont(fontAttributes);
  notoFont_Bold = notoFont.deriveFont(Font.BOLD, 13);
  
  app_icon = Loader.loadIcon("/gui/icon/icon.png");
  app_icon16 = Loader.loadIcon("/gui/icon/icon16.png");

 }

}
