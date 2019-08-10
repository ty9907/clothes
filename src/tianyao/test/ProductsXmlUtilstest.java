package tianyao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import tianyao.bean.Clothes;
import tianyao.utils.ProductsXmlUtils;

public class ProductsXmlUtilstest {

	@Test
	public void testParseProductFromXml() {
		
		List<Clothes> clothes = ProductsXmlUtils.parseProductFromXml();
		System.out.println(Arrays.toString(clothes.toArray()));
	}

}
