package hibernate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
* @Description 
* @since  2018年10月30日 上午11:01:51
* @author LiuLiBin
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyGeneratedValue {
	
	//增长策略
	String strategy();
}
