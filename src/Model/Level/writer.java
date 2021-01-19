package Model.Level;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class writer {
	public void writeScore(int score) {
		try {
			FileWriter fw = new FileWriter("score.txt");
			PrintWriter pw = new PrintWriter(fw);

			pw.printf("%d", score);
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
