package com.deutsche.Worterbuch.mapper;

import com.deutsche.Worterbuch.model.Wort;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WordMapper {
    @Select("SELECT * FROM WORDS")
    Wort[] selectWords();

    @Insert("INSERT INTO WORDS VALUES(#{word},#{meaning})")
    int insertWord(Wort wort);
}
