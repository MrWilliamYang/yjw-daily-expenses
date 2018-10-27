package com.yjw.interview.service;

import com.yjw.interview.pojo.vo.BaseResponse;
import com.yjw.interview.pojo.vo.DeletePersonReqVO;
import com.yjw.interview.pojo.vo.FindPersonInfoReqVO;
import com.yjw.interview.pojo.vo.PersonRegisterReqVO;
import com.yjw.interview.pojo.vo.UpdatePersonInfoReqVO;

/**
 * 用户服务类
 * 
 * @description IPersonService.java
 * @author YangJianWei
 * @date 2018年10月9日 下午1:58:18
 * @version $Id: v 0.1 
 */
public interface IPersonService {

    /**
     * 用户注册服务
     * 
     * @param request
     * @return
     */
    BaseResponse personRegister(PersonRegisterReqVO request);

    /**
     * 根据用户id查询用户详情
     * 
     * @param request
     * @return
     */
    BaseResponse findPersonInfo(FindPersonInfoReqVO request);

    /**
     * 修改用户信息
     * 
     * @param request
     * @return
     */
    BaseResponse updatePersonInfo(UpdatePersonInfoReqVO request);

    /**
     * 删除用户
     * 
     * @param request
     * @return
     */
    BaseResponse deletePerson(DeletePersonReqVO request);
    
    /**
     * 查询所有用户列表
     * 
     * @return
     */
    BaseResponse findAllPersonList();
}
