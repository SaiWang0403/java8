public class FilterEmployeeBySalary implements myPredict<Employee>  {
    @Override
    public boolean test(Employee t){
        return t.getSalary()>5000;
    }
}
