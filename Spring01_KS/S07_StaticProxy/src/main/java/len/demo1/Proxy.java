<<<<<<< HEAD
package len.demo1;

public class Proxy  implements Rent {
    private Host host;

    public Proxy(){}

    public Proxy(Host host){
        this.host = host;
    }

    public void rent() {
        host.rent();
    }

    public void seeHouse(){
        System.out.println("中介带你看房！");
    }

    public void fare(){
        System.out.println("收中介费！");
    }

    public void hetong(){
        System.out.println("签租赁合同！");
    }
}
=======
package len.demo1;

public class Proxy  implements Rent {
    private Host host;

    public Proxy(){}

    public Proxy(Host host){
        this.host = host;
    }

    public void rent() {
        host.rent();
    }

    public void seeHouse(){
        System.out.println("中介带你看房！");
    }

    public void fare(){
        System.out.println("收中介费！");
    }

    public void hetong(){
        System.out.println("签租赁合同！");
    }
}
>>>>>>> 1da3f48 (first commit)
