package flyweight;

import java.util.HashMap;

/* Single point of access for the character flyweight */
public class CharacterFactory {

	private HashMap<Character, CharacterFlyweight> charValues;

	private static CharacterFactory instance = null;

	private CharacterFactory() {
		charValues = new HashMap<Character, CharacterFlyweight>();
	}

	public static CharacterFactory instance() {
		if (instance == null)
			instance = new CharacterFactory();
		return instance;
	}

	public CharacterFlyweight getCharacter(char aCharacter) {
		if (charValues.containsKey(aCharacter))
			return charValues.get(aCharacter);
		else {
			CharacterFlyweight flyweight = new CharacterFlyweight(aCharacter);
			charValues.put(aCharacter, flyweight);
			return flyweight;

		}

	}
}
