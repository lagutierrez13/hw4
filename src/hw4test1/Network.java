package hw4test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Network {
	private double price;

	public Network() {

	}

	public double getPrice(String url) {
		Pattern patt;

		try {
			if (url.substring(12, 21).equals("homedepot")) {
				patt = Pattern.compile("content=\"\\d+[\\.]\\d+\\d");
				price = readSite(url, patt);
				return price;
			}

			else if (url.substring(12, 16).equals("ebay")) {
				patt = Pattern.compile("content=\"\\d+[\\.]\\d+\\d");
				price = readSite(url, patt);
				return price;
			}

			else if (url.substring(12, 19).equals("walmart")) {
				patt = Pattern.compile("content=\"\\d+[\\.]\\d+\\d");
				price = readSite(url, patt);
				return price;
			}

		} catch (Exception e) {

		}
		return price;
	}

	public double readSite(String store, Pattern patt) throws Exception {
		URL url = new URL(store);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		while ((line = in.readLine()) != null) {
			Matcher matcher = patt.matcher(line);
			if (matcher.find()) {
				price = Double.parseDouble((line.substring(matcher.start(0), matcher.end(0))).substring(9));
				return price;
			}
		}
		in.close();
		return price;
	}

}
