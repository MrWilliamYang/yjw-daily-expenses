package com.yjw.interview.service;

import com.yjw.interview.pojo.vo.BaseResponse;
import com.yjw.interview.pojo.vo.FindPersonInfoReqVO;
import com.yjw.interview.pojo.vo.PersonRegisterReqVO;

/**
 * 人物服务类
 * 
 * @description IPersonService.java
 * @author YangJianWei
 * @date 2018年10月9日 下午1:58:18
 * @version $Id: v 0.1 
 */
public interface IPersonService {

    /**
     * 人物注册服务
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
}
