package com.yjw.expenses.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjw.expenses.common.ResponseErrorEnum;
import com.yjw.expenses.pojo.entity.ExpensesEntity;
import com.yjw.expenses.pojo.vo.BaseResponse;
import com.yjw.expenses.pojo.vo.DeleteExpensesReqVO;
import com.yjw.expenses.pojo.vo.ExpensesReqVO;
import com.yjw.expenses.pojo.vo.FindAllExpensesListByReqVO;
import com.yjw.expenses.pojo.vo.FindAmountByPersonIdReqVO;
import com.yjw.expenses.repository.IExpensesRepository;
import com.yjw.expenses.service.IExpensesService;

/**
 * 花销服务实现类
 * 
 * @description ExpensesServiceImpl.java
 * @author YangJianWei
 * @date 2018年10月12日 上午9:46:18
 * @version $Id: v 0.1 
 */
@Service
public class ExpensesServiceImpl implements IExpensesService {

    private static final Logger logger = LoggerFactory.getLogger(IExpensesService.class);

    @Autowired
    private IExpensesRepository expensesRepository;

    @Override
    public BaseResponse insertExpenses(ExpensesReqVO request) {
        ExpensesEntity entity = new ExpensesEntity();
        Date date = new Date();
        entity.setPersonId(request.getPersonId());
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());
        entity.setAmount(request.getAmount());
        entity.setCreateTime(date);
        entity.setUpdateTime(date);
        int num = expensesRepository.saveExpenses(entity);
        if (num < 1 || num == 0) {
            logger.warn("数据添加失败，请重新添加，Name={}", request.getName());
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("添加成功");
        return BaseResponse.success();
    }

    @Override
    public BaseResponse findAllExpensesList() {
        List<ExpensesEntity> entitys = expensesRepository.findAllExpensesList();
        if (entitys.isEmpty() || entitys == null) {
            logger.warn("查询花销列表失败，数据不存在");
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("查询成功");
        return BaseResponse.success(entitys);
    }

    @Override
    public BaseResponse findAllExpensesListBy(FindAllExpensesListByReqVO request) {
        Integer personId = request.getPersonId();
        List<ExpensesEntity> entitys = expensesRepository.findAllExpensesListBy(personId);
        if (entitys.isEmpty() || entitys == null) {
            logger.warn("根据id查询花销列表失败，数据不存在，personId={}", request.getPersonId());
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("查询成功");
        return BaseResponse.success(entitys);
    }

    @Override
    public BaseResponse deleteExpenses(DeleteExpensesReqVO request) {
        Integer expensesId = request.getId();
        int num = expensesRepository.deleteExpenses(expensesId);
        if (num < 1 || num > 1) {
            logger.warn("删除失败,数据删除错误,Id={},num={}", expensesId, num);
            return BaseResponse.error(ResponseErrorEnum.DATE_DELETE_WRONG);
        }
        logger.info("数据删除成功, 删除{}条记录！删除id为{}", num, expensesId);
        return BaseResponse.success();
    }

    @Override
    public BaseResponse findAmountByPersonId(FindAmountByPersonIdReqVO request) {
        Integer personId = request.getPersonId();
        List<String> lists = expensesRepository.findAmountByPersonId(personId);
        if (lists.isEmpty() || lists == null) {
            logger.warn("查询花销合计失败,personId={}", personId);
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("查询成功");
        return BaseResponse.success(lists);
    }

    @Override
    public BaseResponse deleteAllExpenses() {
        int num = expensesRepository.deleteAllExpenses();
        if (num < 1 || num == 0) {
            logger.warn("删除失败,数据删除错误, num={}", num);
            return BaseResponse.error(ResponseErrorEnum.DATE_DELETE_WRONG);
        }
        logger.info("数据删除成功, 删除{}条记录！", num);
        return BaseResponse.success();
    }
}
