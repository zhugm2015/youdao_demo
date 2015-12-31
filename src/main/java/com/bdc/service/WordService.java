package com.bdc.service;

import com.bdc.model.Word;

/**
 * Created by Administrator on 2015/12/27.
 */
public interface WordService extends GenericService<Word, Integer> {
    Word queryWordByEnglish(String english);
}
