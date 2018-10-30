package hibernate;
/**
* @Description 对应 javax.persistence.Entity注解
* @since  2018年10月30日 上午10:48:16
* @author LiuLiBin
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyEntity {
	
}
