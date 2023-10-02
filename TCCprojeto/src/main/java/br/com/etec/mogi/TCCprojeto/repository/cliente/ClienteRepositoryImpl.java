package br.com.etec.mogi.TCCprojeto.repository.cliente;

import br.com.etec.mogi.TCCprojeto.model.Cliente;
import br.com.etec.mogi.TCCprojeto.repository.filter.ClienteFilter;
import br.com.etec.mogi.TCCprojeto.repository.projections.ClienteDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {
  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<ClienteDTO> Filtrar(ClienteFilter clienteFilter, Pageable pageable){

    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<ClienteDTO> criteria = builder.createQuery(ClienteDTO.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    criteria.select(builder.construct(ClienteDTO.class
      ,root.get("id")
      ,root.get("nomecliente")
      ,root.get("endereco")
      ,root.get("cidade").get("nomecidade")
      ,root.get("animal").get("nomeanimal")
    ));
    Predicate[] predicates =CriarRestricoes(clienteFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomecliente")));

    TypedQuery<ClienteDTO> query = manager.createQuery(criteria);
    adicionarRestricoesDePaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(clienteFilter));
  }
  private Predicate[] CriarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
    List<Predicate> predicates = new ArrayList<>();

    if(!StringUtils.isEmpty(clienteFilter.getNomecliente())) {
      predicates.add(builder.like(builder.lower(root.get("nomecliente")),
        "%" + clienteFilter.getNomecliente().toLowerCase() + "%"));
    }

    if (!StringUtils.isEmpty(clienteFilter.getEndereco())){
      predicates.add(builder.like(builder.lower(root.get("endereco")),
        "%" + clienteFilter.getEndereco().toLowerCase()+ "%"));
    }
    if (!StringUtils.isEmpty(clienteFilter.getEndereco())){
      predicates.add(builder.like(builder.lower(root.get("cidade").get("nomecidade")),
        clienteFilter.getNomecliente().toLowerCase()));
    }
    if (!StringUtils.isEmpty(clienteFilter.getNomeanimal())){
      predicates.add(builder.like(builder.lower(root.get("animal").get("nomeanimal")),
        clienteFilter.getNomeanimal().toLowerCase()));
    }
    return predicates.toArray(new Predicate[predicates.size()]);
  }

  private void adicionarRestricoesDePaginacao(TypedQuery<ClienteDTO> query, Pageable pageable) {
    int paginaAtual = pageable.getPageNumber();
    int totalRegistrosPorDia = pageable.getPageSize();
    int primeiroRegistrosPorPagina = paginaAtual * totalRegistrosPorDia;

    query.setFirstResult(primeiroRegistrosPorPagina);
    query.setMaxResults(totalRegistrosPorDia);
  }

  private Long total(ClienteFilter clienteFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Cliente> root = criteria.from(Cliente.class);

    Predicate[] predicates = CriarRestricoes(clienteFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomecliente")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }


}
