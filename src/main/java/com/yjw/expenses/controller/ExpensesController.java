package com.yjw.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.expenses.pojo.vo.BaseResponse;
import com.yjw.expenses.pojo.vo.DeleteExpensesReqVO;
import com.yjw.expenses.pojo.vo.ExpensesReqVO;
import com.yjw.expenses.pojo.vo.FindAllExpensesListByReqVO;
import com.yjw.expenses.pojo.vo.FindAmountByPersonIdReqVO;
import com.yjw.expenses.service.IExpensesService;
import com.yjw.expenses.utils.MdcUtil;

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

    @Autowired
    private IExpensesService expensesService;

    @ApiOperation(value = "添加花销", notes = "添加花销")
    @RequestMapping(value = "/insertExpenses", method = RequestMethod.POST)
    public BaseResponse insertExpenses(@RequestBody @Validated ExpensesReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getName(), reqVO.getName(), "添加花销");
        return expensesService.insertExpenses(reqVO);
    }

    @ApiOperation(value = "查询花销列表", notes = "查询花销列表")
    @RequestMapping(value = "/findAllExpensesList", method = RequestMethod.POST)
    public BaseResponse findAllExpensesList() {
        return expensesService.findAllExpensesList();
    }

    @ApiOperation(value = "根据用户Id查花销列表", notes = "根据用户Id查花销列表")
    @RequestMapping(value = "/findAllExpensesListBy", method = RequestMethod.POST)
    public BaseResponse findAllExpensesListBy(@RequestBody @Validated FindAllExpensesListByReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getPersonId().toString(), reqVO.getPersonId().toString(),
            "根据用户Id查花销列表");
        return expensesService.findAllExpensesListBy(reqVO);
    }

    @ApiOperation(value = "根据花销id删除花销", notes = "根据花销id删除花销")
    @RequestMapping(value = "/deleteExpenses", method = RequestMethod.POST)
    public BaseResponse deleteExpenses(@RequestBody @Validated DeleteExpensesReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getId().toString(), reqVO.getId().toString(),
            "根据花销id删除花销");
        return expensesService.deleteExpenses(reqVO);
    }

    @ApiOperation(value = "根据用户Id查花销合计", notes = "根据用户Id查花销合计")
    @RequestMapping(value = "/findAmountByPersonId", method = RequestMethod.POST)
    public BaseResponse findAmountByPersonId(@RequestBody @Validated FindAmountByPersonIdReqVO reqVO) {
        MdcUtil.setCallerUserMethod(reqVO.getPersonId().toString(), reqVO.getPersonId().toString(),
            "根据用户Id查花销合计");
        return expensesService.findAmountByPersonId(reqVO);
    }

    @ApiOperation(value = "删除所有花销", notes = "删除所有花销")
    @RequestMapping(value = "/deleteAllExpenses", method = RequestMethod.POST)
    public BaseResponse deleteAllExpenses() {
        return expensesService.deleteAllExpenses();
    }
}
