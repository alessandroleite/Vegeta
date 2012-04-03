package com.vegeta.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import oracle.jdbc.driver.OracleDriver;

public class DataAccessObject {
	
	//TODO Jogar conexao para um arquivo de configuracoes.
	private String url = "jdbc:oracle:thin:@//127.0.0.1:1521/xe";
	private String user = "spartacus";
	private String password = "123";
	private String schema = "SPARTACUS";
		
	private final String pathFile = "D:\\Projects\\vegeta\\files\\vegeta.xml";
	
	//TODO Remover objeto.
	private static Connection connection = null;
	
	private SortedMap<String, TableVO> tables = 
			new TreeMap<String, TableVO>();
	
	public static void main(String[] args) throws SQLException, IOException {
		DataAccessObject data = new DataAccessObject();		
		data.load();
		data.close(connection);
		StringBuilder txt = new StringBuilder();
		for (String tableName : data.tables.keySet()) {
			TableVO table = data.tables.get(tableName);
			txt.append(table.toXML());		
		}
		data.saveToFile(txt.toString());
		System.out.println("Vegeta has completed its work!");
	}
	
	//TODO Remover construtor.
	public DataAccessObject() throws SQLException {
		connection = getConnection();
	}
	
	public DataAccessObject(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void close(ResultSet rs, Statement stm) throws SQLException {
		close(stm);
		close(rs);
	}
		
	public void load() throws SQLException {
		//String[] types = {"TABLE", "VIEW"};
		String[] types = {"TABLE"};
		ResultSet rs = connection.getMetaData().getTables(null, schema, "%", types);
		while (rs.next()) {
			TableVO table = new TableVO();
			table.setName(rs.getString(3));
			
			Map<String, PrimaryKey> pks = loadPrimaryKeys(table);
			
			for (String pkKey : pks.keySet()) {
				PrimaryKey pk = pks.get(pkKey);
				System.out.println(pk.getTable().getName() + ":");
				System.out.println("[" + pk.getName() + "]");
				for (Integer seq : pk.getFields().keySet()) {
					FieldVO field = pk.getFields().get(seq);
					System.out.println(field.getSeq() + " - " + field.getName());
				}
			}
			
			/*String sql = "select * from " + schema + "." + table.getName();			
			Statement stmFields = connection.createStatement();
			ResultSet rsFields = stmFields.executeQuery(sql);
			ResultSetMetaData rsMDFields = rsFields.getMetaData();			
			int columnCount = rsMDFields.getColumnCount();			
			List<FieldVO> listFields = new ArrayList<FieldVO>();			
			for (int i = 1; i <= columnCount; i++) {
				FieldVO field = new FieldVO(rsMDFields, i);
				listFields.add(field);			    
			}
			table.setFields(listFields);
			tables.put(table.getName(), table);			
			rsMDFields = null;
			close(rsFields, stmFields);*/
		}
		close(rs);
	}
	
	private Map<String, PrimaryKey> loadPrimaryKeys(TableVO table) throws SQLException {
		Map<String, PrimaryKey> map = new HashMap<String, PrimaryKey>();
		ResultSet rs = null;
		try {
			rs = connection.getMetaData().getPrimaryKeys(null, schema, table.getName());
			while (rs.next()) {
				String pkName = rs.getString("PK_NAME");				
				PrimaryKey pk = new PrimaryKey(table);				
				if (map.containsKey(pkName)) {
					pk = map.get(pkName);					
				} else {
					pk.setName(pkName);
				}
				FieldVO field = new FieldVO(table);
				field.setSeq(rs.getInt("KEY_SEQ"));
				field.setName(rs.getString("COLUMN_NAME"));
				pk.getFields().put(field.getSeq(), field);
				map.put(pk.getName(), pk);
			}
		} finally {
			close(rs);
		}	
		return map;
	}
		
	public void saveToFile(String txt) throws IOException {
		FileWriter f = new FileWriter(pathFile);
		BufferedWriter out = new BufferedWriter(f);
		out.write(txt);
		out.close();
	}		
	
	public Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
        return DriverManager.getConnection(url,user,password); 
	}
	
	public void close(Connection con) throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
	
	public void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}
	
	public void close(Statement stm) throws SQLException {
		if (stm != null) {
			stm.close();
			stm = null;
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
