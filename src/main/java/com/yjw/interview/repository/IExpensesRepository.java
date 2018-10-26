package com.yjw.interview.repository;

import java.util.List;

import com.yjw.interview.pojo.entity.ExpensesEntity;

/**
 * 花销数据访问层
 * 
 * @description IExpensesRepository.java
 * @author YangJianWei
 * @date 2018年10月12日 上午9:48:23
 * @version $Id:  v 0.1 
 */
public interface IExpensesRepository {

    int saveExpenses(ExpensesEntity expensesEntity);

    List<ExpensesEntity> findAllExpensesList();

    List<ExpensesEntity> findAllExpensesListBy(int personId);
}
