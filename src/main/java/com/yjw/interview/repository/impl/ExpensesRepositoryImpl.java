package com.yjw.interview.repository.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.yjw.interview.pojo.entity.ExpensesEntity;
import com.yjw.interview.repository.BaseRepository;
import com.yjw.interview.repository.IExpensesRepository;
import com.yjw.interview.utils.MapperUtils;

/**
 * @description ExpensesRepositoryImpl.java
 * @author YangJianWei
 * @date 2018年10月12日 上午9:50:18
 * @version $Id: v 0.1 
 */
@Repository
public class ExpensesRepositoryImpl extends BaseRepository implements IExpensesRepository {

    private RowMapper<ExpensesEntity> rowMapper = new BeanPropertyRowMapper<>(ExpensesEntity.class);

    private SimpleJdbcInsert          insertObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.insertObject = new SimpleJdbcInsert(dataSource);
        insertObject.withTableName("expenses").usingGeneratedKeyColumns("id");
    }

    /**
     * @see com.yjw.interview.repository.IExpensesRepository#saveExpenses(com.yjw.interview.pojo.entity.ExpensesEntity)
     */
    @Override
    public int saveExpenses(ExpensesEntity expensesEntity) {
        Map<String, Object> paramMap = MapperUtils.getDBProperties(expensesEntity);
        return insertObject.executeAndReturnKey(paramMap).intValue();
    }

    /**
     * @see com.yjw.interview.repository.IExpensesRepository#findAllExpensesList()
     */
    private static final String SQL_FINDALL_EXPENSESlIST = "SELECT * FROM expenses";

    @Override
    public List<ExpensesEntity> findAllExpensesList() {
        return jdbcTemplate.query(SQL_FINDALL_EXPENSESlIST, rowMapper);
    }

    /**
     * @see com.yjw.interview.repository.IExpensesRepository#findAllExpensesListBy(int)
     */
    private static final String SQL_FINDALL_EXPENSESlIST_BY = "SELECT * FROM expenses WHERE person_id = ?";

    @Override
    public List<ExpensesEntity> findAllExpensesListBy(int personId) {
        return jdbcTemplate.query(SQL_FINDALL_EXPENSESlIST_BY, new Object[] { personId },
            rowMapper);
    }

    /**
     * @see com.yjw.interview.repository.IExpensesRepository#deleteExpenses(int)
     */
    private static final String SQL_DELETE_EXPENSES = "delete FROM expenses WHERE id = ?";

    @Override
    public int deleteExpenses(int expensesId) {
        return jdbcTemplate.update(SQL_DELETE_EXPENSES, expensesId);
    }

}
