package com.yjw.interview.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yjw.interview.YjwInterviewQuestionsApplicationTests;
import com.yjw.interview.common.ResponseErrorEnum;
import com.yjw.interview.pojo.vo.BaseResponse;
import com.yjw.interview.pojo.vo.FindPersonInfoReqVO;
import com.yjw.interview.pojo.vo.PersonRegisterReqVO;

/**
 * 人物服务测试类
 * 
 * @author YangJianWei
 * @version $Id: PersonServiceTest.java, v 0.1 2018年10月9日 下午4:25:32 YangJianWei Exp $
 */
public class PersonServiceTest extends YjwInterviewQuestionsApplicationTests {

    @Autowired
    IPersonService personService;

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
    
    

}
