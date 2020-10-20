package Models;

public class ConfigModel {
	private String pgDump;
	private String pgRestore;
	private String nomeBanco;
	private String senhaBanco;
	private String userBanco;
	private String ipBanco;
	private String portaBanco;
	private String autoBackup;
	private int id;

	public ConfigModel() {

		this.pgDump = "";
		this.pgRestore = "";
		this.nomeBanco = "";
		this.senhaBanco = "";
		this.userBanco = "";
		this.ipBanco = "";
		this.portaBanco = "";
		this.autoBackup = "";
		this.id = 0;
	}

	public ConfigModel(ConfigModel config) {
		this.id = config.getId();
		this.pgDump = config.getPgDump();
		this.pgRestore = config.pgRestore;
		this.nomeBanco = config.nomeBanco;
		this.senhaBanco = config.senhaBanco;
		this.userBanco = config.userBanco;
		this.ipBanco = config.ipBanco;
		this.portaBanco = config.portaBanco;
		this.autoBackup = config.autoBackup;
	}

	public String getPgDump() {
		return pgDump;
	}

	public ConfigModel setPgDump(String pgDump) {
		this.pgDump = pgDump;
		return this;
	}
	
	public String getAutoBackup() {
		return autoBackup;
	}

	public ConfigModel setAutoBackup(String autoBackup) {
		this.autoBackup = autoBackup;
		return this;
	}

	public String getPgRestore() {
		return pgRestore;
	}

	public ConfigModel setPgRestore(String pgRestore) {
		this.pgRestore = pgRestore;
		return this;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public ConfigModel setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
		return this;
	}

	public String getSenhaBanco() {
		return senhaBanco;
	}

	public ConfigModel setSenhaBanco(String senhaBanco) {
		this.senhaBanco = senhaBanco;
		return this;
	}

	public String getUserBanco() {
		return userBanco;
	}

	public ConfigModel setUserBanco(String userBanco) {
		this.userBanco = userBanco;
		return this;
	}

	public String getIpBanco() {
		return ipBanco;
	}

	public ConfigModel setIpBanco(String ipBanco) {
		this.ipBanco = ipBanco;
		return this;
	}

	public String getPortaBanco() {
		return portaBanco;
	}

	public ConfigModel setPortaBanco(String portaBanco) {
		this.portaBanco = portaBanco;
		return this;
	}

	public int getId() {
		return id;
	}

	public ConfigModel setId(int id) {
		this.id = id;
		return this;
	}

}
