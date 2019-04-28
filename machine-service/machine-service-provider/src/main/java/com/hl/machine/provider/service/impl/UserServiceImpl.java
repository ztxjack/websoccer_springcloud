package com.hl.machine.provider.service.impl;

import com.hl.common.entity.User;
import com.hl.machine.provider.mapper.UserMapper;
import com.hl.machine.provider.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mr.磊
 * @since 2018-05-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
