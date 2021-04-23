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
		File file = new File(URL); // hangi dosya �zerinde i�lem yapaca��m�z� se�iyoruz.

		try {
			// Dosyaya yazmak i�in nesnemizi olu�turuyoruz.
			FileOutputStream fos = new FileOutputStream(file, true);

			if (mode_number_tmp % mode_number == mode_number - 1) {

			}
			mode_number_tmp = mode_number_tmp + 1;

			fos.write(veri.getBytes());
			fos.flush();
			// ��lemimiz bitince kaynaklar�m�z� kapat�yoruz. Bo�una sistemde haz�r
			// beklemesinler.
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void DosyaOlustur(String URL) {
		File f = new File(URL); // yol belirtmeyip sadece dosya ismi belirtti�imiz zaman otomatik olarak
								// bulundu�u klas�re g�re i�lem yapar.
		try {
			if (!f.exists()) { // e�er dosya yoksa
				f.createNewFile(); // dosyam�z� olu�turur.
				System.out.println(f.getName() + " adl� dosya Olu�turuldu..");
			} else {
				System.out.println("Dosya oldu�undan olu�turma i�lemi yap�lmayacakt�r. ");
			}
		} catch (IOException e) { // hata yakalama
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
