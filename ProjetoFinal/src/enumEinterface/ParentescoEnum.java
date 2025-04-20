package enumEinterface;

public enum ParentescoEnum {

	FILHO(189.59),      
    SOBRINHO(189.59),   
    OUTROS(189.59);     

	//Declaracao atributo
    private double desconto; 

    // Construtor
    private ParentescoEnum(double desconto) {
        this.desconto = desconto;
    }

    // Método
    public double getDesconto() {
        return desconto;
    }

	
}
