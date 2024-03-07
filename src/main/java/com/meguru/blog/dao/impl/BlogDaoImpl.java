package com.meguru.blog.dao.impl;

import com.meguru.blog.dao.BaseDao;
import com.meguru.blog.dao.BlogDao;
import com.meguru.blog.pojo.Blog;

import java.util.List;

public class BlogDaoImpl extends BaseDao implements BlogDao {
    @Override
    public List<Blog> findRecentByNumber(int num) {
        String sql="""
                select id bid,title,content,author_id uid,view viewNumber,
                create_time createTime,update_time updateTime 
                from blog_posts order by create_time desc limit ?
                """;
        List<Blog> blogList = baseQuery(Blog.class, sql, num);
        return blogList!=null && !blogList.isEmpty()?blogList:null;
    }


    @Override
    public List<Blog> findAll() {
        String sql="""
                select id bid,title,content,author_id uid,view viewNumber,
                create_time createTime,update_time updateTime 
                from blog_posts
                """;
        List<Blog> blogList = baseQuery(Blog.class, sql);
        return blogList!=null && !blogList.isEmpty()?blogList:null;
    }

    @Override
    public int addBlog(Blog blog) {
        String sql="""
                insert into blog_posts values (DEFAULT,?,?,?,0,now(),now())
                """;
        return baseUpdate(sql,
                blog.getTitle(),
                blog.getContent(),
                blog.getUid()
        );
    }

    @Override
    public int increaseViewNumber(int bid) {
        String sql="""
                update blog_posts set view = view + 1 where id = ?
                """;
        return baseUpdate(sql, bid);
    }

    @Override
    public Blog findBlogById(int bid) {
        String sql="""
                select id bid,title,content,author_id uid,view viewNumber,
                create_time createTime,update_time updateTime 
                from blog_posts where id = ?
                """;
        List<Blog> blogList = baseQuery(Blog.class, sql, bid);
        return blogList!=null && !blogList.isEmpty()?blogList.getFirst():null;
    }

    @Override
    public int updateBlog(Blog blog) {
        String sql="""
                update blog_posts set title = ?,content = ?,update_time = now() where id = ?
                """;
        return baseUpdate(sql,
                blog.getTitle(),
                blog.getContent(),
                blog.getBid()
        );
    }

    @Override
    public int deleteBlog(int bid) {
        String sql="""
                delete from blog_posts where id = ?
                """;
        return baseUpdate(sql, bid);
    }
}
