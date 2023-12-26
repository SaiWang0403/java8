import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLambda {
    @Test
    public void test(){
        List<Employee> list=filterEmployees(employees);
        for (Employee e:list){
            System.out.println(e);
        }
    }
    List<Employee> employees= Arrays.asList(
        new Employee("zhangsan",18,123),
        new Employee("lisi",28,1234),
        new Employee("wangwu",38,3423),
        new Employee("zhaoliu",48,9424)
    );
    //需求：获取当前公司员工大于35的信息
    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps=new ArrayList<>();
        for(Employee e:list){
            if(e.getAge()>35){
                emps.add(e);
            }
        }
        return emps;
    }

    public List<Employee> filterEmployee(List<Employee> list,myPredict<Employee> mp ){
        List<Employee> emps=new ArrayList<>();
        for (Employee employee:list){
            if(mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }
    @Test
    public void test2(){
        List<Employee> list=filterEmployee(employees,new FilterEmployeeByAge());
        for (Employee e:list){
            System.out.println(e);
        }
    }

    @Test
    public void test3(){
        List<Employee> list=filterEmployee(employees,new FilterEmployeeBySalary());
        for (Employee e:list){
            System.out.println(e);
        }
    }

    @Test
    public void test4(){
        List<Employee> list=filterEmployee(employees,new myPredict<Employee>(){
            @Override
            public boolean test(Employee t){
                return t.getSalary()<5000;
            }

        });
        for (Employee employee:list){
            System.out.println(employee);
        }
    }

    @Test
    public void test5(){
        List<Employee> list=filterEmployee(employees,(e)->e.getSalary()>5000);
        list.forEach(System.out::println);
    }

    @Test
    public void test6(){
        employees.stream()
                .filter((e)->e.getSalary()>=5000)
                .forEach(System.out::println);

        System.out.println("-------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }


}
