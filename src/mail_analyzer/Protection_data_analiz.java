package mail_analyzer;

import file_operation.file_operation;

public class Protection_data_analiz {

	parseHex parseHex = new parseHex();
	static String protection_log_str = "";
	static file_operation fos = new file_operation();


	public String protect_data_analiz(String protection_data) {
		//call protection formatter
		// TODO Auto-generated constructor stub
		String sec = "";
		String min = "";
		String hour = "";
		String day = "";
		String month = "";
		String year = "";
		String pFlag_L = "";
		String pFlag_H = "";
		String max_CV = "";
		String min_CV = "";
		String max_TMP = "";
		String min_TMP = "";
		String fet_TMP = "";
		String rt_current = "";
		String v41 = "";
		String t45 = "";
		String safety_stat1;
		String safety_stat2;
		String safety_stat3;
		String safety_stat4;

		protection_data = protection_data.substring(protection_data.lastIndexOf(":") + 1);
		year = protection_data.substring(0, 2);
		month = protection_data.substring(2, 4);
		day = protection_data.substring(4, 6);
		hour = protection_data.substring(6, 8);
		min = protection_data.substring(8, 10);
		sec = protection_data.substring(10, 12);

		pFlag_L = protection_data.substring(12, 14);
		pFlag_H = protection_data.substring(14, 16);

		max_CV = protection_data.substring(18, 20);
		max_CV = max_CV + protection_data.substring(16, 18);

		min_CV = protection_data.substring(22, 24);
		min_CV = min_CV + protection_data.substring(20, 22);

		max_TMP = protection_data.substring(26, 28);
		max_TMP = max_TMP + protection_data.substring(24, 26);

		min_TMP = protection_data.substring(30, 32);
		min_TMP = min_TMP + protection_data.substring(28, 30);

		fet_TMP = protection_data.substring(34, 36);
		fet_TMP = fet_TMP + protection_data.substring(32, 34);

		rt_current = protection_data.substring(42, 44);
		rt_current = rt_current + protection_data.substring(40, 42);
		rt_current = rt_current + protection_data.substring(38, 40);
		rt_current = rt_current + protection_data.substring(36, 38);

		safety_stat1 = protection_data.substring(44, 46);
		safety_stat1 = hextobin(safety_stat1);

		safety_stat2 = protection_data.substring(46, 48);
		safety_stat2 = hextobin(safety_stat2);
		safety_stat3 = protection_data.substring(48, 50);
		safety_stat3 = hextobin(safety_stat3);
		safety_stat4 = protection_data.substring(50, 52);
		safety_stat4 = hextobin(safety_stat4);

		v41 = protection_data.substring(54, 56);
		v41 = v41 + protection_data.substring(52, 54);

		t45 = protection_data.substring(58, 60); // BUG
		t45 = t45 + protection_data.substring(56, 58);

		// int transition

		int year_ = Integer.parseInt(year, 16);
		year_ = year_ + 1900;
		int month_ = Integer.parseInt(month, 16);
		month_ = month_ + 1;
		int day_ = Integer.parseInt(day, 16);
		int hour_ = Integer.parseInt(hour, 16);
		int min_ = Integer.parseInt(min, 16);
		int sec_ = Integer.parseInt(sec, 16);
		int pFlag_L_ = Integer.parseInt(pFlag_L, 16);
		int pFlag_H_ = Integer.parseInt(pFlag_H, 16);
		int max_CV_ = Integer.parseInt(max_CV, 16);
		int min_CV_ = Integer.parseInt(min_CV, 16);
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
		int v41_ = Integer.parseInt(v41, 16);
		int t45_ = Integer.parseInt(t45, 16);

		String protection_log_str = "PROTECTION DATE : " + year_ + "/" + month_ + "/" + day_ + " " + hour_ + ":" + min_ + ":"
				+ sec_ + "," + "HATA KODU :" + pFlag_L_ + "," + pFlag_H_ + "," + "MAX CELL VOLTAGE : " + max_CV_ + ","
				+ "MIN CELL VOLTAGE : " + min_CV_ + "," + "MAX TMP : " + max_TMP_ + "," + "MIN TMP : " + min_TMP_ + ","
				+ fet_TMP_ + "," + "AKIM : " + rt_current_ + "," + "Safety Status 1:" + safety_stat1 + ","
				+ "Safety Status 2:" + safety_stat2 + "," + "Safety Status 3:" + safety_stat3 + "," + "Safety Status 4:"
				+ safety_stat4 + "," + "41 Volt USTU : " + v41_ + "," + "45 DERECE USTU : " + t45_;
		
		String protection_log_str_pure = year_+ "/" + month_ + "/" + day_ + " " + hour_ + ":" + min_ + ":" + sec_ + "," + pFlag_L_
				+ "," + pFlag_H_ + ","  +max_CV_ + "," +min_CV_	+ "," +max_TMP_+ "," +min_TMP_+ ","  + fet_TMP_
				+ "," + rt_current_+ "," +safety_stat1 + "," +safety_stat2 + ","+ 
				safety_stat3 + ","+safety_stat4+ "," +v41_+ ","  +t45_;
		
		
			fos.DosyaYazma("protection_log.txt", protection_log_str + "\n");
			fos.DosyaYazma("pure_protect_log.txt", protection_log_str_pure + "\n");

		return protection_log_str;
	}

	static String hextobin(String string) {
		// TODO Auto-generated method stub
		int num = (Integer.parseInt(string, 16));
		return Integer.toBinaryString(num);

	}

}
