package com.bdc.service.impl;

import com.bdc.dao.GenericDao;
import com.bdc.dao.WordDao;
import com.bdc.model.Word;
import com.bdc.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/27.
 */
@Service
public class WordServiceImpl extends GenericServiceImpl<Word, Integer> implements WordService {
    @Override
    @Autowired
    @Qualifier("wordDaoImpl")
    protected void setGenericDao(GenericDao<Word, Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public Word queryWordByEnglish(String english) {
        return ((WordDao)genericDao).queryWordByEnglish(english);
    }
}
