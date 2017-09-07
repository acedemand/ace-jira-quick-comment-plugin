package com.acedemand.service;

import com.acedemand.api.QuickComment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pamir on 3/30/2017.
 */
@Component
@Named
public class QuickCommentService {
    public Collection<QuickComment> findAll() {
        try {
            Gson gson = new Gson();
            return gson.fromJson(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("comment.json"), "UTF-8"), new TypeToken<List<QuickComment>>() {
            }.getType());
        }catch (UnsupportedEncodingException e){
            System.out.println("e = " + e);
        }
        return Collections.EMPTY_LIST;
    }
}
