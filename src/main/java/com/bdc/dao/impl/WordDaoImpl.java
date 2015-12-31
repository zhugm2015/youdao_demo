package com.bdc.dao.impl;

import com.bdc.dao.WordDao;
import com.bdc.model.Word;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2015/12/27.
 */
@Repository
public class WordDaoImpl extends GenericDaoImpl<Word, Integer> implements WordDao {
    @Override
    public Word queryWordByEnglish(String english) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        Word word = sqlSession.selectOne("word.queryWordByEnglish", english);
        sqlSession.close();
        return word;
    }
}
