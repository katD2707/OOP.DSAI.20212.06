package dsai.piano.model;

public class Volume {
	private int value = 50;
	private byte coarse_volume;
	private byte fine_volume;
	
	public Volume() {
		this.updateCoarseFineVolume();

	}
	
	public Volume(int volume) {
		this.value = volume;
		this.updateCoarseFineVolume();
	}

	public int getValue() {
		return this.value;
	}
	public byte getCoarseVolume() {
		return this.coarse_volume;
	}
	public byte getFineVolume() {
		return this.fine_volume;
	}

	
	public void setVolume(int vol) {
		this.value = vol;
		this.updateCoarseFineVolume();
	}
	
	public void increaseVolume() {
		if (this.getValue() >= 95) {
			this.setVolume(100);
		} else {
			this.setVolume(this.getValue() + 5);
		}

	}
	
	public void decreaseVolume() {
		if (this.getValue() <= 5) {
			this.setVolume(0);
		} else {
			this.setVolume(this.getValue() - 5);
		}
		this.updateCoarseFineVolume();
	}

	public void updateCoarseFineVolume() {
		this.coarse_volume = (byte) (16383f / 128 * this.getValue() / 100);
		this.fine_volume = (byte)(16383f % 128 * this.getValue() / 100);
	}
} 
