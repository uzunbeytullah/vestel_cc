package amazon_insert;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

import connection.mysql_connection;

import java.text.SimpleDateFormat;
import java.io.File;

public class crm_insert_pf {

	public static void crm_insert_pf_amazon(String args) throws SQLException {

		final File f = new File(args);
		final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		if (!f.exists()) {
			System.err.println("File not Found!");
			return;
		}
		final mysql_connection conn1 = new mysql_connection();
		BufferedReader br = null;
		FileReader fileReader = null;
		final ArrayList<String> list = new ArrayList<String>();
		try {
			fileReader = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		br = new BufferedReader(fileReader);

		PreparedStatement pst2 = null;
		try {
			pst2 = conn1.dbConn().prepareStatement("select max(id) from crm_battery_information");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs2 = pst2.executeQuery();
		String crm_id = "";
		while (rs2.next()) {
			crm_id = rs2.getString(1);
		}

		PreparedStatement pst1 = null;
		try {
			pst1 = conn1.dbConn().prepareStatement("select max(id)+1 from crm_pf_log");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = pst1.executeQuery();
		int user_id = 0;
		while (rs.next()) {
			user_id = Integer.parseInt(rs.getString(1));

		}

		final int batchSize = 5000;
		int count = 0;

		final String readRecordSQL = "INSERT INTO test.crm_pf_log ("
				+ "id, crm_id,protection_date,PF_L,PF_H, pFlag_L, pFlag_H,cell1_volt,cell2_volt,cell3_volt,cell4_volt,cell5_volt,cell6_volt,cell7_volt,cell8_volt,cell9_volt,cell10_volt, max_temp, min_temp, fet_temp, rt_current, rem_capacity,pf_code,pf_desc"
				+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement st = null;
		// System.out.println(readRecordSQL);
		try {
			System.out.println("st öncesi");
			st = conn1.dbConn().prepareStatement(readRecordSQL);

			System.out.println("connected");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String line2;
			while ((line2 = br.readLine()) != null) {
				final String[] lineItem = line2.split(",");
				PreparedStatement pst3 = null;
        		try {
        			pst3 = conn1.dbConn().prepareStatement("select safety_name from safety_table where (safety_number = 5 and safety_bin_str =  '"+lineItem[1]+"')");
        			System.out.println("BEYTULLAH : "+lineItem[1]);
        			System.out.println("pst3 : "+pst3);
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                ResultSet rs3 = pst3.executeQuery();
                String error_codew ="" ;
                while(rs3.next())
                {
                	error_codew = rs3.getString(1);
                }
                               
                PreparedStatement pst4 = null;
        		try {
        			pst4 = conn1.dbConn().prepareStatement("select error_solution from safety_table where (safety_number = 5 and safety_bin_str =  '"+lineItem[1]+"')");
        		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
                ResultSet rs4 = pst4.executeQuery();
                String error_descw ="" ;
                while(rs4.next())
                {
                	error_descw = rs4.getString(1);
                }
				// ----------------------------------------------------------------------------------------------------

				st.setInt(1, user_id);
				st.setString(2, crm_id);
				st.setString(3, lineItem[0]);// date
				st.setString(4, lineItem[1]);// PF_L
				st.setString(5, lineItem[2]);// PF_H
				st.setString(6, lineItem[3]);
				st.setString(7, lineItem[4]);
				st.setString(8, lineItem[5]);// cell1
				st.setString(9, lineItem[6]);
				st.setString(10, lineItem[7]);
				st.setString(11, lineItem[8]);
				st.setString(12, lineItem[9]);
				st.setString(13, lineItem[10]);
				st.setString(14, lineItem[11]);
				st.setString(15, lineItem[12]);
				st.setString(16, lineItem[13]);
				st.setString(17, lineItem[14]);// cell10
				st.setString(18, lineItem[15]);
				st.setString(19, lineItem[16]);
				st.setString(20, lineItem[17]);
				st.setString(21, lineItem[18]);
				st.setString(22, lineItem[19]);
				st.setString(23, error_codew);
				st.setString(24, error_descw);
				user_id = user_id + 1;
				
				st.addBatch();
				if (++count % batchSize == 0) {
					st.executeBatch();
					System.out.println(String.valueOf(count) + "row inserted");
				}
				list.clear();
			}
			st.executeBatch();
			System.out.println(String.valueOf(count) + "row inserted and completed");
		} catch (IOException e4) {
			e4.printStackTrace();
		}
		final String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp2);
	}
}