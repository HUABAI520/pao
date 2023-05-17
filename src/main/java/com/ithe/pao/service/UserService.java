package com.ithe.pao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ithe.pao.model.domain.User;

import java.util.List;


/**
* @author L
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-05-17 23:30:41
*/
public interface UserService extends IService<User> {

    /*
        根据标签搜索用户
        tagList 用户拥有的标签
        * */
    int searchUsersByTags(List<String> tagList);
}
