package cz.karan.jba.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;
import cz.karan.jba.entity.Item;
import cz.karan.jba.exception.RssException;
import cz.karan.jba.rss.ObjectFactory;
import cz.karan.jba.rss.TRss;
import cz.karan.jba.rss.TRssChannel;
import cz.karan.jba.rss.TRssItem;

@Service
public class RssService {
	
	public List<Item> getItems(File file) throws RssException{
		return getItems(new StreamSource(file));
	}
	
public List<Item> getItems(String url) throws RssException{
		return getItems(new StreamSource(url));
	}
	
	
	
	
	private List<Item> getItems(Source source) throws RssException{
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			JAXBContext jaxbContext= JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement= unmarshaller.unmarshal(source, TRss.class);
			TRss rss= jaxbElement.getValue();
			List<TRssChannel> channels = rss.getChannel();
			for(TRssChannel channel : channels ){
				List<TRssItem> items=channel.getItem();
				for(TRssItem rssItem : items){
					Item item= new Item();
					item.setTitle(rssItem.getTitle());
					item.setLink(rssItem.getLink());
					item.setDescription(rssItem.getDescription());
					Date pùbDate= new SimpleDateFormat("EEE,dd MMM yyy HH:mm:ss",Locale.ENGLISH).parse(rssItem.getPubDate());
					item.setPublishedDate(pùbDate);
					list.add(item);
				}
			}
			return list;
		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			throw new RssException(e);
		}
	}

}
