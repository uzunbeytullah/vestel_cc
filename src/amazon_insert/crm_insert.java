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

public class crm_insert {
	
	public static void crm_insert_amazon(String args) throws SQLException {
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

			// br_conf = new BufferedReader(fileReader_conf);
			br = new BufferedReader(fileReader);

			PreparedStatement pst1 = null;
			try {
				pst1 = conn1.dbConn().prepareStatement("select max(id)+1 from crm_battery_information");
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ResultSet rs = pst1.executeQuery();
			String user_id = "";
			while (rs.next()) {
				user_id = rs.getString(1);
			}

			final int batchSize = 5000;
			int count = 0;

			final String readRecordSQL = "INSERT INTO test.crm_battery_information ("
					+ "id, device_status,last_update_time, SOC, pack_volt, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9, cell10, cell1,  rt_current,core_temp , ts1_temp,  ts2_temp,  ts3_temp,avg_time_to_full, avg_time_to_empty,  rem_capacity,  man_name,  device_chemistry, man_date, serial_number, design_capacity,  full_charge_cap,  hw_version,  sw_version,  man_status,SOH, charging_status,  operation_status,PF_status, gauging_status, battery_status, cycle_count,safety_status, numOfOverTempFET, lastOCD,  lastOTD,  lastShortCircuitDischarge, lastCellOverVoltage,  numOfOLD,  numOfOCC,  numOfOTD,  lastOverTempCharge, numOfOCD,  numOfCUV,  lastCUV,lastOLD,  numOfShortCircuitDischarge,lastOCC,  numOfOTC,  lastOTFet, numOfCOV,  cell1_max, cell2_max, cell3_max, cell4_max, cell5_max, cell6_max, cell7_max, cell8_max, cell9_max, cell10_max,cell1_min, cell2_min, cell3_min, cell4_min, cell5_min, cell6_min, cell7_min, cell8_min, cell9_min, cell10_min,minReportedCelTemp, maxAvgDischargepower, maxDischargeCurrent,  maxChargeCurrent,maxFettemp,  maxAvgDsgCurrent, maxDeltaCellVoltage,  maxReportedCellTemp,  maxDeltCelltemp,cell1_bal_time, cell2_bal_time, cell3_bal_time, cell4_bal_time, cell5_bal_time, cell6_bal_time, cell7_bal_time, cell8_bal_time, cell9_bal_time, cell10_bal_time,numOfShutdown, totalFWRuntimeSinceCharge, totalFWRuntime "
					+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
					final String[] lineItem = line2.split(";");
					st.setInt(1, Integer.parseInt(user_id));// next int alýnacak
					st.setString(2, lineItem[0]);
					st.setString(3, lineItem[1]);
					st.setString(4, lineItem[2]);
					st.setString(5, lineItem[3]);
					st.setString(6, lineItem[4]);
					st.setString(7, lineItem[5]);
					st.setString(8, lineItem[6]);
					st.setString(9, lineItem[7]);
					st.setString(10, lineItem[8]);
					st.setString(11, lineItem[9]);
					st.setString(12, lineItem[10]);
					st.setString(13, lineItem[11]);
					st.setString(14, lineItem[12]);
					st.setString(15, lineItem[13]);
					st.setString(16, lineItem[14]);
					st.setString(17, lineItem[15]);
					st.setString(18, lineItem[16]);
					st.setString(19, lineItem[17]);
					st.setString(20, lineItem[18]);
					st.setString(21, lineItem[19]);
					st.setString(22, lineItem[20]);
					st.setString(23, lineItem[21]);
					st.setString(24, lineItem[22]);
					st.setString(25, lineItem[23]);
					st.setString(26, lineItem[24]);
					st.setString(27, lineItem[25]);
					st.setString(28, lineItem[26]);
					st.setString(29, lineItem[27]);
					st.setString(30, lineItem[28]);
					st.setString(31, lineItem[29]);
					st.setString(32, lineItem[30]);
					st.setString(33, lineItem[31]);
					st.setString(34, lineItem[32]);
					st.setString(35, lineItem[33]);
					st.setString(36, lineItem[34]);
					st.setString(37, lineItem[35]);
					st.setString(38, lineItem[36]);
					st.setString(39, lineItem[37]);
					st.setString(40, lineItem[38]);
					st.setString(41, lineItem[39]);
					st.setString(42, lineItem[40]);
					st.setString(43, lineItem[41]);
					st.setString(44, lineItem[42]);
					st.setString(45, lineItem[43]);
					st.setString(46, lineItem[44]);
					st.setString(47, lineItem[45]);
					st.setString(48, lineItem[46]);
					st.setString(49, lineItem[47]);
					st.setString(50, lineItem[48]);
					st.setString(51, lineItem[49]);
					st.setString(52, lineItem[50]);
					st.setString(53, lineItem[51]);
					st.setString(54, lineItem[52]);
					st.setString(55, lineItem[53]);
					st.setString(56, lineItem[54]);
					st.setString(57, lineItem[55]);
					st.setString(58, lineItem[56]);
					st.setString(59, lineItem[57]);
					st.setString(60, lineItem[58]);
					st.setString(61, lineItem[59]);
					st.setString(62, lineItem[60]);
					st.setString(63, lineItem[61]);
					st.setString(64, lineItem[62]);
					st.setString(65, lineItem[63]);
					st.setString(66, lineItem[64]);
					st.setString(67, lineItem[65]);
					st.setString(68, lineItem[66]);
					st.setString(69, lineItem[67]);
					st.setString(70, lineItem[68]);
					st.setString(71, lineItem[69]);
					st.setString(72, lineItem[70]);
					st.setString(73, lineItem[71]);
					st.setString(74, lineItem[72]);
					st.setString(75, lineItem[73]);
					st.setString(76, lineItem[74]);
					st.setString(77, lineItem[75]);
					st.setString(78, lineItem[76]);
					st.setString(79, lineItem[77]);
					st.setString(80, lineItem[78]);
					st.setString(81, lineItem[79]);
					st.setString(82, lineItem[80]);
					st.setString(83, lineItem[81]);
					st.setString(84, lineItem[82]);
					st.setString(85, lineItem[83]);
					st.setString(86, lineItem[84]);
					st.setString(87, lineItem[85]);
					st.setString(88, lineItem[86]);
					st.setString(89, lineItem[87]);
					st.setString(90, lineItem[88]);
					st.setString(91, lineItem[89]);
					st.setString(92, lineItem[90]);
					st.setString(93, lineItem[91]);
					st.setString(94, lineItem[92]);
					st.setString(95, lineItem[93]);
					st.setString(96, lineItem[94]);
					st.setString(97, lineItem[95]);
					st.setString(98, lineItem[96]);
					st.setString(99, lineItem[97]);
					st.setString(100, lineItem[98]);

					// st.execute();
					// System.out.println(st);
					st.addBatch();
					if (++count % batchSize == 0) {
						st.executeBatch();
						System.out.println(String.valueOf(count) + "row crm inserted");
					}
					list.clear();
				}
				st.executeBatch();
				System.out.println(String.valueOf(count) + "row  crm inserted and completed");
			} catch (IOException e4) {
				e4.printStackTrace();
			}
			final String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			System.out.println(timeStamp2);
		}
	}

