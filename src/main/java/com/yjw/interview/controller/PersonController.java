package com.yjw.interview.controller;

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

    @Autowired
    private IPersonService personService;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/personRegist", method = RequestMethod.POST)
    public BaseResponse personRegist(@RequestBody @Validated PersonRegisterReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getName(), reqVO.getName(), "添加用户");
        return personService.personRegister(reqVO);
    }

    @ApiOperation(value = "查询用户详情", notes = "查询用户详情")
    @RequestMapping(value = "/findPersonInfo", method = RequestMethod.POST)
    public BaseResponse findPersonInfo(@RequestBody @Validated FindPersonInfoReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getId().toString(), reqVO.getId().toString(), "查询用户详情");
        return personService.findPersonInfo(reqVO);
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @RequestMapping(value = "/updatePersonInfo", method = RequestMethod.POST)
    public BaseResponse updatePersonInfo(@RequestBody @Validated UpdatePersonInfoReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getName(), reqVO.getName(), "修改用户信息");
        return personService.updatePersonInfo(reqVO);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/deletePersonInfo", method = RequestMethod.POST)
    public BaseResponse deletePersonInfo(@RequestBody @Validated DeletePersonReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getId().toString(), reqVO.getId().toString(), "删除用户");
        return personService.deletePerson(reqVO);
    }

    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @RequestMapping(value = "/findAllPersonList", method = RequestMethod.POST)
    public BaseResponse findAllPersonList() {
        return personService.findAllPersonList();
    }
}
