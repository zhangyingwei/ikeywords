package com.zhangyingwei.ikeywords.ansj.valid;

import com.zhangyingwei.ikeywords.common.CommParams;
import com.zhangyw.utils.file.FileUtil;

import java.util.List;

/**
 * Created by zhangyw on 2016/9/5.
 */
public class KeyWordValid {
    public static List<String> endword = null;
    public static final String ENCODING = "UYF-8";
    public boolean init(){
        this.endword = FileUtil.readArr(CommParams.KEYWORD_ENDWORD_PATH,ENCODING);
        return this.endword == null? false:true;
    }
}
