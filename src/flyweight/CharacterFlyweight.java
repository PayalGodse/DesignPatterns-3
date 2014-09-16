package flyweight;


public class CharacterFlyweight {
	
	private int unicode;

	public int getUnicode() {
		return unicode;
	}

	private void setUnicode(int unicode) {
		this.unicode = unicode;
	}

	public CharacterFlyweight(char aCharacter) {
		setUnicode((int) aCharacter);
	}
}
