package com.yjw.expenses;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yjw.expenses.common.ResponseErrorEnum;
import com.yjw.expenses.pojo.vo.BaseResponse;
import com.yjw.expenses.pojo.vo.DeletePersonReqVO;
import com.yjw.expenses.pojo.vo.FindPersonInfoReqVO;
import com.yjw.expenses.pojo.vo.PersonRegisterReqVO;
import com.yjw.expenses.pojo.vo.UpdatePersonInfoReqVO;
import com.yjw.expenses.service.IPersonService;

/**
 * 人物服务测试类
 * 
 * @description PersonServiceTest.java
 * @author YangJianWei
 * @date 2018年10月9日 下午4:25:32
 * @version $Id: v 0.1
 */
public class PersonServiceTest {

    @Autowired
    IPersonService personService;

    /**
     * 用户注册测试
     */
    @Test
    public void savePerson() {
        PersonRegisterReqVO request = new PersonRegisterReqVO();
        request.setAge(22);
        request.setAvatar("头像2");
        request.setGender(2);
        request.setName("杨建伟2");
        request.setPassword("qwer1234");
        request.setTel("18582481863");
        BaseResponse result = personService.personRegister(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());
    }

    /**
     * 查询用户详情
     */
    @Test
    public void findPersonInfo() {
        FindPersonInfoReqVO request = new FindPersonInfoReqVO();

        //查询成功
        request.setId(1);
        BaseResponse result = personService.findPersonInfo(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        //查询失败
        request.setId(0);
        BaseResponse result1 = personService.findPersonInfo(request);
        System.out.println(result);
        Assert.assertEquals(ResponseErrorEnum.DATA_NOT_EXIST.getErrorCode(), result1.getCode());
    }

    /**
     * 修改用户信息
     */
    public void updatePersonInfo() {
        UpdatePersonInfoReqVO request = new UpdatePersonInfoReqVO();

        // 修改成功
        request.setAge(7);
        request.setAvatar("7");
        request.setGender(2);
        request.setId(6);
        request.setName("7");
        request.setPassword("7");
        request.setTel("7");
        BaseResponse result = personService.updatePersonInfo(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        // 修改失败
        request.setAge(7);
        request.setAvatar("7");
        request.setGender(2);
        request.setId(0);
        request.setName("7");
        request.setPassword("7");
        request.setTel("7");
        BaseResponse result1 = personService.updatePersonInfo(request);
        System.out.println(result1);
        Assert.assertEquals(ResponseErrorEnum.DATE_UPDATE_WRONG.getErrorCode(), result1.getCode());

    }

    /**
     * 删除用户信息
     */
    public void deletePersonInfo() {
        DeletePersonReqVO request = new DeletePersonReqVO();

        // 删除成功
        request.setId(6);
        BaseResponse result = personService.deletePerson(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        // 删除失败
        request.setId(0);
        BaseResponse result1 = personService.deletePerson(request);
        System.out.println(result1);
        Assert.assertEquals(ResponseErrorEnum.DATE_DELETE_WRONG.getErrorCode(), result1.getCode());
    }

    /**
     * 查询用户列表
     */
    public void findAllPersonList() {

        // 查询成功
        BaseResponse result = personService.findAllPersonList();
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        //        // 查询失败
        //        BaseResponse result1 = personService.findAllPersonList();
        //        System.out.println(result1);
        //        Assert.assertEquals(ResponseErrorEnum.DATA_NOT_EXIST.getErrorCode(), result1.getCode());
    }
}
