package 装饰设计模式;

/*
 *@author 王炳烈
 *2019/5/21  10:49
 */
/*
    装饰设计模式
    当想要对已有的对象进行功能增强时，
    可以定义类，将已有对象传入，基于已有的功能，并提供加强功能
    那么自定义的该类成为装饰类


    装饰类通常会通过构造方法接受被装饰的对象
    并基于被装饰的对象的功能，提供更强的功能
*/
class person{
    public void chifan(){
        System.out.println("吃饭");
    }
}
class SupperPerson{
    person person;
    public SupperPerson(person p){
        person = p;
    }
    public void SupperChifan(){
        System.out.println("开胃酒");
        person.chifan();
        System.out.println("结账");
    }
}
public class personDemo {
    public static void main(String[] args) {
        person s = new person();
        SupperPerson supperPerson = new SupperPerson(s);
        supperPerson.SupperChifan();
    }
}
