package lwy.controller;

import lwy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class HelloController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String hello(){
        redisTemplate.boundValueOps("setmealPicDbResources").set("1111111");
        return "";
    }
    @RequestMapping("/list")
    public List<User> findAll(){
        String key="UserList";
        List<User> list = (List<User>) redisTemplate.boundValueOps(key).get();
        if (list==null){
            list = new ArrayList<User>();
            list.add(new User("王五", "深圳", 25));
            list.add(new User("李四", "北京", 23));
            list.add(new User("赵六", "上海", 26));
            redisTemplate.boundValueOps(key).set(list);
            list=(List<User>) redisTemplate.boundValueOps(key).get();
            System.out.println(list);
        }
        System.out.println("redis:"+list);
        return list;
    }
}
