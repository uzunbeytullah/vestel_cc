package mail_analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import file_operation.file_operation;

public class mail_analyse {
	static int mode_number = 38;
	static int mode_number_tmp = 0;

	static parseHex parse_hex = new parseHex();
	file_operation fos = new file_operation();

	public mail_analyse(String filename_val) {
		fos.DosyaSil("mail_body.txt");
		fos.DosyaSil("protection_log.txt");
		fos.DosyaSil("pure_protect_log.txt");
		fos.DosyaSil("pf_log.txt");

		String data = "";

		try {
			fos.DosyaSil("mail_body.txt"); // socAndpackvolt.txt idi
			final String fileName = filename_val;
			final File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				try {
					parseHex.parseHex(data);
				} catch (Exception e) {
					System.out.println(e + "parseHex methodunda hata alýndý");
				}
			}
			if (!myReader.hasNextLine()) {
				parseHex.parseHex("EOF");
			}

			myReader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
}
