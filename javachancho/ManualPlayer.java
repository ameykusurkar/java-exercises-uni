import java.util.Scanner;

/**
 * The ManualPlayer class models a Chancho card game player sitting at a
 * computer terminal. The card selection strategy is determined by the manual
 * player, who simply inputs their choice into the computer via the keyboard.
 */
public final class ManualPlayer extends AbstractPlayer {

	private final Scanner scanner;

	ManualPlayer(CardPile in, CardPile out, String name) {
		super(out, in, name);
		scanner = new Scanner(System.in);
	}

	@Override
	protected int selectCard() {
		System.out.println("These are your cards:");
		System.out.println(super.toString());
		System.out.println("Please input card number to discard: (0 to "
				+ (HANDSIZE - 1) + ")");
		int cardIndex = scanner.nextInt();
		while (cardIndex < 0 || cardIndex >= HANDSIZE) {
			System.out
					.println("Invalid card index. Please enter number between 0 and "
							+ (HANDSIZE - 1));
			cardIndex = scanner.nextInt();
		}
		return cardIndex;
	}

}