package de.dfg.demo.blog.dao;

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
    }
}