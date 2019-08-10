package tianyao.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import tianyao.bean.Clothes;

public class ProductsXmlUtils {

	private static final String FILE_NAME="D:\\ÎÄ¼þ\\java\\"
			+ "java³ÌÐò\\ClothesSupermarketSystem\\src\\products.xml";
	public static List<Clothes> parseProductFromXml(){
		List<Clothes> products = new ArrayList<>();
		XStream xStream =new XStream(new Xpp3Driver());
		xStream.alias("List",products.getClass());
		xStream.alias("clothes",tianyao.bean.Clothes.class);
		xStream.useAttributeFor(Clothes.class,"id");
		try {
			BufferedInputStream inputStream=new BufferedInputStream(
				new FileInputStream(FILE_NAME));
			products = ((List<Clothes>) xStream.fromXML(inputStream));
			inputStream.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		return products;
	}
	
	public static void writeProductToXml(List<Clothes> products) {
		XStream xStream =new XStream(new Xpp3Driver());
		xStream.alias("List",products.getClass());
		xStream.alias("clothes",Clothes.class);
		xStream.useAttributeFor(Clothes.class,"id");
		try {
			BufferedOutputStream outputStream =new BufferedOutputStream(
					new FileOutputStream(FILE_NAME));
			outputStream.write
			("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
			xStream.toXML(products, outputStream);
			outputStream.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
