package Model.Level;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class reader {

	public int readScore() {
		int score = 0;

		try {
			FileReader fr = new FileReader("score.txt");

			BufferedReader br = new BufferedReader(fr);
			String str2;
			str2 = br.readLine();
			score = Integer.parseInt(str2);

		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return score;
	}
}
