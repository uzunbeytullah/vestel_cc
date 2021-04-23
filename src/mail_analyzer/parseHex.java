package mail_analyzer;

import file_operation.file_operation;

public class parseHex {
	static String veri_format2 = "";
	static int counter_max = 0;
	static file_operation fos = new file_operation();
	static Protection_data_analiz protect_data_analiz = new Protection_data_analiz();

	static void parseHex(String string) {

		String Device_status_val = "";
		String Last_Update_Time_val = "";
		String State_Of_Charge_val = "";
		String Pack_Voltage_val = "";
		String CELL_1_val = "";
		String CELL_2_val = "";
		String CELL_3_val = "";
		String CELL_4_val = "";
		String CELL_5_val = "";
		String CELL_6_val = "";
		String CELL_7_val = "";
		String CELL_8_val = "";
		String CELL_9_val = "";
		String CELL_10_val = "";
		String Battery_Current_val = "";
		String Temperature_Core_val = "";
		String Temperature_Sensor_1_val = "";
		String Temperature_Sensor_2_val = "";
		String Temperature_Sensor_3_val = "";
		String Average_time_to_full_val = "";
		String Average_time_to_empty_val = "";
		String Remaining_Capacity_val = "";
		String Manufacturing_Name_val = "";
		String Device_Chemistry_val = "";
		String Manufacturing_Date_val = "";
		String Serial_Number_val = "";
		String Design_Capacity_val = "";
		String Full_Charge_Capacity_val = "";
		String Hardware_Version_val = "";
		String Software_Version_val = "";
		String Manufacturing_Status_val = "";
		String State_of_health_val = "";
		String Charging_Status_val = "";
		String Operation_Status_val = "";
		String Permenant_Failure_Status_val = "";
		String Gauging_Status_val = "";
		String Battery_Status_val = "";
		String Cycle_Count_val = "";
		String Safety_Status_val = "";
		String Number_of_total_Over_Temperature_FET_val = "";
		String Last_Over_Current_Discharge_val = "";
		String Last_Over_Temperature_Discharge_val = "";
		String Last_Short_Circuit_Discharge_val = "";
		String Last_Cell_Over_Voltage_val = "";
		String Number_of_total_Over_Load_Discharge_val = "";
		String Number_of_total_Over_Current_Charge_val = "";
		String Number_of_total_Over_Temperature_Discharge_val = "";
		String Last_Over_Temperature_Charge_val = "";
		String Number_of_total_Over_Current_Discharge_val = "";
		String Number_of_total_Cell_Under_Voltage_val = "";
		String Last_Cell_Under_Voltage_val = "";
		String Last_Over_Load_Discharge_val = "";
		String Number_of_total_Short_Circuit_Discharge_val = "";
		String Last_Over_Current_Charge_val = "";
		String Number_of_total_Over_Temperature_Charge_val = "";
		String Last_Over_Temperature_FET_val = "";
		String Number_of_total_Cell_Over_Voltage_val = "";
		String max_CELL_1_val = "";
		String max_CELL_2_val = "";
		String max_CELL_3_val = "";
		String max_CELL_4_val = "";
		String max_CELL_10_val = "";
		String max_CELL_9_val = "";
		String max_CELL_5_val = "";
		String max_CELL_6_val = "";
		String max_CELL_7_val = "";
		String max_CELL_8_val = "";
		String min_CELL_1_val = "";
		String min_CELL_2_val = "";
		String min_CELL_3_val = "";
		String min_CELL_4_val = "";
		String min_CELL_10_val = "";
		String min_CELL_9_val = "";
		String min_CELL_5_val = "";
		String min_CELL_6_val = "";
		String min_CELL_7_val = "";
		String min_CELL_8_val = "";
		String Min_reported_Cell_Temperature_val = "";
		String Max_reported_Average_Discharge_Power_val = "";
		String Max_reported_Discharge_Current_val = "";
		String Max_reported_Charge_Current_val = "";
		String Max_reported_FET_Temperature_val = "";
		String Max_reported_Average_Discharge_Current_val = "";
		String Max_Delta_Cell_Voltage_val = "";
		String Max_reported_Cell_Temperature_val = "";
		String Max_Delta_Cell_Temperature_val = "";
		String Cell_Balancing_bypass_Time_cell_6_val = "";
		String Cell_Balancing_bypass_Time_cell_7_val = "";
		String Cell_Balancing_bypass_Time_cell_8_val = "";
		String Cell_Balancing_bypass_Time_cell_9_val = "";
		String Cell_Balancing_bypass_Time_cell_2_val = "";
		String Cell_Balancing_bypass_Time_cell_3_val = "";
		String Cell_Balancing_bypass_Time_cell_4_val = "";
		String Cell_Balancing_bypass_Time_cell_5_val = "";
		String Number_of_Shutdowns_val = "";
		String Cell_Balancing_bypass_Time_cell_0_val = "";
		String Cell_Balancing_bypass_Time_cell_1_val = "";
		String Total_Firmware_Runtime_since_last_Valid_Charge_Termination_val = "";
		String Total_Firmware_Runtime_val = "";
		String protetion_data_1_val = "";
		String protetion_data_2_val = "";
		String protetion_data_3_val = "";
		String protetion_data_4_val = "";
		String protetion_data_5_val = "";
		String protetion_data_6_val = "";
		String protetion_data_7_val = "";
		String protetion_data_8_val = "";
		String protetion_data_9_val = "";
		String protetion_data_10_val = "";
		String protetion_data_11_val = "";
		String protetion_data_12_val = "";
		String protetion_data_13_val = "";
		String protetion_data_14_val = "";
		String protetion_data_15_val = "";
		String protetion_data_16_val = "";
		String protetion_data_17_val = "";
		String protetion_data_18_val = "";
		String protetion_data_19_val = "";
		String protetion_data_20_val = "";
		String protetion_data_21_val = "";
		String protetion_data_22_val = "";
		String protetion_data_23_val = "";
		String protetion_data_24_val = "";
		String PF_data_val = "";
		String RTC_val = "";

		if (string.contains("Device status")) {
			Device_status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = Device_status_val;
		} else if (string.contains("Last Update Time")) {
			Last_Update_Time_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Update_Time_val;
		} else if (string.contains("State Of Charge")) {
			State_Of_Charge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + State_Of_Charge_val;
		} else if (string.contains("Pack Voltage")) {
			Pack_Voltage_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Pack_Voltage_val;
		} else if (string.contains("CELL_1") && counter_max == 0) {
			CELL_2_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_2_val;
		} else if (string.contains("CELL_2") && counter_max == 0) {
			CELL_3_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_3_val;
		} else if (string.contains("CELL_3") && counter_max == 0) {
			CELL_4_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_4_val;
		} else if (string.contains("CELL_4") && counter_max == 0) {
			CELL_5_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_5_val;
		} else if (string.contains("CELL_5") && counter_max == 0) {
			CELL_6_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_6_val;
		} else if (string.contains("CELL_6") && counter_max == 0) {
			CELL_7_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_7_val;
		} else if (string.contains("CELL_7") && counter_max == 0) {
			CELL_8_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_8_val;
		} else if (string.contains("CELL_8") && counter_max == 0) {
			CELL_9_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_9_val;
		} else if (string.contains("CELL_9") && counter_max == 0) {
			CELL_10_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_10_val;
		} else if (string.contains("CELL_0") && counter_max == 0) {
			CELL_1_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + CELL_1_val;
		} else if (string.contains("Battery Current")) {
			Battery_Current_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Battery_Current_val;
		} else if (string.contains("Temperature Core")) {
			Temperature_Core_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Temperature_Core_val;
		} else if (string.contains("Temperature Sensor 1")) {
			Temperature_Sensor_1_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Temperature_Sensor_1_val;
		} else if (string.contains("Temperature Sensor 2")) {
			Temperature_Sensor_2_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Temperature_Sensor_2_val;
		} else if (string.contains("Temperature Sensor 3")) {
			Temperature_Sensor_3_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Temperature_Sensor_3_val;
		} else if (string.contains("Average time to full")) {
			Average_time_to_full_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Average_time_to_full_val;
		} else if (string.contains("Average time to empty")) {
			Average_time_to_empty_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Average_time_to_empty_val;
		} else if (string.contains("Remaining Capacity")) {
			Remaining_Capacity_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Remaining_Capacity_val;
		} else if (string.contains("Manufacturing Name")) {
			Manufacturing_Name_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Manufacturing_Name_val;
		} else if (string.contains("Device Chemistry")) {
			Device_Chemistry_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Device_Chemistry_val;
		} else if (string.contains("Manufacturing Date")) {
			Manufacturing_Date_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Manufacturing_Date_val;
		} else if (string.contains("Serial Number")) {
			Serial_Number_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Serial_Number_val;
		} else if (string.contains("Design Capacity")) {
			Design_Capacity_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Design_Capacity_val;
		} else if (string.contains("Full Charge Capacity")) {
			Full_Charge_Capacity_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Full_Charge_Capacity_val;
		} else if (string.contains("Hardware Version")) {
			Hardware_Version_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Hardware_Version_val;
		} else if (string.contains("Software Version")) {
			Software_Version_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Software_Version_val;
		} else if (string.contains("Manufacturing Status")) {
			Manufacturing_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Manufacturing_Status_val;
		} else if (string.contains("State of health")) {
			State_of_health_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + State_of_health_val;
		} else if (string.contains("Charging Status")) {
			Charging_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Charging_Status_val;
		} else if (string.contains("Operation Status")) {
			Operation_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Operation_Status_val;
		} else if (string.contains("Permenant Failure Status")) {
			Permenant_Failure_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Permenant_Failure_Status_val;
		} else if (string.contains("Gauging Status")) {
			Gauging_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Gauging_Status_val;
		} else if (string.contains("Battery Status")) {
			Battery_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Battery_Status_val;
		} else if (string.contains("Cycle Count")) {
			Cycle_Count_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cycle_Count_val;
		} else if (string.contains("Safety Status")) {
			Safety_Status_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Safety_Status_val;
		} else if (string.contains("Number of total Over Temperature FET")) {
			Number_of_total_Over_Temperature_FET_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Over_Temperature_FET_val;
		} else if (string.contains("Last Over Current Discharge")) {
			Last_Over_Current_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Over_Current_Discharge_val;
		} else if (string.contains("Last Over Temperature Discharge")) {
			Last_Over_Temperature_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Over_Temperature_Discharge_val;
		} else if (string.contains("Last Short Circuit Discharge")) {
			Last_Short_Circuit_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Short_Circuit_Discharge_val;
		} else if (string.contains("Last Cell Over Voltage")) {
			Last_Cell_Over_Voltage_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Cell_Over_Voltage_val;
		} else if (string.contains("Number of total Over Load Discharge")) {
			Number_of_total_Over_Load_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Over_Load_Discharge_val;
		} else if (string.contains("Number of total Over Current Charge")) {
			Number_of_total_Over_Current_Charge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Over_Current_Charge_val;
		} else if (string.contains("Number of total Over Temperature Discharge")) {
			Number_of_total_Over_Temperature_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Over_Temperature_Discharge_val;
		} else if (string.contains("Last Over Temperature Charge")) {
			Last_Over_Temperature_Charge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Over_Temperature_Charge_val;
		} else if (string.contains("Number of total Over Current Discharge")) {
			Number_of_total_Over_Current_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Over_Current_Discharge_val;
		} else if (string.contains("Number of total Cell Under Voltage")) {
			Number_of_total_Cell_Under_Voltage_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Cell_Under_Voltage_val;
		} else if (string.contains("Last Cell Under Voltage")) {
			Last_Cell_Under_Voltage_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Cell_Under_Voltage_val;
		} else if (string.contains("Last Over Load Discharge")) {
			Last_Over_Load_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Over_Load_Discharge_val;
		} else if (string.contains("Number of total Short Circuit Discharge")) {
			Number_of_total_Short_Circuit_Discharge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Short_Circuit_Discharge_val;
		} else if (string.contains("Last Over Current Charge")) {
			Last_Over_Current_Charge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Over_Current_Charge_val;
		} else if (string.contains("Number of total Over Temperature Charge")) {
			Number_of_total_Over_Temperature_Charge_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Over_Temperature_Charge_val;
		} else if (string.contains("Last Over Temperature FET")) {
			Last_Over_Temperature_FET_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Last_Over_Temperature_FET_val;
		} else if (string.contains("Number of total Cell Over Voltage")) {
			counter_max = counter_max + 1;
			Number_of_total_Cell_Over_Voltage_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_total_Cell_Over_Voltage_val;
		}

		else if (string.contains("CELL_1") && counter_max == 1) {
			max_CELL_2_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_2_val;
		} else if (string.contains("CELL_2") && counter_max == 1) {
			max_CELL_3_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_3_val;
		} else if (string.contains("CELL_3") && counter_max == 1) {
			max_CELL_4_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_4_val;
		} else if (string.contains("CELL_4") && counter_max == 1) {
			max_CELL_5_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_5_val;
		} else if (string.contains("CELL_0") && counter_max == 1) {
			max_CELL_1_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_1_val;
		} else if (string.contains("CELL_9") && counter_max == 1) {
			max_CELL_10_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_10_val;
		} else if (string.contains("CELL_5") && counter_max == 1) {
			max_CELL_6_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_6_val;
		} else if (string.contains("CELL_6") && counter_max == 1) {
			max_CELL_7_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_7_val;
		} else if (string.contains("CELL_7") && counter_max == 1) {
			max_CELL_8_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_8_val;
		} else if (string.contains("CELL_8") && counter_max == 1) {
			counter_max = counter_max + 1;
			max_CELL_9_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + max_CELL_9_val;
		}

		else if (string.contains("CELL_1") && counter_max == 2) {
			min_CELL_2_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_2_val;
		} else if (string.contains("CELL_2") && counter_max == 2) {
			min_CELL_3_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_3_val;
		} else if (string.contains("CELL_3") && counter_max == 2) {
			min_CELL_4_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_4_val;
		} else if (string.contains("CELL_4") && counter_max == 2) {
			min_CELL_5_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_5_val;
		} else if (string.contains("CELL_0") && counter_max == 2) {
			min_CELL_1_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_1_val;
		} else if (string.contains("CELL_9") && counter_max == 2) {
			min_CELL_10_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_10_val;
		} else if (string.contains("CELL_5") && counter_max == 2) {
			min_CELL_6_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_6_val;
		} else if (string.contains("CELL_6") && counter_max == 2) {
			min_CELL_7_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_7_val;
		} else if (string.contains("CELL_7") && counter_max == 2) {
			min_CELL_8_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_8_val;
		} else if (string.contains("CELL_8") && counter_max == 2) {
			min_CELL_9_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + min_CELL_9_val;
		} else if (string.contains("Min reported Cell Temperature")) {
			Min_reported_Cell_Temperature_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Min_reported_Cell_Temperature_val;
		} else if (string.contains("Max reported Average Discharge Power")) {
			Max_reported_Average_Discharge_Power_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_reported_Average_Discharge_Power_val;
		} else if (string.contains("Max reported Discharge Current")) {
			Max_reported_Discharge_Current_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_reported_Discharge_Current_val;
		} else if (string.contains("Max reported Charge Current")) {
			Max_reported_Charge_Current_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_reported_Charge_Current_val;
		} else if (string.contains("Max reported FET Temperature")) {
			Max_reported_FET_Temperature_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_reported_FET_Temperature_val;
		} else if (string.contains("Max reported Average Discharge Current")) {
			Max_reported_Average_Discharge_Current_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_reported_Average_Discharge_Current_val;
		} else if (string.contains("Max Delta Cell Voltage")) {
			Max_Delta_Cell_Voltage_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_Delta_Cell_Voltage_val;
		} else if (string.contains("Max reported Cell Temperature")) {
			Max_reported_Cell_Temperature_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_reported_Cell_Temperature_val;
		} else if (string.contains("Max Delta Cell Temperature")) {
			Max_Delta_Cell_Temperature_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Max_Delta_Cell_Temperature_val;
		} else if (string.contains("Cell Balancing bypass Time cell 6")) {
			Cell_Balancing_bypass_Time_cell_6_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_6_val;
		} else if (string.contains("Cell Balancing bypass Time cell 7")) {
			Cell_Balancing_bypass_Time_cell_7_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_7_val;
		} else if (string.contains("Cell Balancing bypass Time cell 8")) {
			Cell_Balancing_bypass_Time_cell_8_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_8_val;
		} else if (string.contains("Cell Balancing bypass Time cell 9")) {
			Cell_Balancing_bypass_Time_cell_9_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_9_val;
		} else if (string.contains("Cell Balancing bypass Time cell 2")) {
			Cell_Balancing_bypass_Time_cell_2_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_2_val;
		} else if (string.contains("Cell Balancing bypass Time cell 3")) {
			Cell_Balancing_bypass_Time_cell_3_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_3_val;
		} else if (string.contains("Cell Balancing bypass Time cell 4")) {
			Cell_Balancing_bypass_Time_cell_4_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_4_val;
		} else if (string.contains("Cell Balancing bypass Time cell 5")) {
			Cell_Balancing_bypass_Time_cell_5_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_5_val;
		} else if (string.contains("Number of Shutdowns")) {
			Number_of_Shutdowns_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Number_of_Shutdowns_val;
		} else if (string.contains("Cell Balancing bypass Time cell 0")) {
			Cell_Balancing_bypass_Time_cell_0_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_0_val;
		} else if (string.contains("Cell Balancing bypass Time cell 1")) {
			Cell_Balancing_bypass_Time_cell_1_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Cell_Balancing_bypass_Time_cell_1_val;
		} else if (string.contains("Total Firmware Runtime since last Valid Charge Termination")) {
			Total_Firmware_Runtime_since_last_Valid_Charge_Termination_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Total_Firmware_Runtime_since_last_Valid_Charge_Termination_val;
		} else if (string.contains("Total Firmware Runtime")) {
			Total_Firmware_Runtime_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + Total_Firmware_Runtime_val;
		} else if (string.startsWith("Protection log: index:0")) {
			protetion_data_1_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_1_val);
		} else if (string.startsWith("Protection log: index:1")) {
			protetion_data_2_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_2_val);
		} else if (string.startsWith("Protection log: index:2")) {
			protetion_data_3_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_3_val);
		} else if (string.startsWith("Protection log: index:3")) {
			protetion_data_4_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_4_val);
		} else if (string.startsWith("Protection log: index:4")) {
			protetion_data_5_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_5_val);
		} else if (string.startsWith("Protection log: index:5")) {
			protetion_data_6_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_6_val);
		} else if (string.startsWith("Protection log: index:6")) {
			protetion_data_7_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_7_val);
		} else if (string.startsWith("Protection log: index:7")) {
			protetion_data_8_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_8_val);
		} else if (string.startsWith("Protection log: index:8")) {
			protetion_data_9_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_9_val);
		} else if (string.startsWith("Protection log: index:9")) {
			protetion_data_10_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_10_val);
		} else if (string.startsWith("Protection log: index:10")) {
			protetion_data_11_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_11_val);
		} else if (string.startsWith("Protection log: index:11")) {
			protetion_data_12_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_12_val);
		} else if (string.startsWith("Protection log: index:12")) {
			protetion_data_13_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_13_val);
		} else if (string.startsWith("Protection log: index:13")) {
			protetion_data_14_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_14_val);
		} else if (string.startsWith("Protection log: index:14")) {
			protetion_data_15_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_15_val);
		} else if (string.startsWith("Protection log: index:15")) {
			protetion_data_16_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_16_val);
		} else if (string.startsWith("Protection log: index:16")) {
			protetion_data_17_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_17_val);
		} else if (string.startsWith("Protection log: index:17")) {
			protetion_data_18_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_18_val);
		} else if (string.startsWith("Protection log: index:18")) {
			protetion_data_19_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_19_val);
		} else if (string.startsWith("Protection log: index:19")) {
			protetion_data_20_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_20_val);
		} else if (string.startsWith("Protection log: index:20")) {
			protetion_data_21_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_21_val);
		} else if (string.startsWith("Protection log: index:21")) {
			protetion_data_22_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_22_val);
		} else if (string.startsWith("Protection log: index:22")) {
			protetion_data_23_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_23_val);
		} else if (string.startsWith("Protection log: index:23")) {
			protetion_data_24_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + protect_data_analiz.protect_data_analiz(protetion_data_24_val);
		} else if (string.startsWith("PF data")) {
			PF_data_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + PF_data_val;
		} else if (string.startsWith("RTC")) {
			RTC_val = string.substring(string.indexOf(":") + 1);
			veri_format2 = veri_format2 + ";" + RTC_val;
		}

		if (string.contains("EOF")) {
			//file_operation.DosyaOlustur("mail_body.txt");
			fos.DosyaYazma("mail_body.txt", veri_format2 + "\n");
			
		}
	}

}
