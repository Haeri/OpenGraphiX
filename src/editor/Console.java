package editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


public class Console extends JPanel{

	private static final long serialVersionUID = 1L;

	public final String def_text;
	private int last = 0;
	private int repeat = 2;
	private Font font = new Font("Consolas", Font.PLAIN, 12);
	public JTextPane outPane, inPane;
	private JScrollPane conScroll;
	private Document doc;
	private String lastLog = "";
	private boolean first = true;
	private List<String> history;
	private int currentLog = 0;
	private JScrollBar vertical;
	private int hGap = 8;
	private int vGap = 4;
	
	private final static StyleContext cont = StyleContext.getDefaultStyleContext();
	public static AttributeSet userIn = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(49, 117, 175));
	public static AttributeSet stdOut = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(180, 180, 180));
	public static AttributeSet out = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(255, 255, 255));
	public static AttributeSet err = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(224, 47, 41));
	public static AttributeSet warn = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, new Color(240, 173, 78));
	
	
	public static final Color CONSOLE_OUT_BG = new Color(33, 33, 33);
	public static final Color CONSOLE_OUT_FG = new Color(160, 160, 160);
	public static final Color CONSOLE_IN_BG = new Color(36, 36, 36);
	public static final Color CONSOLE_IN_FG = Color.WHITE;
	
	final String mathHelp = "Legal Math Functions:\nNOT(expression)\tBoolean negation, 1 (means true) if the expression is not zero\nIF(condition,value_if_true,value_if_false)\tReturns one value if the condition evaluates to true or the other if it evaluates to false\nRANDOM()\t\tProduces a random number between 0 and 1\nMIN(e1,e2)\t\tReturns the smaller of both expressions\nMAX(e1,e2)\t\tReturns the bigger of both expressions\nABS(expression)\tReturns the absolute (non-negative) value of the expression\nROUND(expression,precision)\tRounds a value to a certain number of digits, uses the current rounding mode\nFLOOR(expression)\tRounds the value down to the nearest integer\nCEILING(expression)\tRounds the value up to the nearest integer\nLOG(expression)\tReturns the natural logarithm (base e) of an expression\nLOG10(expression)\tReturns the common logarithm (base 10) of an expression\nSQRT(expression)\tReturns the square root of an expression\nSIN(expression)\tReturns the trigonometric sine of an angle (in degrees)\nCOS(expression)\tReturns the trigonometric cosine of an angle (in degrees)\nTAN(expression)\tReturns the trigonometric tangens of an angle (in degrees)\nASIN(expression)\tReturns the angle of asin (in degrees)\nACOS(expression)\tReturns the angle of acos (in degrees)\nATAN(expression)\tReturns the angle of atan (in degrees)\nSINH(expression)\tReturns the hyperbolic sine of a value\nCOSH(expression)\tReturns the hyperbolic cosine of a value\nTANH(expression)\tReturns the hyperbolic tangens of a value\nRAD(expression)\tConverts an angle measured in degrees to an approximately equivalent angle measured in radians\nDEG(expression)\tConverts an angle measured in radians to an approximately equivalent angle measured in degrees";
	
	public Console(String title){
		super();
		def_text = title + "";
		history = new ArrayList<String>();
		history.add("");
		
		setLayout(new BorderLayout(0, 0));
		
		outPane = new JTextPane();
		outPane.setBorder(new EmptyBorder(vGap, hGap, vGap, hGap));
		outPane.setBackground(CONSOLE_OUT_BG);
		outPane.setForeground(CONSOLE_OUT_FG);
		outPane.setFont(font);
		outPane.setEditable(false);
		doc = outPane.getDocument();
		
		inPane = new JTextPane();
		inPane.setBorder(new EmptyBorder(vGap, hGap, vGap, hGap));
		inPane.setBackground(CONSOLE_IN_BG);
		inPane.setForeground(CONSOLE_IN_FG);
		inPane.setCaretColor(CONSOLE_IN_FG);
		inPane.setFont(font);
		
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(outPane, BorderLayout.NORTH);
		pane.add(inPane, BorderLayout.CENTER);
		
		conScroll = new JScrollPane(pane);
		conScroll.getVerticalScrollBar().setUnitIncrement(16);
		conScroll.setBorder(BorderFactory.createEmptyBorder());
		conScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(conScroll, BorderLayout.CENTER);		
		
		
		inPane.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
			    if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown()){
			    	inPane.setText(inPane.getText() + "\n");
			    }else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			    	e.consume();
			    	read(inPane.getText());
			    }else if(e.getKeyCode() == KeyEvent.VK_UP){
			    	getHistory();
			    }
		    }
		    @Override
		    public void keyTyped(KeyEvent e) {}

		    @Override
		    public void keyReleased(KeyEvent e) {}
		});
		
		println(def_text, Console.stdOut);
	}

	public void clear(){
		repeat = 2;
		lastLog = "";
		first = true;
		outPane.setText("");
		println(def_text, Console.stdOut);
	}
	
	public void printhr(){
		//println("<p style=\"margin-top: 10px;>");
		//outPane.setText(outPane.getText());
		//System.out.println(outPane.getText());
		//outPane.setContentType("text/plain");
	}
	
	public void println(String print){
		println(print, stdOut);
	}
	
	public void println(String print, AttributeSet attr){
		
		// Style print
		if(attr == Console.err){
			print = "ERROR: " + print; 
		}else if(attr == Console.warn){
			print = "WARNING: " + print;
		}
		
		System.out.println(print);
		
		String newLog = "";
		if (print.equals(lastLog)){
			try {
				doc.remove(last, doc.getLength()-last);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			newLog = "[" + repeat++ + "] " + print;
		}else{
			last = doc.getLength();
			newLog = print;
			repeat = 2;
		}
		lastLog = print;
	
		try {
			if(first){
				doc.insertString(last, newLog, attr);
				first = false;	
			}else
				doc.insertString(last, "\n" + newLog, attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		// Scroll Down
		down();

	}
		
	public void registerLog(String in){
		inPane.setText("");
		println(in, userIn);
		history.add(in);
		currentLog = history.size()-1;
	}
	
	public void read(String in){
		registerLog(in);
		
		in = in.toLowerCase();
		if (in.equals("clear")){
			clear();
		}else if(in.equals("hello") || in.equals("hy")){
			println(">Hy there!");
		}else if(in.equals("math_help")){
			println(mathHelp);
		}
	}
	
	public void down(){
		vertical = conScroll.getVerticalScrollBar();
		vertical.setValue( vertical.getMaximum());
	}
	
	private void getHistory(){
		if(currentLog == -1)
			currentLog = history.size()-1;
		inPane.setText(history.get(currentLog--));
	}
}
