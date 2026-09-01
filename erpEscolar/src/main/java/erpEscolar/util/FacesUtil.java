package erpEscolar.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {
	public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    // --- Mensagens da Tela ---
    public static void addInfoMessage(String mensagem) {
        addMessage(FacesMessage.SEVERITY_INFO, mensagem);
    }

    public static void addErrorMessage(String mensagem) {
        addMessage(FacesMessage.SEVERITY_ERROR, mensagem);
    }

    public static void addWarnMessage(String mensagem) {
        addMessage(FacesMessage.SEVERITY_WARN, mensagem);
    }

    private static void addMessage(FacesMessage.Severity severity, String mensagem) {
        getFacesContext().addMessage(null, new FacesMessage(severity, mensagem, mensagem));
    }

    // --- Redirecionamento ---
    public static void redirect(String page) {
        try {
            getExternalContext().redirect(getExternalContext().getRequestContextPath() + page);
        } catch (Exception e) {
            addErrorMessage("Erro ao redirecionar para a página: " + page);
        }
    }

}
