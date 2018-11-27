package br.com.theodoro.avaliacao.framework.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import br.com.theodoro.avaliacao.acesso.model.User;
import br.com.theodoro.avaliacao.framework.exception.BusinessException;
import br.com.theodoro.avaliacao.framework.model.Audit;
import br.com.theodoro.avaliacao.framework.model.BaseEntity;
import br.com.theodoro.avaliacao.framework.model.FakeDeleted;

@Transactional(rollbackOn = BusinessException.class)
public abstract class AbstractService<T extends BaseEntity & Audit<E> & FakeDeleted, E extends BaseEntity> {

	protected AbstractService() {
		super();
	}

	public T add(T entity) throws BusinessException {

		validate(entity);

		if (entity.getId() != null) {
			throw new BusinessException("Entidade não pode ter a propriedade id na inclusão.");
		}

		applyAddChanges(entity);

		save(entity);

		saveAudit(entity.addInsertAudit());

		T retorno = save(entity);
		return retorno;
	}

	public T update(T entity) throws BusinessException {
		validate(entity);

		ensureExist(entity);

		entity.setUltimaAlteracao(LocalDateTime.now());

		T managed = save(entity);

		E historico = managed.addEditAudit();

		saveAudit(historico);

		return managed;
	}

	public T delete(long id, User usuario) throws BusinessException {
		T managed = ensureExist(id);

		managed.setUsuario(usuario);
		managed.setUltimaAlteracao(LocalDateTime.now());
		managed.setDeleted(true);

		save(managed);

		E historico = managed.addDeleteAudit();

		saveAudit(historico);

		return managed;
	}

	public T get(Long id) {
		return findOne(id);
	}

	private void ensureExist(T entity) throws BusinessException {

		if (entity.getId() == null) {
			throw new BusinessException("Id  não informado");
		}

		ensureExist(entity.getId());
	}

	private T ensureExist(Long id) throws BusinessException {

		T managed = findOne(id);
		if (managed == null) {
			throw new BusinessException("Entidade não existe");
		}

		if (managed.isDeleted()) {
			throw new BusinessException("Entidade está apagada");
		}

		return managed;
	}

	protected void applyAddChanges(T entity) {
		entity.setUltimaAlteracao(LocalDateTime.now());
	}

	protected abstract void validate(T entity) throws BusinessException;

	protected abstract T save(T entity);

	protected abstract void saveAudit(E auditEntity);

	protected abstract T findOne(Long id);

}