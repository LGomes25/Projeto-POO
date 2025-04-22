package enumEinterface;

public enum ParentescoEnum {

	FILHO(189.59),      
    SOBRINHO(189.59),   
    OUTROS(189.59);     

	//Declaracao atributo
    private Double desconto; 

    // Construtor
    private ParentescoEnum(Double desconto) {
        this.desconto = desconto;
    }

    // Método
    public Double getDesconto() {
        return desconto;
    }

	
}
