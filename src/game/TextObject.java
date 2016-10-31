package game;

import java.awt.Color;

import core.GraphiXObject;
import core.Text;
import renderer.TextRenderer;

public class TextObject extends GraphiXObject{

	public Text text;
	public Color color;
	
	public TextObject(String text, Color color){
		this(new Text(text), color);
	}
	
	public TextObject(Text text, Color color){
		super();		
		
		this.text = text;
		this.color = color;
		
		addComponent(new TextRenderer(text, color, this, 1));
	}
}
