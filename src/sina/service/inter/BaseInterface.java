package sina.service.inter;

import java.util.List;

/**
 *@author Thinkpad
 *@function 把一些通用的方法声明到基础接口里,提高代码的复用性
 */
public interface BaseInterface {
	
	/**
	 * @author Thinkpad
	 * @param clazz 传递过来的对象
	 * @param id 对应的数据库表的id
	 * @return 返回一个对象
	 * @param java.io.Serializable id 所有的包装类都实现了该接口.
	 */
	public Object findById(Class clazz,java.io.Serializable id);
	public void save(Object obj);
	public List findAll();
}

