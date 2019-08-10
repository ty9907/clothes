package tianyao.service.impl;

import java.util.List;

import tianyao.bean.Clothes;
import tianyao.service.ClothesService;
import tianyao.utils.BusinessException;
import tianyao.utils.ClothesIO;
import tianyao.utils.ProductsXmlUtils;

public class ClothesServiceImpl implements ClothesService {

	private ClothesIO clothesIO=new ClothesIO();
	public List<Clothes> list() throws BusinessException{
		// TODO Auto-generated method stub
		return clothesIO.list();
	}

	@Override
	public Clothes findById(String cid) throws BusinessException {
		return clothesIO.findById(cid);
	}
	public void update()throws BusinessException{
		clothesIO.update();
	}

}
