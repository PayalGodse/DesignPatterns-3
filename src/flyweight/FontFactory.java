package flyweight;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

/* Single point of access for the font flyweight */
public class FontFactory {

	private ArrayList<Font> fontValues;
	private static FontFactory instance = null;

	private FontFactory() {
		fontValues = new ArrayList<Font>();
	}

	public static FontFactory instance() {
		if (instance == null)
			instance = new FontFactory();
		return instance;
	}

	public Font getFont(String fontName, int style, int size) {
		Iterator<Font> valueIterator = fontValues.iterator();
		while (valueIterator.hasNext()) {
			Font font = valueIterator.next();
			if (font.getFontName().equals(fontName) && (font.getSize() == size)
					&& (font.getStyle() == style))
				return font;
		}
		Font flyweight = new Font(fontName, style, size);
		fontValues.add(flyweight);
		return flyweight;
	}
}
