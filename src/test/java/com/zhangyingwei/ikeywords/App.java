package com.zhangyingwei.ikeywords;

import com.zhangyingwei.ikeywords.ansj.KeyWordComputer;
import com.zhangyingwei.rssreader.client.RssClient;
import com.zhangyingwei.rssreader.model.RssEntity;
import org.ansj.app.keyword.Keyword;

import java.util.List;

public class App {
	public static void main(String[] args) throws Exception {
		String url = "http://blog.zhangyingwei.com/atom.xml";
		List<RssEntity> rss = new RssClient().buildRssEntitys(url);
		System.out.println(rss.size());
		KeyWordComputer computer = new KeyWordComputer(30);
		List<Keyword> list = computer.computeArticleTfidf(rss.get(3).getTitle(), rss.get(3).getContent());
		System.out.println(rss.get(3).getTitle());
		System.out.println(list);
		System.out.println("-----------");
//		for(RssEntity e:rss){
//			KeyWordComputer computer = new KeyWordComputer(30);
//			List<Keyword> list = computer.computeArticleTfidf(e.getTitle(), e.getContent());
//			System.out.println(e.getTitle());
//			System.out.println(list);
//			System.out.println("-----------");
//		}
	}
}
