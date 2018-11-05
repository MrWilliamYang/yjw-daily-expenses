package com.yjw.interview.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.yjw.expenses.common.ResponseErrorEnum;
import com.yjw.expenses.pojo.vo.BaseResponse;
import com.yjw.expenses.pojo.vo.DeleteExpensesReqVO;
import com.yjw.expenses.pojo.vo.ExpensesReqVO;
import com.yjw.expenses.pojo.vo.FindAllExpensesListByReqVO;
import com.yjw.expenses.pojo.vo.FindAmountByPersonIdReqVO;
import com.yjw.expenses.service.IExpensesService;

/**
 * 花销测试类
 * 
 * @description ExpensesServiceTest.java
 * @author YangJianWei
 * @date 2018年10月30日 上午9:40:57
 * @version $Id: v 0.1
 */
public class ExpensesServiceTest {

    @Autowired
    IExpensesService expensesService;

    /**
     * 添加花销
     */
    public void insertExpenses() {
        ExpensesReqVO request = new ExpensesReqVO();

        // 添加成功
        request.setAmount("4");
        request.setName("4");
        request.setPersonId(1);
        request.setPrice("4");
        request.setQuantity("4");
        BaseResponse result = expensesService.insertExpenses(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        // 添加失败
        request.setAmount("4");
        request.setName("4");
        request.setPersonId(0);
        request.setPrice("4");
        request.setQuantity("4");
        BaseResponse result1 = expensesService.insertExpenses(request);
        System.out.println(result1);
        Assert.assertEquals(ResponseErrorEnum.DATE_ADD_WRONG, result.getCode());
    }

    /**
     * 查询花销列表
     */
    public void findAllExpensesList() {

        // 查询成功
        BaseResponse result = expensesService.findAllExpensesList();
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());
    }

    /**
     * 根据id查询花销列表
     */
    public void findAllExpensesListBy() {
        FindAllExpensesListByReqVO request = new FindAllExpensesListByReqVO();

        // 查询成功
        request.setPersonId(6);
        BaseResponse result = expensesService.findAllExpensesListBy(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        // 查询失败
        request.setPersonId(0);
        BaseResponse result1 = expensesService.findAllExpensesListBy(request);
        System.out.println(result1);
        Assert.assertEquals(ResponseErrorEnum.DATA_NOT_EXIST.getErrorCode(), result1.getCode());
    }

    /**
     * 根据花销id删除花销
     */
    public void deleteExpenses() {
        DeleteExpensesReqVO request = new DeleteExpensesReqVO();

        // 删除成功
        request.setId(10);
        BaseResponse result = expensesService.deleteExpenses(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        // 删除失败
        request.setId(10);
        BaseResponse result1 = expensesService.deleteExpenses(request);
        System.out.println(result1);
        Assert.assertEquals(ResponseErrorEnum.DATE_DELETE_WRONG.getErrorCode(), result1.getCode());
    }

    /**
     * 通过 personid查询总价
     */
    public void findAmountByPersonId() {
        FindAmountByPersonIdReqVO request = new FindAmountByPersonIdReqVO();

        // 查询成功
        request.setPersonId(1);
        BaseResponse result = expensesService.findAmountByPersonId(request);
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());

        // 查询成功
        request.setPersonId(0);
        BaseResponse result1 = expensesService.findAmountByPersonId(request);
        System.out.println(result1);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());
    }

    /**
     * 删除所有花销
     */
    public void deleteAllExpenses() {
        BaseResponse result = expensesService.deleteAllExpenses();
        System.out.println(result);
        Assert.assertEquals(BaseResponse.SUCCESS_CODE, result.getCode());
    }
}
