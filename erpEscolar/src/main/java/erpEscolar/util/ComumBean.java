package erpEscolar.util;

import java.io.Serializable;

public abstract class ComumBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Acesso facilitado aos utilitários do JSF
    protected FacesUtil getFacesUtil() {
        return new FacesUtil();
    }

    // Métodos diretos de mensagem para conveniência
    protected void info(String mensagem) {
        FacesUtil.addInfoMessage(mensagem);
    }

    protected void erro(String mensagem) {
        FacesUtil.addErrorMessage(mensagem);
    }

    protected void aviso(String mensagem) {
        FacesUtil.addWarnMessage(mensagem);
    }

    // Método hook para ser sobrescrito se necessário inicializar dados na tela
    public void init() {
    }

}
