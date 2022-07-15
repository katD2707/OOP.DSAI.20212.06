package dsai.test.model;

import dsai.piano.model.component.Volume;

public class VolumeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Volume vol = new Volume();
		vol.decreaseVolume();
		System.out.println("Volume: " + vol.getValue());
		
		Volume vol2 = new Volume(60);
		vol2.increaseVolume();
		System.out.println("Volume: " + vol2.getValue());
		
		Volume vol3 = new Volume();
		vol3.setVolume(34);
		System.out.println("Volume: " + vol3.getValue());
		System.out.println("Volume: " + vol.getValue());
		
		vol = new Volume();
		System.out.println(vol.getCoarseVolume());
		System.out.println(vol.getFineVolume());
		vol.setVolume(20);
		System.out.println(vol.getCoarseVolume());
		System.out.println(vol.getFineVolume());
		vol.decreaseVolume();
		vol.decreaseVolume();
		vol.decreaseVolume();
		vol.decreaseVolume();
		System.out.println(vol.getValue());
		System.out.println(vol.getCoarseVolume());
		System.out.println(vol.getFineVolume());
		
		float f1 = (16383f / 128 / 100 * 90);
		System.out.println(f1);
		
		byte b1 = (byte) f1;
		System.out.println(b1);
	}

}
