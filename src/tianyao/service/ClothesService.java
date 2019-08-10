package tianyao.service;

import java.util.List;

import tianyao.bean.Clothes;
import tianyao.utils.BusinessException;

public interface ClothesService {

	public List<Clothes> list() throws BusinessException;
	public Clothes findById(String cid)throws BusinessException;
	public void update()throws BusinessException;
}
