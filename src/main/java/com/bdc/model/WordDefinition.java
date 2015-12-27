package com.bdc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2015/12/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WordDefinition extends BaseModel {
    private Integer id;
    private String partOfSpeech;
    private String chinese;
    private Integer wordId;
}
