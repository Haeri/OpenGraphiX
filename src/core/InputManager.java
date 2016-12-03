package core;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class InputManager {

	public static boolean KEY_UP = false;
	public static boolean KEY_DOWN = false;
	public static boolean KEY_LEFT = false;
	public static boolean KEY_RIGHT = false;
    
    public InputManager() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (InputManager.class) {
                    switch (ke.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if(ke.getKeyCode() == KeyEvent.VK_UP) KEY_UP = true;  
                        if(ke.getKeyCode() == KeyEvent.VK_DOWN) KEY_DOWN =  true;
                        if(ke.getKeyCode() == KeyEvent.VK_LEFT) KEY_LEFT = true;
                        if(ke.getKeyCode() == KeyEvent.VK_RIGHT) KEY_RIGHT = true;
                    break;
                    case KeyEvent.KEY_RELEASED:
                        if(ke.getKeyCode() == KeyEvent.VK_UP) KEY_UP = false;  
                        if(ke.getKeyCode() == KeyEvent.VK_DOWN) KEY_DOWN =  false;
                        if(ke.getKeyCode() == KeyEvent.VK_LEFT) KEY_LEFT = false;
                        if(ke.getKeyCode() == KeyEvent.VK_RIGHT) KEY_RIGHT = false;
                   break;
                   }
                   return false;
                }
            }
        });
    }
}
