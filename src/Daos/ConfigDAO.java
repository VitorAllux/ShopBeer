package Daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.ConfigModel;
import Models.ProdutoModel;

public class ConfigDAO extends BaseDAO{

	public ConfigDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public ConfigModel getConfig(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("config")
				.where("id", "=", id.toString())
				.apply();

		if(result.next()) {
			ConfigModel config = new ConfigModel().setId(result.getInt("id")).setNomeBanco(result.getString("nomeBanco"))
					.setPgDump(result.getString("pgDump")).setPgRestore(result.getString("pgRestore"))
					.setIpBanco(result.getString("ipBanco")).setPortaBanco(result.getString("portaBanco"))
					.setSenhaBanco(result.getString("senhaBanco")).setUserBanco(result.getString("userBanco"));
			return config;
		}else {
			return null;
		}
	}
	
	public void createConfig() throws SQLException {
		this.insertInto("config",
				"id, nomeBanco, pgDump, pgRestore, ipBanco, senhaBanco, portaBanco, userBanco")
		.values("0"+
				", "+quoteStr(" ") +
				", "+quoteStr(" ") +
				", " + quoteStr(" ") +
				", " + quoteStr(" ") +
				", " + quoteStr(" ") +
				", " +quoteStr(" ") +
				", " + quoteStr(" ")) 
		.commit();
	}
	
	public void updateConfig(ConfigModel config) throws SQLException {
		this.update("config")
		.setValue(
				", id = " + "0" +
				" nomeBanco = " + quoteStr(config.getNomeBanco())+
				" pgDump = " + quoteStr(config.getPgDump())+
				" pgRestore = " + quoteStr(config.getPgRestore())+
				" ipBanco = " + quoteStr(config.getIpBanco())+
				" senhaBanco = " + quoteStr(config.getSenhaBanco())+
				" portaBanco = " + quoteStr(config.getPortaBanco())+
				", userBanco = " + quoteStr(config.getUserBanco())
				)
		.where("id", "=", Integer.toString((config.getId())))
		.commit();
	}
	
}
