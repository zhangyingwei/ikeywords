package com.zhangyingwei.ikeywords.ansj.valid;

import com.zhangyingwei.ikeywords.common.CommParams;
import com.zhangyw.utils.file.FileUtil;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Created by zhangyw on 2016/9/5.
 */
public class KeyWordValid {
    private Logger logger  = Logger.getLogger(KeyWordValid.class);
    public static Set<String> endword = null;
    public static final String ENCODING = "UTF-8";
    private boolean init(){
        if(this.endword==null){
            try{
                this.endword = FileUtil.readArr(CommParams.KEYWORD_ENDWORD_PATH,ENCODING);
                logger.info(this.endword);
            }catch (Exception e){
                return false;
            }
        }
        return this.endword == null? false:true;
    }

    public boolean valid(String text){
        if(this.init()){
            for(String end:this.endword){
                if(text.equals(end)||(text.indexOf(end)>=0)){
                    return false;
                }
            }
        }
        return true;
    }
}
