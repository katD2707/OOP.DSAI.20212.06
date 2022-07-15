package dsai.test.screen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testReadFileInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String>();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/piano/editable/help.txt"));

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String item: lines) {
			System.out.println(item);
		}
		System.out.println(lines.size());
	}

}
