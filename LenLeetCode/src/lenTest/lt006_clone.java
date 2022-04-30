package lenTest;

public class lt006_clone{
    class Person implements Cloneable{
        // 必须要实现Cloneable接口,否则会报错
        public int age;

        public Person(int age){
            this.age = age;
        }

        @Override
        public Person clone(){
            try {
                return (Person) super.clone();
            } catch (CloneNotSupportedException e){
                return null;
            }
        }
    }

    class Animal implements Cloneable{
        // 必须要实现Cloneable接口,否则会报错
        public int age;
        private int[] arr = new int[]{1,2,3,4};

        public Animal(int age){
            this.age = age;
        }

        @Override
        public Animal clone(){
            try {
                Animal animal = (Animal) super.clone();
                animal.arr = this.arr.clone();
                return animal;
            } catch (CloneNotSupportedException e){
                return null;
            }
        }
    }
}
