package hibernate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Description 对应 javax.persistence.Table
* @since  2018年10月30日 上午10:57:30
* @author LiuLiBin
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {

	 //对应表名
	 String name();
}
