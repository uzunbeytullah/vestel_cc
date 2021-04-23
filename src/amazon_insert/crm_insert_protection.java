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

public class crm_insert_protection {

    	public static void crm_insert_protection_amazon(String args) throws SQLException {

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
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
     
       // br_conf = new BufferedReader(fileReader_conf);
        br = new BufferedReader(fileReader);
        
        PreparedStatement pst2 = null;
		try {
			pst2 = conn1.dbConn().prepareStatement("select max(id) from crm_battery_information");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        ResultSet rs2 = pst2.executeQuery();
        String crm_id ="" ;
        while(rs2.next())
        {
        	crm_id = rs2.getString(1);
        }

 
        PreparedStatement pst1 = null;
		try {
			pst1 = conn1.dbConn().prepareStatement("select max(id)+1 from crm_protection_log");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        ResultSet rs = pst1.executeQuery();
        int user_id =0 ;
        while(rs.next())
        {
            user_id = Integer.parseInt(rs.getString(1));
           
        }

        final int batchSize = 5000;
        int count = 0;
        
		final String readRecordSQL = "INSERT INTO test.crm_protection_log ("
        		+ "id, crm_id,protection_date, pFlag_L, pFlag_H, cell_max, cell_min, max_temp, min_temp, fet_temp, rt_current, v_cell_sync_L, v_cell_sync_H, auth_nc_L,auth_nc_H, v41,t45,error_code,error_desc "
        		        		+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
       
        PreparedStatement st = null;
        //System.out.println(readRecordSQL);
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
                String error_code="";
                String error_desc="";

                if ( lineItem[9].equalsIgnoreCase("1") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="CUV";
                	error_desc="Batarya paketini sarj edin ve sarj islemi tamamlanana kadar bekleyin";
                }
                else if ( lineItem[9] .equalsIgnoreCase("10") && lineItem[ 10 ] .equalsIgnoreCase("0") && lineItem[ 11 ] .equalsIgnoreCase("0") && lineItem[ 12 ] .equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="COV";
                	error_desc="Batarya paketini sarj edin ve sarj islemi tamamlanana kadar bekleyin";
                }
                else if ( lineItem[9].equalsIgnoreCase("100")  && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0")   && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="OCC";
                	error_desc="Sarj cihazi arizali olabilir veya 41V olana kadar desarj islemi uygulayin";                }
                else if ( lineItem[9].equalsIgnoreCase("1000") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="OCD";
                	error_desc="e-bisikleti kullanmayi durdurun ve hata durumu gostergesinin normale donmesini bekleyin. motor kablolarini kontrol edin ve kablo veya soket hasari gorurseniz e-bisiklet bayinizle iletisime gecin";
                }
                else if ( lineItem[9].equalsIgnoreCase("10000") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="AOLD";
                	error_desc="e-bisikleti kullanmayi durdurun ve hata durumu gostergesinin normale donmesini bekleyin	";
                }
                else if ( lineItem[9].equalsIgnoreCase("100000") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="AOLDL";
                	error_desc="AOLDL	";
                }
                else if ( lineItem[9].equalsIgnoreCase("1000000") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="ASCD";
                	error_desc="e-bisikleti kullanmayi durdurun ve hata durumu gostergesinin normale donmesini bekleyin. sorun ortadan kalkmazsa e-bisiklet bayinizle iletisime gecin";
                }
                else if ( lineItem[9].equalsIgnoreCase("10000000") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_L
                	error_code="ASCDL";
                	error_desc="ASCDL";
                }
                //---------------------------------------------------------------
                
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ] =="1" && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="OTC";
                	error_desc="Calisma sicakligi araligina donene kadar batarya paketinin oda sicakliginda kalmasina izin verin";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("10") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="OTD";
                	error_desc="Calisma sicakligi araligina donene kadar batarya paketinin oda sicakliginda kalmasina izin verin";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ] =="100" && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="UTC";
                	error_desc="Calisma sicakligi araligina donene kadar batarya paketinin oda sicakliginda kalmasina izin verin";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("1000") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="UTD";
                	error_desc="Calisma sicakligi araligina donene kadar batarya paketinin oda sicakliginda kalmasina izin verin";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("10000") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="AFE_OVRD";
                	error_desc="yerel e-bisiklet bayinizle iletisime gecin";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("100000") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="OTF";
                	error_desc="Calisma sicakligi araligina donene kadar batarya paketinin oda sicakliginda kalmasina izin verin";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("1000000") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="OCDL";
                	error_desc="OCDL";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("10000000") && lineItem[ 11 ].equalsIgnoreCase("0") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //v_cell_sync_H
                	error_code="";
                	error_desc="";
                }
                //-------------------------------------------------------------------
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ] =="1" && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //auth_nc_L
                	error_code="PTO";
                	error_desc="PTO";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("10") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //auth_nc_L
                	error_code="";
                	error_desc="";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ] =="100" && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //auth_nc_L
                	error_code="CTO";
                	error_desc="CTO";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("1000") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //auth_nc_L
                	error_code="";
                	error_desc="";
                }
                else if ( lineItem[9].equalsIgnoreCase("0") && lineItem[ 10 ].equalsIgnoreCase("0") && lineItem[ 11 ].equalsIgnoreCase("10000") && lineItem[ 12 ].equalsIgnoreCase("0")  ) { //auth_nc_L
                	error_code="OC";
                	error_desc="OC";
                }
               //----------------------------------------------------------------------------------------------------
                
                st.setInt (1, user_id);
                st.setString( 2 , crm_id);
                st.setString( 3 , lineItem[ 0 ]);
                st.setString( 4 , lineItem[ 1 ]);
                st.setString( 5 , lineItem[ 2 ]);
                st.setString( 6 , lineItem[ 3 ]);
                st.setString( 7 , lineItem[ 4 ]);
                st.setString( 8 , lineItem[ 5 ]);
                st.setString( 9 , lineItem[ 6 ]);
                st.setString( 10 , lineItem[ 7 ]);
                st.setString( 11 , lineItem[ 8 ]);
                st.setString( 12 , lineItem[ 9 ]);
                st.setString( 13 , lineItem[ 10 ]);
                st.setString( 14 , lineItem[ 11 ]);
                st.setString( 15 , lineItem[ 12 ]);
                st.setString( 16 , lineItem[ 13 ]);
                st.setString( 17 , lineItem[ 14 ]);
                st.setString( 18 , error_code);
                st.setString( 19 , error_desc);
                user_id=user_id+1;
                
     

               // st.execute();
                //System.out.println(st);
                st.addBatch();
              if (++count % batchSize == 0) {
                   st.executeBatch();
                  System.out.println(String.valueOf(count) + "row inserted");
              }
              list.clear();
          }
          st.executeBatch();
         System.out.println(String.valueOf(count) + "row protection inserted and completed");
        }
        catch (IOException e4) {
            e4.printStackTrace();
        }
        final String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp2);
    }
}