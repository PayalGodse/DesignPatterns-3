package test;

import static org.junit.Assert.assertEquals;

import java.awt.Font;
import java.util.ArrayList;
import flyweight.CharacterFlyweight;
import flyweight.SizeofUtil;

import org.junit.Test;

public class WithoutFlyweightTest {

	@Test
	public void test() {
		int spaceUsed = 37776;
		assertEquals(new SizeofUtil() {
			@Override
			public void create() {
				ArrayList<CharacterFlyweight> charList = new ArrayList<>();
				ArrayList<Font> fontlist = new ArrayList<>();
				Font font;
				int value = 0;
				for (int each = 0; each < 326; each++) {
					if (value % 54 == 0)
						value = 0;
					else
						value++;
					CharacterFlyweight aCharacter = new CharacterFlyweight(
							(char) value);
					charList.add(aCharacter);

					if (each < 116)
						font = new Font("Calibri", 1, 5);
					else
						font = new Font("Cambria", 2, 6);

					fontlist.add(font);
				}
			}

		}.averageBytes(), spaceUsed, 1.0);

	}

}
