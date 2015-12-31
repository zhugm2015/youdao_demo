package com.bdc.controller;

import com.bdc.model.Word;
import com.bdc.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2015/12/27.
 */
@Controller
@RequestMapping("/word")
public class WordController extends BaseController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/queryWordByEnglish")
    private String queryWordByEnglish(@RequestParam String english) {
        Word word = wordService.queryWordByEnglish(english);
        getSession().setAttribute("word", word);
        return "index";
    }
}
