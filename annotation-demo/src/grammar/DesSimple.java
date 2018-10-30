package grammar;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Description  注解
* @since  2018年10月30日 上午9:37:44
* @author LiuLiBin
*/
@Target({ElementType.METHOD ,  ElementType.TYPE})
@Retention( RetentionPolicy.RUNTIME)
@Inherited
@Documented

public @interface DesSimple {
	String value();
}
