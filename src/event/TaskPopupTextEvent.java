package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import gui.Assets;
import task.Task;
import ui.UIConfig;

/**
 * TaskPopupTextEvent
 */
public class TaskPopupTextEvent extends MouseAdapter implements Runnable {

 private JPopupMenu pop;
 private boolean in = false;

 private int x, y;

 private Task owner;

 public TaskPopupTextEvent(Task task) {

  pop = new JPopupMenu();
  if(task.getAmount() > 0 && task.getAmount() < 7)
   pop.add(task.getTitle() + " (" + task.getAmount() + ")");
  else
   pop.add(task.getTitle());
  pop.getComponent(0).setFont(Assets.notoFont_Task);
//  pop.getComponent(0).setEnabled(false);
  pop.setBorder(null);

  owner = task;

 }

 public void mouseEntered(MouseEvent e) {

  in = true;
  x = e.getXOnScreen() + 1;
  y = e.getYOnScreen();

  Thread thr = new Thread(this, "Task Title");
  thr.start();

 }

 public void mouseMoved(MouseEvent e) {

  x = e.getXOnScreen() + 1;
  y = e.getYOnScreen();

 }

 public void mouseExited(MouseEvent e) {

  in = false;
  pop.setVisible(false);

 }

 public void run() {

  try {
   Thread.sleep(800);
  } catch (Exception ex) {
   ex.printStackTrace();
  }

  if (in) {

   if (y == 0) {
    x = owner.getLocationOnScreen().x + owner.getWidth();
    y = owner.getLocationOnScreen().y + owner.getHeight() / 2;
   }

   pop.getComponent(0).setBackground(UIConfig.getThemeColor("comp-bg-click"));
   pop.getComponent(0).setForeground(UIConfig.getThemeColor("week-title"));
   pop.setLocation(x + 12, y);
   pop.setVisible(true);

  }

 }

}
