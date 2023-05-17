package com.ithe.pao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ithe.pao.mapper.TagMapper;
import com.ithe.pao.model.domain.Tag;
import com.ithe.pao.service.TagService;
import org.springframework.stereotype.Service;

/**
 * @author L
 * @description 针对表【tag(标签)】的数据库操作Service实现
 * @createDate 2023-05-17 23:11:44
 */
/*extends ServiceImpl<TagMapper, Tag>
        implements TagService*/
@Service
public class TagServiceImpl  extends ServiceImpl<TagMapper,Tag> implements TagService{
}




