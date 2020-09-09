package de.dfg.demo.blog.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

 

import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;


import de.dfg.demo.blog.bo.BlogBO;
import de.dfg.demo.blog.dao.entity.BlogEntity;
import de.dfg.demo.blog.dao.mapper.BlogMapper;

 

/**

* The Class SuchFavoritDaoJPAImpl.

*/

@Stateless

public class BlogDaoJPAImpl implements BlogDao {


    /**
     * The entity manager.
     */

    @PersistenceContext

    private EntityManager entityManager;


    @Override
    public List<BlogBO> findAllBlogs() {
        TypedQuery<BlogEntity> query = entityManager.createNamedQuery(BlogEntity.QUERY_BY_ALL, BlogEntity.class);
        List<BlogEntity> list = query.getResultList();
        List<BlogBO> bos = new ArrayList<>();
        for(BlogEntity e:list) {
            bos.add(BlogMapper.mapEntityToBO(e));
        }
        return bos;
    }

    @Override
    public void addBlog(BlogBO bo) {
        BlogEntity e = BlogMapper.mapBOToEntity(bo);
        entityManager.merge(e);
    }

    @Override
    public BlogBO getBlogByID(Long id) {
        TypedQuery<BlogEntity> query = entityManager.createNamedQuery(BlogEntity.QUERY_BY_ID, BlogEntity.class);
        query.setParameter(BlogEntity.QUERY_PARAMETER_ID, id);
        return BlogMapper.mapEntityToBO(query.getSingleResult());
    }

    @Override
    public List<BlogBO> findBlogByDate(LocalDate date) {
        TypedQuery<BlogEntity> query = entityManager.createNamedQuery(BlogEntity.QUERY_BY_DATE, BlogEntity.class);
        query.setParameter(BlogEntity.QUERY_PARAMETER_DATE, date);
        query.setMaxResults(100);
        List<BlogEntity> entities = query.getResultList();
        List<BlogBO> bos = new ArrayList<>();
        for(BlogEntity e:entities) {
            bos.add(BlogMapper.mapEntityToBO(e));
        }
        return bos;
    }

    @Override
    public void deleteBlog(Long id) {
        BlogEntity entity = entityManager.find(BlogEntity.class, id);
        entityManager.remove(entity);
    }
}