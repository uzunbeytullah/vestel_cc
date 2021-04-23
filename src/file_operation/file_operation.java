package file_operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_operation {
	static int mode_number = 38;
	static int mode_number_tmp = 0;

	/*public static String readFile() {
		String data = "";
		try {
			File myObj = new File("C:\\Users\\vestel\\Desktop\\full_dsg_list.log");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}*/

	public void DosyaSil(String URL) {
		File file2 = new File(URL);
		if (file2.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}

	}

	public void DosyaYazma(String URL, String veri) {
		File file = new File(URL); // hangi dosya üzerinde iþlem yapacaðýmýzý seçiyoruz.

		try {
			// Dosyaya yazmak için nesnemizi oluþturuyoruz.
			FileOutputStream fos = new FileOutputStream(file, true);

			if (mode_number_tmp % mode_number == mode_number - 1) {

			}
			mode_number_tmp = mode_number_tmp + 1;

			fos.write(veri.getBytes());
			fos.flush();
			// Ýþlemimiz bitince kaynaklarýmýzý kapatýyoruz. Boþuna sistemde hazýr
			// beklemesinler.
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void DosyaOlustur(String URL) {
		File f = new File(URL); // yol belirtmeyip sadece dosya ismi belirttiðimiz zaman otomatik olarak
								// bulunduðu klasöre göre iþlem yapar.
		try {
			if (!f.exists()) { // eðer dosya yoksa
				f.createNewFile(); // dosyamýzý oluþturur.
				System.out.println(f.getName() + " adlý dosya Oluþturuldu..");
			} else {
				System.out.println("Dosya olduðundan oluþturma iþlemi yapýlmayacaktýr. ");
			}
		} catch (IOException e) { // hata yakalama
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
