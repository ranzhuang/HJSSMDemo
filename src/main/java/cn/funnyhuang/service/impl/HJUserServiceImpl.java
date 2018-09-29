package cn.funnyhuang.service.impl;

import cn.funnyhuang.mapper.UsertableMapper;
import cn.funnyhuang.model.Usertable;
import cn.funnyhuang.model.UsertableExample;
import cn.funnyhuang.service.HJUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HJUserServiceImpl implements HJUserService {

    @Autowired
    private UsertableMapper usertableMapper;

    @Override
    public void insertSelective(Usertable record) throws Exception {
        usertableMapper.insertSelective(record);
    }
    @Override
    public void deleteByPrimaryKey(Integer userid) throws Exception {
        usertableMapper.deleteByPrimaryKey(userid);
    }
    @Override
    public List<Usertable> selectByExample(UsertableExample example) throws Exception {
        List<Usertable> usertables = usertableMapper.selectByExample(example);
        return usertables;
    }

    @Override
    public void updateByPrimaryKeySelective(Usertable record) throws Exception {
        usertableMapper.updateByPrimaryKeySelective(record);
    }
}

