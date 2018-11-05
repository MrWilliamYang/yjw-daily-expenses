package com.yjw.expenses.service;

import com.yjw.expenses.pojo.vo.BaseResponse;
import com.yjw.expenses.pojo.vo.DeleteExpensesReqVO;
import com.yjw.expenses.pojo.vo.ExpensesReqVO;
import com.yjw.expenses.pojo.vo.FindAllExpensesListByReqVO;
import com.yjw.expenses.pojo.vo.FindAmountByPersonIdReqVO;

/**
 * 日常花销服务类
 * 
 * @description IExpensesService.java
 * @author YangJianWei
 * @date 2018年10月12日 上午9:20:36
 * @version $Id: v 0.1 
 */
public interface IExpensesService {

    /**
     * 添加日常花销
     * 
     * @param request
     * @return
     */
    BaseResponse insertExpenses(ExpensesReqVO request);

    /**
     * 查询所有日常开销列表
     * 
     * @param request
     * @return
     */
    BaseResponse findAllExpensesList();

    /**
     * 根据用户id查询花销列表
     * 
     * @param request
     * @return
     */
    BaseResponse findAllExpensesListBy(FindAllExpensesListByReqVO request);

    /**
     * 根据花销id删除花销
     * 
     * @param request
     * @return
     */
    BaseResponse deleteExpenses(DeleteExpensesReqVO request);

    /**
     * 根据用户id查询花销合计
     * 
     * @param request
     * @return
     */
    BaseResponse findAmountByPersonId(FindAmountByPersonIdReqVO request);
    
    /**
     * 删除所有花销
     * 
     * @return
     */
    BaseResponse deleteAllExpenses();
}
