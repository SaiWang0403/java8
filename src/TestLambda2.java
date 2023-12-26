import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda2 {
    @Test
    public void test(){
        Integer res=operation(100,x->x+200);
        System.out.println(res);
    }

    public Integer operation(Integer num,Myfun mf){
      return mf.getValue(num);
    }


    List<Employee> employees= Arrays.asList(
            new Employee("zhangsan",18,123),
            new Employee("lisi",28,1234),
            new Employee("wangwu",38,3423),
            new Employee("zhaoliu",48,9424)
    );

    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return  e1.getName().compareTo(e2.getName());
            }else{
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee e:employees){
            System.out.println(e);
        }
    }
    @Test
    public void test2(){
        String res=Operation("abc",s->s.toUpperCase());
        System.out.println(res);
    }
    public String Operation(String s,MyFunction mf){
        return mf.getValue(s);
    }

    @Test
    public void test3(){
        op(100L,200L,(x,y) -> x  + y);
    }

    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }




}
