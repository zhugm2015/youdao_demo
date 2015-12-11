DROP DATABASE IF EXISTS bcd;
CREATE DATABASE bcd;

DROP TABLE IF EXISTS bdc.word;
CREATE TABLE bcd.word(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  english VARCHAR(255),
  phonetic_uk VARCHAR(255) COMMENT '英式音标',
  phonetic_us VARCHAR(255) COMMENT '美式音标',
  audio_uk_male VARCHAR(255) COMMENT '英式男生版读音',
  audio_uk_female VARCHAR(255) COMMENT '英式女生版读音',
  audio_us_male VARCHAR(255),
  audio_us_female VARCHAR(255)
);

DROP TABLE IF EXISTS bcd.word_definition;
CREATE TABLE bcd.word_definition(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  part_of_speech VARCHAR(255) COMMENT '词性',
  chinese VARCHAR(255) COMMENT '词意',
  word_id INT(11) UNSIGNED
)COMMENT '词性表';

DROP TABLE IF EXISTS bcd.word_sentence;
CREATE TABLE bcd.word_sentence(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  english VARCHAR(255) COMMENT '英语例句',
  chinese VARCHAR(255) COMMENT '中文翻译',
  source VARCHAR(255),
  audio_male VARCHAR(255),
  audio_female VARCHAR(255),
  word_id INT(11) UNSIGNED
)COMMENT '例句表';

DROP TABLE IF EXISTS bcd.morpheme;
CREATE TABLE bcd.morpheme(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  english VARCHAR(255),
  type VARCHAR(255) COMMENT '类型：root,prefix,infix,suffix'
)COMMENT '词素表';

DROP TABLE IF EXISTS bcd.morpheme_definition;
CREATE TABLE bcd.morpheme_definition(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  part_of_speech VARCHAR(255) COMMENT '词性',
  chinese VARCHAR(255),
  morpheme_id INT(11) UNSIGNED
)COMMENT '词素定义表';

DROP TABLE IF EXISTS bcd.word_morpheme;
CREATE TABLE bcd.word_morpheme(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  word_id INT(11) UNSIGNED,
  morpheme_id INT(11) UNSIGNED
) COMMENT '单词词素关联表';

ALTER TABLE bcd.word_definition ADD CONSTRAINT fk_word_definition_word_id FOREIGN KEY (word_id)REFERENCES bcd.word(id);
ALTER TABLE bcd.word_sentence ADD CONSTRAINT fk_word_sentence_word_id FOREIGN KEY (word_id)REFERENCES bcd.word(id);
ALTER TABLE bcd.word_morpheme ADD CONSTRAINT fk_word_morpheme_word_id FOREIGN KEY (word_id)REFERENCES bcd.word(id);
ALTER TABLE bcd.word_morpheme ADD CONSTRAINT fk_word_morpheme_morpheme_id FOREIGN KEY (morpheme_id)REFERENCES bcd.morpheme(id);
ALTER TABLE bcd.morpheme_definition ADD CONSTRAINT fk_morpheme_definition_morpheme_id FOREIGN KEY (morpheme_id) REFERENCES bcd.morpheme(id);
