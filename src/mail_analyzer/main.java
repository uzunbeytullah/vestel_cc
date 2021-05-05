package mail_analyzer;

import java.sql.SQLException;

import amazon_insert.crm_insert;
import amazon_insert.crm_insert_pf;
import amazon_insert.crm_insert_protection;

public class main {

	public static void main(final String[] args) throws SQLException {
		
		String file_name=args[0];

		new mail_analyse(file_name);

		new crm_insert();
		crm_insert.crm_insert_amazon("mail_body.txt");

		new crm_insert_protection();
		try {
			crm_insert_protection.crm_insert_protection_amazon("pure_protect_log.txt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		new Pf_data_analiz(file_name);
		
		new crm_insert_pf();
		crm_insert_pf.crm_insert_pf_amazon("pf_log.txt");


	}
}
