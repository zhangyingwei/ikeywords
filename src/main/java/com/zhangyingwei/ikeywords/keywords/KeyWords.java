package com.zhangyingwei.ikeywords.keywords;

import com.zhangyingwei.ikeywords.ansj.KeyWordComputer;
import com.zhangyingwei.ikeywords.common.CommParams;
import org.ansj.app.keyword.Keyword;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangyw on 2016/9/6.
 */
public class KeyWords {
    private Set<String> keyWordSet;
    private Set<String> titleWordSet;
    private Set<String> contentWordSet;
    private KeyWordComputer titleComputer = new KeyWordComputer(CommParams.KEYWORD_TITLE_SIZE);
    private KeyWordComputer contentComputer = new KeyWordComputer(CommParams.KEYWORD_CONTENT_SIZE);

    public Set<String> getKeyWordSet() {
        this.keyWordSet.addAll(this.titleWordSet);
        this.keyWordSet.addAll(this.contentWordSet);
        return keyWordSet;
    }
    public Set<String> getTitleWordSet() {
        return titleWordSet;
    }

    public Set<String> getContentWordSet() {
        return contentWordSet;
    }

    private void init(){
        if(this.keyWordSet==null){
            this.keyWordSet  = new HashSet<String>();
        }else{
            this.keyWordSet.clear();
        }
        if(this.titleWordSet==null){
            this.titleWordSet = new HashSet<String>();
        }else{
            this.titleWordSet.clear();
        }
        if(this.contentWordSet==null){
            this.contentWordSet = new HashSet<String>();
        }else{
            this.contentWordSet.clear();
        }
    }

    public KeyWords cut(String title, String content){
        this.init();
        List<Keyword> listContent = contentComputer.computeArticleTfidf(title, content);
        List<Keyword> listTitle = titleComputer.computeArticleTfidf(title);
        for(Keyword k:listContent){
            this.contentWordSet.add(k.getName());
        }
        for(Keyword k:listTitle) {
            this.titleWordSet.add(k.getName());
        }
        return this;
    }


}
