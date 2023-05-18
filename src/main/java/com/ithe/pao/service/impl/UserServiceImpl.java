package com.ithe.pao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.ithe.pao.common.ErrorCode;
import com.ithe.pao.exception.BusinessException;
import com.ithe.pao.mapper.UserMapper;
import com.ithe.pao.model.domain.User;
import com.ithe.pao.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author L
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2023-05-17 23:30:41
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {


    @Resource
    private UserMapper userMapper;

    /**
     * 根据标签搜索用户
     *
     * @param tagList 用户拥有的标签
     * @return
     */
    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    @Override
    public User getSafetyUser(User originUser) {
        if (originUser == null) {
            return null;
        }
        User safetyUser = new User();
        safetyUser.setId(originUser.getId());
        safetyUser.setUsername(originUser.getUsername());
        safetyUser.setUserAccount(originUser.getUserAccount());
        safetyUser.setAvatarUrl(originUser.getAvatarUrl());
        safetyUser.setGender(originUser.getGender());
        safetyUser.setPhone(originUser.getPhone());
        safetyUser.setEmail(originUser.getEmail());
        safetyUser.setPlanetCode(originUser.getPlanetCode());
        safetyUser.setUserRole(originUser.getUserRole());
        safetyUser.setUserStatus(originUser.getUserStatus());
        safetyUser.setCreateTime(originUser.getCreateTime());
        safetyUser.setTags(originUser.getTags());
        return safetyUser;
    }

    @Override
    public List<User> searchUsersByTags(List<String> tagList) {
        if (CollectionUtils.isEmpty(tagList)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
//        方式一，数据库中查询

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        userMapper.selectCount(queryWrapper);
//        long startTime = System.currentTimeMillis();
        //拼接 and 查询
        //like '%Java%'and like '%python'
        for (String tag : tagList) {
            queryWrapper = queryWrapper.like("tags", tag);
        }
        List<User> userList = userMapper.selectList(queryWrapper);
//        long l = System.currentTimeMillis() - startTime;


//        方法二 内存查询
        /*QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        long startTime1 = System.currentTimeMillis();
        //查询所有用户
        List<User> userList1 = userMapper.selectList(queryWrapper1);
        Gson gson = new Gson();
        //在内存中是否包含要求的标签

*//*将userList列表中的用户进行过滤，
只保留那些包含tagList中所有标签的用户。然后将满足条件的用户映射为安全用户对象，
并将它们收集到一个列表中返回。*//*
        return userList1.stream()
                .filter(user -> {
                    String tags = user.getTags();
                    if (StringUtils.isEmpty(tags)){
                        return false;
                    }
                    Set<String> tempTagSet = gson.fromJson(tags, new TypeToken<Set<String>>() {
                    }.getType());
                    for (String tag : tagList) {
                        if (!tempTagSet.contains(tag)) {
                            return false;
                        }
                    }
                    log.info("sql time =" + l);
                    log.info("neicun time =" + (System.currentTimeMillis() - startTime1));
                    return true; // Add this line to return true if all tags are found
                })
                .map(this::getSafetyUser)
                .collect(Collectors.toList());*/


        return userList.stream().map(this::getSafetyUser).collect(Collectors.toList());

    }

}




