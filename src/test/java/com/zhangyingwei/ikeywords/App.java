package com.zhangyingwei.ikeywords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.recognition.impl.NatureRecognition;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.BaseAnalysis;

import com.zhangyingwei.rssreader.client.RssClient;
import com.zhangyingwei.rssreader.model.RssEntity;
import com.zhangyw.utils.String.StringUtil;

public class App {
	public static void main(String[] args) throws Exception {
//		String url = "https://luolei.org/rss/";
		String url = "http://localhost:9000/rss/rss3.xml";
		List<RssEntity> rss = new RssClient().buildRssEntitys(url);
		System.out.println(rss.get(0).getContent());
		for(RssEntity e:rss){
			KeyWordComputer computer = new KeyWordComputer(30);
			List<Keyword> list = computer.computeArticleTfidf(e.getTitle(), e.getContent());
			System.out.println(e.getTitle());
			System.out.println(list);
			System.out.println("-----------");
		}
	}
}
