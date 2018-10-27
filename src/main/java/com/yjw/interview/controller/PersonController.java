package com.yjw.interview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.interview.pojo.vo.BaseResponse;
import com.yjw.interview.pojo.vo.DeletePersonReqVO;
import com.yjw.interview.pojo.vo.FindPersonInfoReqVO;
import com.yjw.interview.pojo.vo.PersonRegisterReqVO;
import com.yjw.interview.pojo.vo.UpdatePersonInfoReqVO;
import com.yjw.interview.service.IPersonService;
import com.yjw.interview.utils.MdcUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户模块控制层
 * 
 * @description RegisterController.java
 * @author YangJianWei
 * @date 2018年10月11日 下午4:54:15
 * @version $Id: v 0.1 
 */
@RestController
@Api(tags = "用户模块")
@RequestMapping("/person")
public class PersonController {
    private static Logger  logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonService personService;

    @ApiOperation(value = "注册用户", notes = "注册用户")
    @RequestMapping(value = "/personRegist", method = RequestMethod.POST)
    public BaseResponse personRegist(@RequestBody @Validated PersonRegisterReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getName(), reqVO.getName(), "注册用户");
        logger.info("到达控制层：调用注册服务");
        return personService.personRegister(reqVO);
    }

    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
    @RequestMapping(value = "/findPersonInfo", method = RequestMethod.POST)
    public BaseResponse findPersonInfo(@RequestBody @Validated FindPersonInfoReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getId().toString(), reqVO.getId().toString(), "查询用户详情");
        logger.info("到达控制层：调用查询用户详情服务");
        return personService.findPersonInfo(reqVO);
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @RequestMapping(value = "/updatePersonInfo", method = RequestMethod.POST)
    public BaseResponse updatePersonInfo(@RequestBody @Validated UpdatePersonInfoReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getName(), reqVO.getName(), "修改用户信息");
        logger.info("到达控制层：调用修改用户信息服务");
        return personService.updatePersonInfo(reqVO);
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @RequestMapping(value = "/deletePersonInfo", method = RequestMethod.POST)
    public BaseResponse deletePersonInfo(@RequestBody @Validated DeletePersonReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getId().toString(), reqVO.getId().toString(), "删除用户信息");
        logger.info("到达控制层：调用删除用户信息服务");
        return personService.deletePerson(reqVO);
    }

}
