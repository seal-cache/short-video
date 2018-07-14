# short-video

## 搭建springboot分层项目

## 逆向工程生成mybatis类

## 注册功能，使用swagger2接口测试

注意配置mapper扫描

```java
@SpringBootApplication
@MapperScan(basePackages="com.imooc.mapper")
@ComponentScan(basePackages= {"com.imooc", "org.n3r.idworker"})
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
```

注册逻辑

```java
// 1. 判断用户名密码不为空
if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
    return IMoocJSONResult.errorMsg("用户名和密码不能为空");
}
// 2. 判断用户名密码是否存在
boolean usernameIsExist = userService.queryUsernameIsExist(user.getUsername());

// 3. 保存用户，注册信息
if(!usernameIsExist) {
    user.setNickname(user.getUsername());
    user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
    user.setFansCounts(0);
    user.setReceiveLikeCounts(0);
    user.setFollowCounts(0);
    userService.saveUser(user);
} else {
    return IMoocJSONResult.errorMsg("用户名已存在,请换一个重新输入");
}

return IMoocJSONResult.ok();
```
