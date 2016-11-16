package sina.service.imp;

import java.io.Serializable;
import java.util.List;

import sina.service.inter.BaseInterface;
import sina.util.HibernateUtil;

/**
 * @author Thinkpad
 * @function 基础的抽象类实现基础接口,复写接口里的方法,这样子类只需要继承抽象类就能实现基础接口的所有方法
 *
 */
public abstract class BaseServiceImp implements BaseInterface {

	public Object findById(Class clazz, Serializable id) {
		
		return HibernateUtil.findById(clazz, id);
	}
	public void save(Object obj){
		try{
			HibernateUtil.save(obj);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List findAll(){
		
		return null;
	}

}
