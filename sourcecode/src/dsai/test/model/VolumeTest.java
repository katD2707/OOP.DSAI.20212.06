package dsai.test.model;

import dsai.piano.model.Volume;

public class VolumeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Volume vol = new Volume();
		vol.decreaseVolume();
		System.out.println("Volume: " + vol.getVolume());
		
		Volume vol2 = new Volume(60);
		vol2.increaseVolume();
		System.out.println("Volume: " + vol2.getVolume());
		
		Volume vol3 = new Volume();
		vol3.setVolume(34);
		System.out.println("Volume: " + vol3.getVolume());
		System.out.println("Volume: " + vol.getVolume());
		
		vol = new Volume();
		System.out.println(vol.getCoarseVolume());
		System.out.println(vol.getFineVolume());
		vol.setVolume(90);
		System.out.println(vol.getCoarseVolume());
		System.out.println(vol.getFineVolume());

//		vol.increaseVolume();
//		System.out.println(vol.getCoarseVolume());
//		System.out.println(vol.getFineVolume());
		
		float f1 = (16383f / 128 / 100 * 90);
		System.out.println(f1);
		
		byte b1 = (byte) f1;
		System.out.println(b1);
//		System.out.println((new Float(90 / 100 * 16383 / 128)).byteValue());
	}

}
