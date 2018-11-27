package br.com.theodoro.avaliacao.framework.model;

import java.time.LocalDateTime;

import br.com.theodoro.avaliacao.acesso.model.User;

public interface Audit<T extends BaseEntity> {
	T addInsertAudit();
	T addEditAudit();
	T addDeleteAudit();
	
	LocalDateTime getUltimaAlteracao();
	void setUltimaAlteracao(LocalDateTime ultimaAlteracao);
	
	User getUsuario();
	void setUsuario(User usuario) ;
	
	void setDeleted(boolean val);
}
