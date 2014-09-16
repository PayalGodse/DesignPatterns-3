package test;

import static org.junit.Assert.assertEquals;

import java.awt.Font;
import java.util.ArrayList;

import org.junit.Test;

import flyweight.CharacterFactory;
import flyweight.CharacterFlyweight;
import flyweight.FontFactory;
import flyweight.RunArray;
import flyweight.SizeofUtil;

public class FlyweightTest {

	@Test
	public void test() {
		final RunArray context = new RunArray();
		int spaceUsed = 5632;
		assertEquals(new SizeofUtil() {
			@Override
			public void create() {
				CharacterFactory charInstance = CharacterFactory.instance();
				FontFactory fontInstance = FontFactory.instance();

				ArrayList<CharacterFlyweight> charList = new ArrayList<>();

				int value = 0;

				for (int each = 0; each < 326; each++) {
					if (value % 54 == 0)
						value = 0;
					else
						value++;
					CharacterFlyweight flyweight = charInstance.getCharacter((char) value);
					charList.add(flyweight);
				}
				
				/* Testing get Font method */
				Font firstFont = fontInstance.getFont("TimesRoman", 1, 5);
				context.addRun(0, 115, firstFont);

				Font secondFont = fontInstance.getFont("TimesRoman", 2, 7);
				context.appendRun(211, secondFont);
			
				assertEquals(context.getFont(116), secondFont);
				assertEquals(context.getFont(110), firstFont);
			}

		}.averageBytes(), spaceUsed, 1.0);

	}

}
