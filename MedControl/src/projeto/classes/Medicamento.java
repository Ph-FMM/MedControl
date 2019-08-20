package projeto.classes;

public class Medicamento {
	private int qntd;
	private char tp_prod;
	private String nome_comum,nome_comerc,
				   nome_fabric,validade,
				   desc_prod,data_update;
	
	public Medicamento() {
		
	}
	
	//CRUD
	public void createMedicamento() {
		
	}
	
	public void readMedicamento() {
		
	}

	public void updateMedicamento() {
	
	}

	public void deleteMedicamento() {
	
	}
	
	//setter n getters
	public String getNome_comum() {
		return nome_comum;
	}

	public void setNome_comum(String nome_comum) {
		this.nome_comum = nome_comum;
	}

	public String getNome_comerc() {
		return nome_comerc;
	}

	public void setNome_comerc(String nome_comerc) {
		this.nome_comerc = nome_comerc;
	}

	public String getNome_fabric() {
		return nome_fabric;
	}

	public void setNome_fabric(String nome_fabric) {
		this.nome_fabric = nome_fabric;
	}

	public int getQntd() {
		return qntd;
	}

	public void setQntd(int qntd) {
		this.qntd = qntd;
	}

	public char getTp_prod() {
		return tp_prod;
	}

	public void setTp_prod(char tp_prod) {
		this.tp_prod = tp_prod;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getDesc_prod() {
		return desc_prod;
	}

	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public String getData_update() {
		return data_update;
	}

	public void setData_update(String data_update) {
		this.data_update = data_update;
	}
	
	
}
