package l84.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@ControlledObject(name = "")
public class ReflectionExample {	
	
    @StartObject
    public void createReflectionExample(){
      //бизнес логика
    }
    
    @StopObject
    public void stopReflectionExample(){
      //бизнес логика
    }
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//Zoopark zoo = new Zoopark();
		//zoo.getClass(); //Reflection Entry point
		
		

		ReflectionExample reflEx = new ReflectionExample();
		Class clazz = reflEx.getClass();
		if(clazz.isAnnotationPresent(ControlledObject.class)){
			System.out.println("class annotated with annotatin name=" + clazz.getAnnotation(ControlledObject.class));
		} else {
			System.out.println("не стоит");
		}
		
		
		boolean hasStart=false;
		boolean hasStop=false;        
		Method[] methods = clazz.getMethods();
		for(Method md: methods){
	       if(md.isAnnotationPresent(StartObject.class)) {hasStart=true;}
	       if(md.isAnnotationPresent(StopObject.class)) {hasStop=true;}
	       if(hasStart && hasStop){break;}
		}
		System.out.println("Start annotaton  - " + hasStart + ";  Stop annotation  - " + hasStop );
		
		
	}
}


@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface StartObject {    
}

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface StopObject {    
}

@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
@interface ControlledObject {    
     String name() default "default name";    
}