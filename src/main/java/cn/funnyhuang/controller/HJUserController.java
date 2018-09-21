package cn.funnyhuang.controller;

import cn.funnyhuang.Tool.HJResult;
import cn.funnyhuang.Tool.HJResultTypeTool;
import cn.funnyhuang.model.Usertable;
import cn.funnyhuang.model.UsertableExample;
import cn.funnyhuang.service.HJUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class HJUserController  {

    @Autowired
    private HJUserService hjUserService;

    /**
     * 创建用户
     * @param nickName
     * @param passWord
     * @return
     * @throws Exception
     */
    @RequestMapping("/creatUser")
    @ResponseBody
    public HJResult creatUser(String nickName, String passWord) throws Exception {
        Usertable usertable = new Usertable();
        usertable.setNickname(nickName);
        usertable.setPassword(passWord);
        hjUserService.insertSelective(usertable);
        return HJResultTypeTool.successNoData();
    }

    /**
     * 删除用户
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public HJResult deleteUser(Integer userId) throws Exception {
        hjUserService.deleteByPrimaryKey(userId);
        return HJResultTypeTool.successNoData();
    }

    /**
     * 更新用户信息
     * @param userId
     * @param nickName
     * @param age
     * @param sex 0女，1男，2未设置
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public HJResult updateUser(Integer userId, String nickName, Integer age, Integer sex) throws Exception {
        Usertable usertable = new Usertable();
        usertable.setUserid(userId);
        usertable.setNickname(nickName);
        usertable.setAge(age);
        usertable.setSex(sex);
        hjUserService.updateByPrimaryKeySelective(usertable);
        return HJResultTypeTool.successNoData();
    }
    
    /**
     * 根据昵称查找用户
     * @param nickName
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectUserList")
    @ResponseBody
    public HJResult seleteUserList(String nickName) throws Exception {
        UsertableExample usertableExample = new UsertableExample();
        UsertableExample.Criteria criteria = usertableExample.createCriteria();
        criteria.andNicknameLike("%"+(nickName)+"%");
        List<Usertable> usertables = hjUserService.selectByExample(usertableExample);
        return HJResultTypeTool.success(usertables);
    }

}
