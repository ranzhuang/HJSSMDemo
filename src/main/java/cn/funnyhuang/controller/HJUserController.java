package cn.funnyhuang.controller;

import cn.funnyhuang.Tool.HJResult;
import cn.funnyhuang.Tool.HJResultTypeTool;
import cn.funnyhuang.exception.HJCustomException;
import cn.funnyhuang.exception.HJCustomExceptionEnum;
import cn.funnyhuang.exception.HJCustomExceptionHandle;
import cn.funnyhuang.model.Usertable;
import cn.funnyhuang.model.UsertableExample;
import cn.funnyhuang.service.HJUserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class HJUserController  {

    @Autowired
    private HJUserService hjUserService;
    @Autowired
    private HJCustomExceptionHandle exceptionHandle;

    /**
     * 用户登录
     * @param nickName
     * @param passWord
     * @return
     * @throws Exception
     */
    @RequestMapping("logUser")
    @ResponseBody
    public HJResult userLog(String nickName, String passWord) throws Exception {

        return HJResultTypeTool.successNoData();
    }

    /**
     * 创建用户
     * @param nickName
     * @param passWord
     * @return
     * @throws Exception
     */
    @RequestMapping("/createUser")
    @ResponseBody
    public HJResult createUser(String nickName, String passWord) throws Exception {
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
        if (userId == null) {
            HJCustomException exception = new HJCustomException(HJCustomExceptionEnum.PARAMETER_ERROR);
//            return exceptionHandle.execptionGet(exception);
            //抛出异常
            throw exception;
        }
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
    public HJResult selectUserList(String nickName) throws Exception {
        UsertableExample usertableExample = new UsertableExample();
        UsertableExample.Criteria criteria = usertableExample.createCriteria();
        criteria.andNicknameLike("%"+(nickName)+"%");
        List<Usertable> usertables = hjUserService.selectByExample(usertableExample);
        return HJResultTypeTool.success(usertables);
    }


    /**
     * 创建用户
     * @param jsonStr
     * @return
     * @throws Exception
     */
    @RequestMapping("/createUserFromJsonStr")
    @ResponseBody
    public HJResult createUserFromJsonStr(@RequestParam(value = "param") String jsonStr) throws Exception {
        Usertable usertable = JSON.parseObject(jsonStr,Usertable.class);
        hjUserService.insertSelective(usertable);
        return HJResultTypeTool.successNoData();
    }

    /**
     * 删除用户
     * @param jsonStr
     * @return
     * @throws Exception
     */

    @RequestMapping("/deleteUserFromJsonStr")
    @ResponseBody
    public HJResult deleteUserFromJsonStr(@RequestParam(value = "param") String jsonStr) throws Exception {
        try {

        } catch (Exception e) {

//            return exceptionHandle.execptionGet(e);
            //抛出异常
            throw e;
        }
        Map<String, Object> map = JSON.parseObject(jsonStr,new TypeReference<Map<String,Object>>(){});
        if (map.get("userId") == null) {
//            return HJResultTypeTool.errorException(HJCustomExceptionEnum.PARAMETER_ERROR);
            //抛出异常
            throw new HJCustomException(HJCustomExceptionEnum.PARAMETER_ERROR);
        }
        hjUserService.deleteByPrimaryKey((Integer) map.get("userId"));
        return HJResultTypeTool.successNoData();
    }


    /**
     * 更新用户信息
     * @param jsonStr json字符串
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUserFromJsonStr")
    @ResponseBody
    public HJResult updateUserFromJsonStr(@RequestParam(value = "param") String jsonStr) throws Exception {
        Usertable usertable = JSON.parseObject(jsonStr,Usertable.class);
        hjUserService.updateByPrimaryKeySelective(usertable);
        return HJResultTypeTool.successNoData();
    }

    /**
     * 根据昵称查找用户
     * @param jsonStr
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectUserListFromJsonStr")
    @ResponseBody
    public HJResult selectUserListFromJsonStr(@RequestParam(value = "param") String jsonStr) throws Exception {

        Map<String,Object> map = JSON.parseObject(jsonStr,new TypeReference<Map<String, Object>>(){});
        UsertableExample usertableExample = new UsertableExample();
        UsertableExample.Criteria criteria = usertableExample.createCriteria();
        criteria.andNicknameLike("%"+(map.get("nickName"))+"%");
        List<Usertable> usertables = hjUserService.selectByExample(usertableExample);
        return HJResultTypeTool.success(usertables);
    }
}
