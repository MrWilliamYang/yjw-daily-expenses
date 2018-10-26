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
import com.yjw.interview.pojo.vo.ExpensesReqVO;
import com.yjw.interview.pojo.vo.FindAllExpensesListByReqVO;
import com.yjw.interview.service.IExpensesService;
import com.yjw.interview.utils.MdcUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 花销模块控制层
 * 
 * @description ExpensesController.java
 * @author YangJianWei
 * @date 2018年10月12日 上午9:09:06
 * @version $Id: v 0.1
 */
@RestController
@Api(tags = "花销模块")
@RequestMapping("/expenses")
public class ExpensesController {
    @SuppressWarnings("unused")
    private static Logger    logger = LoggerFactory.getLogger(ExpensesController.class);

    @Autowired
    private IExpensesService expensesService;

    @ApiOperation(value = "添加花销", notes = "添加花销")
    @RequestMapping(value = "/insertExpenses", method = RequestMethod.POST)
    public BaseResponse insertExpenses(@RequestBody @Validated ExpensesReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getName(), reqVO.getAmount().toString(), "添加花销");
        return expensesService.insertExpenses(reqVO);
    }

    @ApiOperation(value = "查询花销列表", notes = "查询花销列表")
    @RequestMapping(value = "/findAllExpensesList", method = RequestMethod.POST)
    public BaseResponse findAllExpensesList() {
        return expensesService.findAllExpensesList();
    }

    @ApiOperation(value = "根据人物Id查询花销列表", notes = "根据人物Id查询花销列表")
    @RequestMapping(value = "/findAllExpensesListBy", method = RequestMethod.POST)
    public BaseResponse findAllExpensesListBy(@RequestBody @Validated FindAllExpensesListByReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getPersonId().toString(), reqVO.getPersonId().toString(),
            "根据人物 Id查询花销列表");
        return expensesService.findAllExpensesListBy(reqVO);
    }
}
