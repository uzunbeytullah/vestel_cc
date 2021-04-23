package mail_analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import file_operation.file_operation;

public class Pf_data_analiz {

	parseHex parseHex = new parseHex();
	static String protection_log_str = "";
	static file_operation fos = new file_operation();


	public Pf_data_analiz(String protection_data) {
		// TODO Auto-generated constructor stub
		String data = "";

		try {
			
			final File myObj = new File(protection_data);

			Scanner myReader = new Scanner(myObj);
			System.out.println("scanner");

			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				System.out.println("DATA:" +data);
				try {
					parseHex(data);
				} catch (Exception e) {
					System.out.println(e);
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	static String veri_format2 = "";
	static int counter_max = 0;

	private static void parseHex(String string) {
		System.out.println(string);

		String PF_data_val = "";

		if (string.startsWith("Permanent fail: index:1")) {
			PF_data_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protection_data_analiz(PF_data_val);
		}
	}

	private static String protection_data_analiz(String protection_data) {
		String sec = "";
		String min = "";
		String hour = "";
		String day = "";
		String month = "";
		String year = "";
		String pFlag_L = "";
		String pFlag_H = "";
		String PF_L = "";
		String PF_H = "";
		String cell1_volt = "";
		String cell2_volt = "";
		String cell3_volt = "";
		String cell4_volt = "";
		String cell5_volt = "";
		String cell6_volt = "";
		String cell7_volt = "";
		String cell8_volt = "";
		String cell9_volt = "";
		String cell10_volt = "";
		String max_TMP = "";
		String min_TMP = "";
		String fet_TMP = "";
		String rt_current = "";
		String rem_capacity = "";

		protection_data = protection_data.substring(protection_data.lastIndexOf(":") + 1);
		year = protection_data.substring(0, 2);
		month = protection_data.substring(2, 4);
		day = protection_data.substring(4, 6);
		hour = protection_data.substring(6, 8);
		min = protection_data.substring(8, 10);
		sec = protection_data.substring(10, 12);

		PF_L = protection_data.substring(12, 14);
		PF_H = protection_data.substring(14, 16);
		PF_L = hextobin(PF_L);
		PF_H = hextobin(PF_H);

		pFlag_L = protection_data.substring(16, 18);
		pFlag_H = protection_data.substring(18, 20);

		pFlag_L = hextobin(pFlag_L);
		pFlag_H = hextobin(pFlag_H);

		cell1_volt = protection_data.substring(22, 24);
		cell1_volt = cell1_volt + protection_data.substring(20, 22);

		cell2_volt = protection_data.substring(26, 28);
		cell2_volt = cell2_volt + protection_data.substring(24, 26);

		cell3_volt = protection_data.substring(30, 32);
		cell3_volt = cell3_volt + protection_data.substring(28, 30);

		cell4_volt = protection_data.substring(34, 36);
		cell4_volt = cell4_volt + protection_data.substring(32, 34);

		cell5_volt = protection_data.substring(38, 40);
		cell5_volt = cell5_volt + protection_data.substring(36, 38);

		cell6_volt = protection_data.substring(42, 44);
		cell6_volt = cell6_volt + protection_data.substring(40, 42);

		cell7_volt = protection_data.substring(46, 48);
		cell7_volt = cell7_volt + protection_data.substring(44, 46);

		cell8_volt = protection_data.substring(50, 52);
		cell8_volt = cell8_volt + protection_data.substring(48, 50);

		cell9_volt = protection_data.substring(54, 56);
		cell9_volt = cell9_volt + protection_data.substring(52, 54);

		cell10_volt = protection_data.substring(58, 60);
		cell10_volt = cell10_volt + protection_data.substring(56, 58);

		max_TMP = protection_data.substring(62, 64);
		max_TMP = max_TMP + protection_data.substring(60, 62);

		min_TMP = protection_data.substring(66, 68);
		min_TMP = min_TMP + protection_data.substring(64, 66);

		fet_TMP = protection_data.substring(70, 72);
		fet_TMP = fet_TMP + protection_data.substring(68, 70);

		rt_current = protection_data.substring(78, 80);
		rt_current = rt_current + protection_data.substring(76, 78);
		rt_current = rt_current + protection_data.substring(74, 76);
		rt_current = rt_current + protection_data.substring(72, 74);

		rem_capacity = protection_data.substring(82, 84);
		rem_capacity = rem_capacity + protection_data.substring(80, 82);

		// int transition

		int year_ = Integer.parseInt(year, 16);
		year_ = year_ + 1900;
		int month_ = Integer.parseInt(month, 16);
		month_ = month_ + 1;
		int day_ = Integer.parseInt(day, 16);
		int hour_ = Integer.parseInt(hour, 16);
		int min_ = Integer.parseInt(min, 16);
		int sec_ = Integer.parseInt(sec, 16);

		int cell1_volt_ = Integer.parseInt(cell1_volt, 16);
		int cell2_volt_ = Integer.parseInt(cell2_volt, 16);
		int cell3_volt_ = Integer.parseInt(cell3_volt, 16);
		int cell4_volt_ = Integer.parseInt(cell4_volt, 16);
		int cell5_volt_ = Integer.parseInt(cell5_volt, 16);
		int cell6_volt_ = Integer.parseInt(cell6_volt, 16);
		int cell7_volt_ = Integer.parseInt(cell7_volt, 16);
		int cell8_volt_ = Integer.parseInt(cell8_volt, 16);
		int cell9_volt_ = Integer.parseInt(cell9_volt, 16);
		int cell10_volt_ = Integer.parseInt(cell10_volt, 16);

	
		int max_TMP_ = Integer.parseInt(max_TMP, 16);

		if (max_TMP_ > 32767) {
			max_TMP_ = max_TMP_ - 65535;
		}

		int min_TMP_ = Integer.parseInt(min_TMP, 16);

		if (min_TMP_ > 32767) {
			min_TMP_ = min_TMP_ - 65535;
		}

		int fet_TMP_ = Integer.parseInt(fet_TMP, 16);
		if (fet_TMP_ > 32767) {
			fet_TMP_ = fet_TMP_ - 65535;
		}

		int rt_current_ = Integer.parseInt(rt_current, 16);
		if (rt_current_ > 32767) {
			rt_current_ = rt_current_ - 65535;
		}
		int rem_capacity_ = Integer.parseInt(rem_capacity, 16);

		String ret_string = year_ + "/" + month_ + "/" + day_ + " " + hour_ + ":" + min_ + ":" + sec_ + "," + PF_L + ","
				+ PF_H + "," + pFlag_L + "," + pFlag_H + "," + cell1_volt_ + "," + cell2_volt_ + "," + cell3_volt_ + ","
				+ cell4_volt_ + "," + cell5_volt_ + "," + cell6_volt_ + "," + cell7_volt_ + "," + cell8_volt_ + ","
				+ cell9_volt_ + "," + cell10_volt_ + "," + max_TMP_ + "," + min_TMP_ + "," + fet_TMP_ + ","
				+ rt_current_ + "," + rem_capacity_;
		fos.DosyaYazma("pf_log.txt", ret_string + "\n");

		return ret_string;
	}

	private static String hextobin(String string) {
		// TODO Auto-generated method stub
		int num = (Integer.parseInt(string, 16));

		return Integer.toBinaryString(num);

	}
}
