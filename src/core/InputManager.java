package core;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class InputManager {

	public static boolean KEY_0 = false;
	public static boolean KEY_1 = false;
	public static boolean KEY_2 = false;
	public static boolean KEY_3 = false;
	public static boolean KEY_4 = false;
	public static boolean KEY_5 = false;
	public static boolean KEY_6 = false;
	public static boolean KEY_7 = false;
	public static boolean KEY_8 = false;
	public static boolean KEY_9 = false;
	public static boolean KEY_A = false;
	public static boolean KEY_ACCEPT = false;
	public static boolean KEY_ADD = false;
	public static boolean KEY_AGAIN = false;
	public static boolean KEY_ALL_CANDIDATES = false;
	public static boolean KEY_ALPHANUMERIC = false;
	public static boolean KEY_ALT = false;
	public static boolean KEY_ALT_GRAPH = false;
	public static boolean KEY_AMPERSAND = false;
	public static boolean KEY_ASTERISK = false;
	public static boolean KEY_AT = false;
	public static boolean KEY_B = false;
	public static boolean KEY_BACK_QUOTE = false;
	public static boolean KEY_BACK_SLASH = false;
	public static boolean KEY_BACK_SPACE = false;
	public static boolean KEY_BEGIN = false;
	public static boolean KEY_BRACELEFT = false;
	public static boolean KEY_BRACERIGHT = false;
	public static boolean KEY_C = false;
	public static boolean KEY_CANCEL = false;
	public static boolean KEY_CAPS_LOCK = false;
	public static boolean KEY_CIRCUMFLEX = false;
	public static boolean KEY_CLEAR = false;
	public static boolean KEY_CLOSE_BRACKET = false;
	public static boolean KEY_CODE_INPUT = false;
	public static boolean KEY_COLON = false;
	public static boolean KEY_COMMA = false;
	public static boolean KEY_COMPOSE = false;
	public static boolean KEY_CONTEXT_MENU = false;
	public static boolean KEY_CONTROL = false;
	public static boolean KEY_CONVERT = false;
	public static boolean KEY_COPY = false;
	public static boolean KEY_CUT = false;
	public static boolean KEY_D = false;
	public static boolean KEY_DEAD_ABOVEDOT = false;
	public static boolean KEY_DEAD_ABOVERING = false;
	public static boolean KEY_DEAD_ACUTE = false;
	public static boolean KEY_DEAD_BREVE = false;
	public static boolean KEY_DEAD_CARON = false;
	public static boolean KEY_DEAD_CEDILLA = false;
	public static boolean KEY_DEAD_CIRCUMFLEX = false;
	public static boolean KEY_DEAD_DIAERESIS = false;
	public static boolean KEY_DEAD_DOUBLEACUTE = false;
	public static boolean KEY_DEAD_GRAVE = false;
	public static boolean KEY_DEAD_IOTA = false;
	public static boolean KEY_DEAD_MACRON = false;
	public static boolean KEY_DEAD_OGONEK = false;
	public static boolean KEY_DEAD_SEMIVOICED_SOUND = false;
	public static boolean KEY_DEAD_TILDE = false;
	public static boolean KEY_DEAD_VOICED_SOUND = false;
	public static boolean KEY_DECIMAL = false;
	public static boolean KEY_DELETE = false;
	public static boolean KEY_DIVIDE = false;
	public static boolean KEY_DOLLAR = false;
	public static boolean KEY_DOWN = false;
	public static boolean KEY_E = false;
	public static boolean KEY_END = false;
	public static boolean KEY_ENTER = false;
	public static boolean KEY_EQUALS = false;
	public static boolean KEY_ESCAPE = false;
	public static boolean KEY_EURO_SIGN = false;
	public static boolean KEY_EXCLAMATION_MARK = false;
	public static boolean KEY_F = false;
	public static boolean KEY_F1 = false;
	public static boolean KEY_F10 = false;
	public static boolean KEY_F11 = false;
	public static boolean KEY_F12 = false;
	public static boolean KEY_F13 = false;
	public static boolean KEY_F14 = false;
	public static boolean KEY_F15 = false;
	public static boolean KEY_F16 = false;
	public static boolean KEY_F17 = false;
	public static boolean KEY_F18 = false;
	public static boolean KEY_F19 = false;
	public static boolean KEY_F2 = false;
	public static boolean KEY_F20 = false;
	public static boolean KEY_F21 = false;
	public static boolean KEY_F22 = false;
	public static boolean KEY_F23 = false;
	public static boolean KEY_F24 = false;
	public static boolean KEY_F3 = false;
	public static boolean KEY_F4 = false;
	public static boolean KEY_F5 = false;
	public static boolean KEY_F6 = false;
	public static boolean KEY_F7 = false;
	public static boolean KEY_F8 = false;
	public static boolean KEY_F9 = false;
	public static boolean KEY_FINAL = false;
	public static boolean KEY_FIND = false;
	public static boolean KEY_FULL_WIDTH = false;
	public static boolean KEY_G = false;
	public static boolean KEY_GREATER = false;
	public static boolean KEY_H = false;
	public static boolean KEY_HALF_WIDTH = false;
	public static boolean KEY_HELP = false;
	public static boolean KEY_HIRAGANA = false;
	public static boolean KEY_HOME = false;
	public static boolean KEY_I = false;
	public static boolean KEY_INPUT_METHOD_ON_OFF = false;
	public static boolean KEY_INSERT = false;
	public static boolean KEY_INVERTED_EXCLAMATION_MARK = false;
	public static boolean KEY_J = false;
	public static boolean KEY_JAPANESE_HIRAGANA = false;
	public static boolean KEY_JAPANESE_KATAKANA = false;
	public static boolean KEY_JAPANESE_ROMAN = false;
	public static boolean KEY_K = false;
	public static boolean KEY_KANA = false;
	public static boolean KEY_KANA_LOCK = false;
	public static boolean KEY_KANJI = false;
	public static boolean KEY_KATAKANA = false;
	public static boolean KEY_KP_DOWN = false;
	public static boolean KEY_KP_LEFT = false;
	public static boolean KEY_KP_RIGHT = false;
	public static boolean KEY_KP_UP = false;
	public static boolean KEY_L = false;
	public static boolean KEY_LEFT = false;
	public static boolean KEY_LEFT_PARENTHESIS = false;
	public static boolean KEY_LESS = false;
	public static boolean KEY_M = false;
	public static boolean KEY_META = false;
	public static boolean KEY_MINUS = false;
	public static boolean KEY_MODECHANGE = false;
	public static boolean KEY_MULTIPLY = false;
	public static boolean KEY_N = false;
	public static boolean KEY_NONCONVERT = false;
	public static boolean KEY_NUM_LOCK = false;
	public static boolean KEY_NUMBER_SIGN = false;
	public static boolean KEY_NUMPAD0 = false;
	public static boolean KEY_NUMPAD1 = false;
	public static boolean KEY_NUMPAD2 = false;
	public static boolean KEY_NUMPAD3 = false;
	public static boolean KEY_NUMPAD4 = false;
	public static boolean KEY_NUMPAD5 = false;
	public static boolean KEY_NUMPAD6 = false;
	public static boolean KEY_NUMPAD7 = false;
	public static boolean KEY_NUMPAD8 = false;
	public static boolean KEY_NUMPAD9 = false;
	public static boolean KEY_O = false;
	public static boolean KEY_OPEN_BRACKET = false;
	public static boolean KEY_P = false;
	public static boolean KEY_PAGE_DOWN = false;
	public static boolean KEY_PAGE_UP = false;
	public static boolean KEY_PASTE = false;
	public static boolean KEY_PAUSE = false;
	public static boolean KEY_PERIOD = false;
	public static boolean KEY_PLUS = false;
	public static boolean KEY_PREVIOUS_CANDIDATE = false;
	public static boolean KEY_PRINTSCREEN = false;
	public static boolean KEY_PROPS = false;
	public static boolean KEY_Q = false;
	public static boolean KEY_QUOTE = false;
	public static boolean KEY_QUOTEDBL = false;
	public static boolean KEY_R = false;
	public static boolean KEY_RIGHT = false;
	public static boolean KEY_RIGHT_PARENTHESIS = false;
	public static boolean KEY_ROMAN_CHARACTERS = false;
	public static boolean KEY_S = false;
	public static boolean KEY_SCROLL_LOCK = false;
	public static boolean KEY_SEMICOLON = false;
	public static boolean KEY_SEPARATER = false;
	public static boolean KEY_SEPARATOR = false;
	public static boolean KEY_SHIFT = false;
	public static boolean KEY_SLASH = false;
	public static boolean KEY_SPACE = false;
	public static boolean KEY_STOP = false;
	public static boolean KEY_SUBTRACT = false;
	public static boolean KEY_T = false;
	public static boolean KEY_TAB = false;
	public static boolean KEY_U = false;
	public static boolean KEY_UNDEFINED = false;
	public static boolean KEY_UNDERSCORE = false;
	public static boolean KEY_UNDO = false;
	public static boolean KEY_UP = false;
	public static boolean KEY_V = false;
	public static boolean KEY_W = false;
	public static boolean KEY_WINDOWS = false;
	public static boolean KEY_X = false;
	public static boolean KEY_Y = false;
	public static boolean KEY_Z = false;

	public InputManager() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent ke) {
				synchronized (InputManager.class) {
					switch (ke.getID()) {
					case KeyEvent.KEY_PRESSED:
						if (ke.getKeyCode() == KeyEvent.VK_UP)
							KEY_UP = true;
						if (ke.getKeyCode() == KeyEvent.VK_DOWN)
							KEY_DOWN = true;
						if (ke.getKeyCode() == KeyEvent.VK_LEFT)
							KEY_LEFT = true;
						if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
							KEY_RIGHT = true;
						break;
					case KeyEvent.KEY_RELEASED:
						if (ke.getKeyCode() == KeyEvent.VK_UP)
							KEY_UP = false;
						if (ke.getKeyCode() == KeyEvent.VK_DOWN)
							KEY_DOWN = false;
						if (ke.getKeyCode() == KeyEvent.VK_LEFT)
							KEY_LEFT = false;
						if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
							KEY_RIGHT = false;
						break;
					}
					return false;
				}
			}
		});
	}
}
