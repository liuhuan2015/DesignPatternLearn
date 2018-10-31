package com.liuh.builderpattern;

/**
 * Date: 2018/10/31 09:08
 * Description: 构建者模式（Builder Pattern）
 * <p>
 * Student类的构造方法私有，它有一个内部静态类 Builder，通过这个 Builder 可以一步步的创建 Student 实例对象。
 */
public class Student {

    private int id;
    private String name;
    private String passwd;
    private String sex;
    private String address;

    // 构造器尽量缩小范围,私有
    private Student() {
    }

    //  构造器尽量缩小范围,私有,拷贝一份
    private Student(Student origin) {
        this.id = origin.id;
        this.name = origin.name;
        this.passwd = origin.passwd;
        this.sex = origin.sex;
        this.address = origin.address;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    // Student 的实例对象的创建完全依赖 Builder，使用一种方法链的方式来创建
    public static class Builder {

        private Student target;

        Builder() {
            this.target = new Student();
        }

        public Builder id(int id) {
            target.id = id;
            return this;
        }


        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder passwd(String passwd) {
            target.passwd = passwd;
            return this;
        }


        public Builder sex(String sex) {
            target.sex = sex;
            return this;
        }


        public Builder address(String address) {
            target.address = address;
            return this;
        }

        public Student build() {
            return new Student(target);
        }

    }

}
