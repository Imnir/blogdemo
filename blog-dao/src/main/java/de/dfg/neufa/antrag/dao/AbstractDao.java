/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-dao
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.antrag.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.dfg.neufa.DFGLogging;
import de.dfg.neufa.DFGLoggingUtil;
import de.dfg.neufa.antrag.bo.FilterItem;
import de.dfg.neufa.antrag.bo.SortItem;


/**
 * The Class AbstractDao.
 *
 * @param <T> the generic type
 * @param <V> the value type
 */
public abstract class AbstractDao<T, V> {

	/** The Constant PERFORMANCE. */
	private static final Logger PERFORMANCE = DFGLogging.getPerformanceLogger(AbstractDao.class);


	/** The entity manager. */
	@PersistenceContext(unitName="neufa-antrag-persistence-unit")
	private EntityManager entityManager;
	

    /** The entity class. */
    private final Class<T> entityClass;
    
    /** The business class. */
    private final Class<V> businessClass;

	/**
	 * Instantiates a new AbstractDao.
	 */
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entityClass = (Class<T>) pt.getActualTypeArguments()[0];
		businessClass = (Class<V>) pt.getActualTypeArguments()[1];

	}

	/**
	 * Find all.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return the list
	 */
	protected List<T> findAll(int offset, int limit) {
		final StringBuilder queryString = new StringBuilder("SELECT o FROM ");
		queryString.append(entityClass.getSimpleName()).append(" o ");
		final TypedQuery<T> query = this.getEntityManager().createQuery(queryString.toString(), entityClass);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}

	/**
	 * Count all.
	 *
	 * @return the int
	 */
	protected int countAll() {
		final StringBuilder queryString = new StringBuilder("SELECT COUNT(o) FROM ");
		queryString.append(entityClass.getSimpleName()).append(" o ");
		final TypedQuery<T> query = this.getEntityManager().createQuery(queryString.toString(), entityClass);
		return ((Long) query.getSingleResult()).intValue();
	}

	/**
	 * Persist.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	protected T persist(final T entity) {
		this.getEntityManager().persist(entity);
		this.getEntityManager().flush();
		return entity;
	}

	/**
	 * Flush.
	 */
	protected void flush() {
		this.getEntityManager().flush();
	}

	/**
	 * Merge.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	protected T merge(final T entity) {
		T t = this.getEntityManager().merge(entity);
		this.getEntityManager().flush();
		return t;
	}

	/**
	 * Removes the.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	protected T remove(final T entity) {
		this.getEntityManager().remove(this.merge(entity));
		flush();
		return entity;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	protected T findById(final Object id) {
		return getEntityManager().find(entityClass, id);
	}

	/**
	 * Gets the reference.
	 *
	 * @param id the id
	 * @return the reference
	 */
	protected T getReference(final Object id) {
		return this.getEntityManager().getReference(entityClass, id);

	}

	/**
	 * Find by my id.
	 *
	 * @param id the id
	 * @return the t
	 */
	protected T findByMyId(final Object id) {
		final StringBuilder queryString = new StringBuilder("SELECT o from ");
		queryString.append(entityClass.getSimpleName()).append(" o where o.id= :id");
		final TypedQuery<T> query = this.getEntityManager().createQuery(queryString.toString(), entityClass);
		query.setParameter("id", id);
		List<T> list = query.getResultList();
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * Gets the find all query.
	 *
	 * @return the find all query
	 */
	protected TypedQuery<T> getFindAllQuery() {
		final StringBuilder queryString = new StringBuilder("SELECT o from ");
		queryString.append(entityClass.getSimpleName()).append(" o ");
		return this.getEntityManager().createQuery(queryString.toString(), entityClass);

	}


	/**
	 * Gets the entity manager.
	 *
	 * @return the entity manager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Sets the entity manager.
	 *
	 * @param entityManager the new entity manager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	/**
	 * Gets the criteria builder.
	 *
	 * @return the criteria builder
	 */
	protected CriteriaBuilder getCriteriaBuilder() {
		return this.getEntityManager().getCriteriaBuilder();
	}


	/**
	 * Load and map entities.
	 *
	 * @param query the query
	 * @param mapper the mapper
	 * @return the list
	 */
	protected List<V> loadAndMapEntities(TypedQuery<T> query, Function<T,V> mapper) {
		DFGLoggingUtil util = new DFGLoggingUtil();
		Stream<T> resultStream = query.getResultStream();
		Long dbLoadTime = util.getDurationInMS();
		List<V> result = resultStream.map(mapper).collect(Collectors.toList());
		String msg = String.format("AbstractGenericDao.loadAndMapEntities: mapped %1s -> %2s - mapped %3d entities in %4d ms (loaded in %5d ms)", entityClass.getSimpleName(),businessClass.getSimpleName(),result.size(),util.getDurationInMS(),dbLoadTime);
		PERFORMANCE.log(Level.INFO, msg);
		return result;
	}

	/**
	 * Map entities.
	 *
	 * @param resultStream the result stream
	 * @param mapper the mapper
	 * @return the list
	 */
	protected List<V> mapEntities(Stream<T> resultStream, Function<T,V> mapper) {
		DFGLoggingUtil util = new DFGLoggingUtil();
		List<V> result = resultStream.map(mapper).collect(Collectors.toList());
		String msg = String.format("AbstractGenericDao.mapEntities: mapped %1s -> %2s - mapped %3d entities in %4d ms", entityClass.getSimpleName(),businessClass.getSimpleName(),result.size(),util.getDurationInMS());
		PERFORMANCE.log(Level.INFO, msg);
		return result;
	}
	
	/**
	 * Count all entities.
	 *
	 * @param filterItems the filter items
	 * @return the int
	 */
	protected int countAllEntities(List<FilterItem> filterItems) {
		CriteriaQuery<Long> criteriaQuery = this.getCriteriaBuilder().createQuery(Long.class);
		Root<T> root = criteriaQuery.from(entityClass);

		criteriaQuery.select(this.getCriteriaBuilder().count(root));
		criteriaQuery.where(this.generatePredicate(filterItems, root));

		return this.getEntityManager().createQuery(criteriaQuery).getSingleResult().intValue();
	}

	/**
	 * Find all entities.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @param sortItems the sort items
	 * @param filterItems the filter items
	 * @return the list
	 */
	protected List<T> findAllEntities(int offset, int limit, List<SortItem>sortItems, List<FilterItem>filterItems){
		CriteriaQuery<T> criteriaQuery = this.getCriteriaBuilder().createQuery(entityClass);
		Root<T> root = criteriaQuery.from(entityClass);

		criteriaQuery.orderBy(this.generateSortOrderList(sortItems, root));
		criteriaQuery.where(this.generatePredicate(filterItems, root));

		TypedQuery<T> query = this.getEntityManager().createQuery(criteriaQuery);
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();
	}
	
	/**
	 * Generate predicate.
	 *
	 * @param filterItems the filter items
	 * @param root the root
	 * @return the predicate
	 */
	protected Predicate generatePredicate(List<FilterItem>filterItems, Root<T> root ){
		final List<Predicate> predicates = new ArrayList<>();
		if (filterItems!=null){
			filterItems.forEach(filterItem->{

				if(filterItem.getTyp().equals(FilterItem.TYP.EQUAL_CASE_SENSITIV)){
					predicates
							.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder().equal(root.get(filterItem.getName()), filterItem.getFilterValue1())));
				}
				if(filterItem.getTyp().equals(FilterItem.TYP.NOT_EQUAL_CASE_SENSITIV)){
					predicates.add(
							this.getCriteriaBuilder().and(this.getCriteriaBuilder().notEqual(root.get(filterItem.getName()), filterItem.getFilterValue1())));
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.EQUAL_CASE_INSENSITIV)){
					predicates.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder()
							.equal(this.getCriteriaBuilder().lower(root.get(filterItem.getName())), filterItem.getFilterValue1().toString().toLowerCase())));
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.NOT_EQUAL_CASE_INSENSITIV)){
					predicates.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder()
							.notEqual(this.getCriteriaBuilder().lower(root.get(filterItem.getName())), filterItem.getFilterValue1().toString().toLowerCase())));
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.LIKE_CASE_SENSITIV)){
					predicates.add(this.getCriteriaBuilder()
							.and(this.getCriteriaBuilder().like(root.get(filterItem.getName()), "%" + filterItem.getFilterValue1() + "%")));
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.LIKE_CASE_INSENSITIV)){
					predicates.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder().like(this.getCriteriaBuilder().lower(root.get(filterItem.getName())),
							"%" + filterItem.getFilterValue1().toString().toLowerCase() + "%")));
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.GREATER_THAN)){
					if(filterItem.getFilterValue1() instanceof Double){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().greaterThan(root.get(filterItem.getName()), (Double) filterItem.getFilterValue1())));
					}
					else if(filterItem.getFilterValue1() instanceof LocalDate){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().greaterThan(root.get(filterItem.getName()), (LocalDate) filterItem.getFilterValue1())));
					}
					else if(filterItem.getFilterValue1() instanceof LocalDateTime){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().greaterThan(root.get(filterItem.getName()), (LocalDateTime) filterItem.getFilterValue1())));
					}
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.GREATER_THAN_OR_EQUAL_TO)){
					if(filterItem.getFilterValue1() instanceof Double){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().greaterThanOrEqualTo(root.get(filterItem.getName()), (Double) filterItem.getFilterValue1())));
					}
					else if(filterItem.getFilterValue1() instanceof LocalDate){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().greaterThanOrEqualTo(root.get(filterItem.getName()), (LocalDate) filterItem.getFilterValue1())));
					}
					else if(filterItem.getFilterValue1() instanceof LocalDateTime){
						predicates.add(this.getCriteriaBuilder().and(
								this.getCriteriaBuilder().greaterThanOrEqualTo(root.get(filterItem.getName()), (LocalDateTime) filterItem.getFilterValue1())));
					}
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.LOWER_THAN)){
					if(filterItem.getFilterValue2() instanceof Double){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().lessThan(root.get(filterItem.getName()), (Double) filterItem.getFilterValue2())));
					}
					else if(filterItem.getFilterValue2() instanceof LocalDate){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().lessThan(root.get(filterItem.getName()), (LocalDate) filterItem.getFilterValue2())));
					}
					else if(filterItem.getFilterValue2() instanceof LocalDateTime){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().lessThan(root.get(filterItem.getName()), (LocalDateTime) filterItem.getFilterValue2())));
					}
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.LOWER_THAN_OR_EQUAL_TO)){
					if(filterItem.getFilterValue2() instanceof Double){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().lessThanOrEqualTo(root.get(filterItem.getName()), (Double) filterItem.getFilterValue2())));
					}
					else if(filterItem.getFilterValue2() instanceof LocalDate){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().lessThanOrEqualTo(root.get(filterItem.getName()), (LocalDate) filterItem.getFilterValue2())));
					}
					else if(filterItem.getFilterValue2() instanceof LocalDateTime){
						predicates.add(this.getCriteriaBuilder().and(
								this.getCriteriaBuilder().lessThanOrEqualTo(root.get(filterItem.getName()), (LocalDateTime) filterItem.getFilterValue2())));
					}
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.BETWEEN)){
					if(filterItem.getFilterValue1() instanceof Double && filterItem.getFilterValue2() instanceof Double){
						predicates.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder().between(root.get(filterItem.getName()),
								(Double) filterItem.getFilterValue1(), (Double) filterItem.getFilterValue2())));
					}
					else if(filterItem.getFilterValue1() instanceof LocalDate && filterItem.getFilterValue2() instanceof LocalDate){
						predicates.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder().between(root.get(filterItem.getName()),
								(LocalDate) filterItem.getFilterValue1(), (LocalDate) filterItem.getFilterValue2())));
					}
					else if(filterItem.getFilterValue1() instanceof LocalDateTime && filterItem.getFilterValue2() instanceof LocalDateTime){
						predicates.add(this.getCriteriaBuilder().and(this.getCriteriaBuilder().between(root.get(filterItem.getName()),
								(LocalDateTime) filterItem.getFilterValue1(), (LocalDateTime) filterItem.getFilterValue2())));
					}
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.IN)){
					if(filterItem.getFilterValue1() instanceof List){
						predicates.add(this.getCriteriaBuilder().and(root.get(filterItem.getName()).in((List<?>) filterItem.getFilterValue1())));
					}
				}
				else if(filterItem.getTyp().equals(FilterItem.TYP.NOT_IN)){
					if(filterItem.getFilterValue1() instanceof List){
						predicates.add(this.getCriteriaBuilder()
								.and(this.getCriteriaBuilder().not(root.get(filterItem.getName()).in((List<?>) filterItem.getFilterValue1()))));
					}
				}

			});
		}
		return this.getCriteriaBuilder().and(predicates.toArray(new Predicate[predicates.size()]));
	}

	/**
	 * Generate sort order list.
	 *
	 * @param sortItems the sort items
	 * @param root the root
	 * @return the list
	 */
	protected List<Order> generateSortOrderList(List<SortItem> sortItems, Root<T> root ){
		List<Order> orderList = new ArrayList<>();
		sortItems.forEach(sortItem->{
			if(sortItem.isAsc()){
				orderList.add(this.getCriteriaBuilder().asc(root.get(sortItem.getName())));
			}
			else{
				orderList.add(this.getCriteriaBuilder().desc(root.get(sortItem.getName())));
			}
		});
		return orderList;
	}


}