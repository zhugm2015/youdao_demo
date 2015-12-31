package com.bdc.dao;

import com.bdc.model.Word;

/**
 * Created by Administrator on 2015/12/27.
 */
public interface WordDao extends GenericDao<Word, Integer> {
    Word queryWordByEnglish(String english);
}
