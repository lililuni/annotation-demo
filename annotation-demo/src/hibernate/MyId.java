package hibernate;


import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
* @Description 
* @since  2018年10月30日 上午10:59:41
* @author LiuLiBin
*/
@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyId {

}
