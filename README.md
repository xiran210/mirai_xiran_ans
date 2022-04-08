# mirai_xiran_ans
基于Mirai Console的插件,使用语言Kotlin

目前仅实现了3个指令

/ans add <problem> <answer>    # 添加一个回复规则
  
/ans del <problem>    # 删除一个回复规则
  
/ans re <problem>    # 删除一个回复规则,若一个指令能提供正则表达式匹配输入的字符串则删除次规则

可以在控制台使用，也可以在聊天环境内使用
  
在聊天环境使用前请Mirai Console 权限系统赋予用户权限
  
指令的解析请阅读次[文章](https://docs.mirai.mamoe.net/console/Commands.html#%E6%96%87%E6%9C%AC%E5%8F%82%E6%95%B0%E7%9A%84%E8%BD%AC%E4%B9%89)
  
权限赋予请阅读此[文章](https://docs.mirai.mamoe.net/console/Permissions.html#%E8%A2%AB%E8%AE%B8%E5%8F%AF%E4%BA%BA)

其他参考资料:
[Mirai生态开发文档](https://docs.mirai.mamoe.net/)
