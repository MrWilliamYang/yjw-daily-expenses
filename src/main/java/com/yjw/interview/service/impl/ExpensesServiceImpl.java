package com.yjw.interview.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjw.interview.common.ResponseErrorEnum;
import com.yjw.interview.pojo.entity.ExpensesEntity;
import com.yjw.interview.pojo.vo.BaseResponse;
import com.yjw.interview.pojo.vo.DeleteExpensesReqVO;
import com.yjw.interview.pojo.vo.ExpensesReqVO;
import com.yjw.interview.pojo.vo.FindAllExpensesListByReqVO;
import com.yjw.interview.pojo.vo.FindAmountByPersonIdReqVO;
import com.yjw.interview.repository.IExpensesRepository;
import com.yjw.interview.service.IExpensesService;

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
            logger.warn("数据不存在");
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("添加成功");
        return BaseResponse.success();
    }

    @Override
    public BaseResponse findAllExpensesList() {
        List<ExpensesEntity> entitys = expensesRepository.findAllExpensesList();
        if (entitys.isEmpty() || entitys == null) {
            logger.warn("数据不存在");
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
            logger.warn("数据不存在");
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
            logger.warn("删除失败,数据删除错误,Id={}", expensesId);
            return BaseResponse.error(ResponseErrorEnum.DATE_DELETE_WRONG);
        }
        logger.info("数据删除成功, 删除{}条记录！", num);
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
}
