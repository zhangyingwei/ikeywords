package com.zhangyingwei.ikeywords;

import com.zhangyingwei.ikeywords.common.CommParams;
import com.zhangyingwei.ikeywords.keywords.KeyWords;
import com.zhangyingwei.rssreader.client.RssClient;
import com.zhangyingwei.rssreader.model.RssEntity;

import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
		CommParams.KEYWORD_ENDWORD_PATH = "src/main/resources/endword.conf";
//		String url = "http://blog.zhangyingwei.com/atom.xml";
		String url = "http://linux48.com/atom.xml";
		List<RssEntity> rss = new RssClient().buildRssEntitys(url);
		System.out.println(rss.size());
        KeyWords keyWords = new KeyWords();
		for(RssEntity e:rss){
            System.out.println(e.getTitle());
            keyWords.cut(e.getTitle(),e.getContent());
            System.out.println(keyWords.getKeyWordSet());
            System.out.println("-----------");
        }
	}
}
