package com.lqd.androidpractice.recyclerview.diffutil;

/**
 * @author: a564
 * @Date 2021/7/22
 */
class User {
    public int id;
    public String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
