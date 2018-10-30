package hibernate;

import java.lang.reflect.Method;

/**
* @Description  测试仿Hibernate注解
* @since  2018年10月30日 上午11:23:35
* @author LiuLiBin
*/
public class ParseHibernateAnnotation {
	public static void main(String[] args) {
		
		try {
			//1. 获取class类对象
			Class hclass = Class.forName("hibernate.Hero");
		
			//判断本类是否进行了MyEntity 注解
			boolean isEntity = hclass.isAnnotationPresent(MyEntity.class);
			if(!isEntity) {
				System.out.println("Hero 不是实体类");
			}
			else {
				System.out.println("Hero 是实体类");//获取注解MyTable
				boolean isTable = hclass.isAnnotationPresent(MyTable.class);
				if(isTable) {
					MyTable table =  (MyTable)hclass.getAnnotation(MyTable.class);
					System.out.println("其对应的表名为："+table.name());
				}
				// 遍历所有的方法，如果某个方法有MyId注解，那么就记录为主键方法primaryKeyMethod 
				Method[] ms = hclass.getMethods();
				Method   primaryKeyMethod = null;
				for(Method m:ms) {
					
					MyId myId = m.getAnnotation(MyId.class);
					
					if(null!=myId){
	                    primaryKeyMethod = m;
	                    break;
	                }
				}
				
				//存在主键方法
	            if(null!=primaryKeyMethod){
            	   System.out.println("找到主键：" + method2attribute( primaryKeyMethod.getName() ));
            	   
            	   MyGeneratedValue myGeneratedValue =
                           primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
                           System.out.println("其自增长策略是：" +myGeneratedValue.strategy());
                           
                   MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
                   System.out.println("对应数据库中的字段是：" +myColumn.value());
	            }
	            
	            System.out.println("其他非主键属性分别对应的数据库字段如下：");
			
	            for (Method m: ms) {
	               
	            	//判断是否非主键方法
	            	if(m==primaryKeyMethod){
	                    continue;
	                }
	                MyColumn myColumn = m.getAnnotation(MyColumn.class);
	                //那些setter方法上是没有MyColumn注解的
	                if(null==myColumn)
	                    continue;
	                System.out.format("属性： %s\t对应的数据库字段是:%s%n",method2attribute(m.getName()),myColumn.value());
	 
	            }
	             
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static String method2attribute(String methodName) {
        String result = methodName; ;
        result = result.replaceFirst("get", "");
        result = result.replaceFirst("is", "");
        if(result.length()<=1){
            return result.toLowerCase();
        }
        else{
        	//首字母小写
            return result.substring(0,1).toLowerCase() + result.substring(1,result.length());
        }
         
    }
}
