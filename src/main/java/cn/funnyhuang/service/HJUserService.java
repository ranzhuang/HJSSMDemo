package cn.funnyhuang.service;

import cn.funnyhuang.model.Usertable;
import cn.funnyhuang.model.UsertableExample;

import java.util.List;

public interface HJUserService {
    /* 添加用户 */
    public void insertSelective(Usertable record) throws Exception;
    /* 删除用户 */
    public void deleteByPrimaryKey(Integer userid) throws Exception;
    /* 查询用户列表 */
    public List<Usertable> selectByExample(UsertableExample example) throws Exception;
    /* 修改用户信息 */
    public void updateByPrimaryKeySelective(Usertable record) throws Exception;
}
