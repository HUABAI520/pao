package com.ithe.pao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ithe.pao.common.ErrorCode;
import com.ithe.pao.exception.BusinessException;
import com.ithe.pao.mapper.UserMapper;
import com.ithe.pao.model.domain.User;
import com.ithe.pao.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
* @author L
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2023-05-17 23:30:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {



/**
 *根据标签搜索用户
 * @param tagList 用户拥有的标签
 * @return
* */

    @Override
    public int searchUsersByTags(List<String> tagList){
        if(CollectionUtils.isEmpty(tagList)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }


        return 1;
    }

}




