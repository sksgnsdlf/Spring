package polymorphism;

public class LgTV implements TV{

	/* (non-Javadoc)
	 * @see polymorphism.TV#powerOn()
	 */
	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	/* (non-Javadoc)
	 * @see polymorphism.TV#powerOff()
	 */
	@Override
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	/* (non-Javadoc)
	 * @see polymorphism.TV#volumeUp()
	 */
	@Override
	public void volumeUp() {
		System.out.println("LgTV soundUp");
	}
	/* (non-Javadoc)
	 * @see polymorphism.TV#volumeDown()
	 */
	@Override
	public void volumeDown() {
		System.out.println("LgTV soundDown");
	}	
}
